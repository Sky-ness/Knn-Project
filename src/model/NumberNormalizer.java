package model;

import java.util.List;

import utils.IValueNormalizer;

public class NumberNormalizer implements IValueNormalizer{

	protected Column column;
	
	protected boolean executed;

	protected double max; 
	protected double min;
	
	public NumberNormalizer(Column column) {
		this.column=column;
		this.executed = false;
	}

	@SuppressWarnings("PMD.LawOfDemeter")
	public double [] amplitude() {
		if(!executed) {
			List<Object> list = column.getDataset().valueByColumn(column);
			Number d = (Number)list.get(0);
			max = d.doubleValue();min = d.doubleValue();
			for(Object obj : list) {
				d = (Number)obj;
				if(d.doubleValue() > max) {
					max = d.doubleValue();
				}
				if(d.doubleValue() < min) {
					min = d.doubleValue();
				}
			}
			executed = true;
		}
		return new double [] {min,max};
	}
	
	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public double normalize(Object value) {
		Number dividende = (Number)value;
		double [] ampli = this.amplitude();
		dividende = dividende.doubleValue()-ampli[0];
		double diviseur = ampli[1]-ampli[0];
		return dividende.doubleValue()/diviseur;
	}

	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public Object denormalize(double value) {
		Number d = (Number)value;
		double [] ampli = this.amplitude();
		double diviseur = ampli[1]-ampli[0];
		d = d.doubleValue() * diviseur + ampli[0];
		return d;


	}

}
