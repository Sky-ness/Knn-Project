package model;

import java.util.List;

import utils.IColumn;
import utils.IValueNormalizer;

public class Number_Normalizer implements IValueNormalizer{

	protected Column column;
	
	public double amplitude() throws Exception {
		List<Object> list = column.getDataset().valueByColumn(column);
		double max = (double)list.get(0); double min = (double)list.get(0);
		for(Object obj : list) {
			if((double)obj > max) {
				max = (double)obj;
			}
			if((double)obj < min) {
				min = (double)obj;
			}
		}
		return max-min;
	}
	
	@Override
	public double normalize(Object value) throws Exception {
		return (double)value/this.amplitude();
	}

	@Override
	public Object denormalize(double value) throws Exception {
		return value * this.amplitude();
	}

}
