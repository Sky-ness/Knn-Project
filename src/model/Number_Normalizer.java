package model;

import java.util.List;

import utils.IValueNormalizer;

public class Number_Normalizer implements IValueNormalizer{

	protected Column column;
	
	public Number_Normalizer(Column column) {
		this.column=column;
	}
	
	public double amplitude() {
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
		return max-min;
	}
	
	@Override
	public double normalize(Object value) {
		Number d = (Number)value;
		return d.doubleValue()/this.amplitude();
	}

	@Override
	public Object denormalize(double value) {
		return value * this.amplitude();
	}

}
