package model;

import utils.IValueNormalizer;

public class IrisVarietyNormalizer implements IValueNormalizer{

	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		IrisVariety[] values = IrisVariety.values();
		int length = values.length;
		IrisVariety iv;
		if(IrisVariety.class.equals(value.getClass())) {
			iv = (IrisVariety) value;
			int ordinal = iv.ordinal();
			return (double)ordinal/(length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		IrisVariety[] variety = IrisVariety.values();
		return variety[(int) (value*(variety.length-1))];
	}
}
