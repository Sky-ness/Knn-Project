package model;

import utils.IValueNormalizer;

public class IrisVarity_Normalizer implements IValueNormalizer{

	private static final int NB_TYPES = 2;

	@Override
	public double normalize(Object value) {
		if(IrisVariety.class.equals(value.getClass())) {
			IrisVariety iv = (IrisVariety) value;
			return (double)iv.ordinal()/NB_TYPES;
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value < 0 || value > 1)
			return null;
		IrisVariety.Setosa.ordinal();
		return IrisVariety.values()[(int) (value * NB_TYPES)];
	}



}
