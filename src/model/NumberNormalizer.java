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
		amplitude();
	}

	@SuppressWarnings("PMD.LawOfDemeter")
	public void amplitude() {
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
	}
	
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public double normalize(Object value) {
		Number dividende = (Number)value;
		dividende = dividende.doubleValue()-min;
		double diviseur = max-min;
		return dividende.doubleValue()/diviseur;
	}

	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public Object denormalize(double value) {
		Number d = (Number)value;
		double diviseur = max-min;
		d = d.doubleValue() * diviseur + min;
		return d;


	}

}
