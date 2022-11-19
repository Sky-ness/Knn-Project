package model;

import utils.IValueNormalizer;

public class Sexe_Normalizer implements IValueNormalizer{
	private static final int NB_TYPES = 2;

	@Override
	public double normalize(Object value) {
		if(Sexe.class.equals(value.getClass())) {
			Sexe iv = (Sexe) value;
			return (double)iv.ordinal()/NB_TYPES;
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value < 0 || value > 1)
			return null;
		Sexe.MALE.ordinal();
		return Sexe.values()[(int) (value * NB_TYPES)];
	}
}
