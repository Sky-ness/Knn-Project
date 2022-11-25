package model;

import utils.IValueNormalizer;

public class EmbarkedNormalizer implements IValueNormalizer{
	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		Embarked e;
		Embarked[] embarkeds = Embarked.values();
		if(Embarked.class.equals(value.getClass())) {
			 e = (Embarked) value;
			return (double)e.ordinal()/(embarkeds.length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value > 1 || value < 0)
			return null;
		Embarked[] embarkeds = Embarked.values();
		return embarkeds[(int) (value*(embarkeds.length-1))];
	}
}
