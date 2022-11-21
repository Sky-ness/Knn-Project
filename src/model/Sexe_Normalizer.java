package model;

import utils.IValueNormalizer;

public class Sexe_Normalizer implements IValueNormalizer{
	

	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		if(Sexe.class.equals(value.getClass())) {
			Sexe sexe = (Sexe) value;
			return (double)sexe.ordinal()/(Sexe.values().length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		Sexe sexe[] = Sexe.values();
		return sexe[(int) (value*(sexe.length-1))];
	}
}
