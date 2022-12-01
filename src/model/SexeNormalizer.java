package model;

import utils.IValueNormalizer;

public class SexeNormalizer implements IValueNormalizer{
	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		Sexe sexe;
		Sexe[] Sexes = Sexe.values();
		if(Sexe.class.equals(value.getClass())) {
			 sexe = (Sexe) value;
			return (double)sexe.ordinal()/(Sexes.length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value > 1 || value < 0)
			return null;
		Sexe[] Sexes = Sexe.values();
		return Sexes[(int) (value*(Sexes.length-1))];
	}
}
