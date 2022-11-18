package model;

import java.util.List;

import utils.IValueNormalizer;

public class Number_Normalizer implements IValueNormalizer{

	protected Column column;
	
	public Number_Normalizer(Column column) {
		this.column=column;
	}
	
	public double [] amplitude() {
		List<Object> list = column.getDataset().valueByColumn(column);
		Number d = (Number)list.get(0);
		double max = d.doubleValue(); double min = d.doubleValue();
		for(Object obj : list) {
			d = (Number)obj;
			if(d.doubleValue() > max) {
				max = d.doubleValue();
			}
			if(d.doubleValue() < min) {
				min = d.doubleValue();
			}
		}

		return new double [] {min,max};
	}
	
	@Override
	public double normalize(Object value) {
		Number dividende = (Number)value;
		double [] ampli = this.amplitude();
		dividende = dividende.doubleValue()-ampli[0];
		double diviseur = ampli[1]-ampli[0];
		return dividende.doubleValue()/diviseur;
	}

	@Override
	public Object denormalize(double value) {
		Number d = (Number)value;
		double [] ampli = this.amplitude();
		double diviseur = ampli[1]-ampli[0];
		d = d.doubleValue() * diviseur + ampli[0];
		return d;


	}

}
