package model;

import utils.IValueNormalizer;

public class SexeNormalizer implements IValueNormalizer{
	

	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		Sexe sexe;
		Sexe[] sexes = Sexe.values();
		if(Sexe.class.equals(value.getClass())) {
			sexe = (Sexe) value;
			return (double)sexe.ordinal()/(sexes.length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		Sexe sexe[] = Sexe.values();
		return sexe[(int) (value*(sexe.length-1))];
	}
}
