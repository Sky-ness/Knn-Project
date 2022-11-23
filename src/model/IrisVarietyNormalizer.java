package model;

import utils.IValueNormalizer;

public class IrisVariety_Normalizer implements IValueNormalizer{


	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		
		if(IrisVariety.class.equals(value.getClass())) {
			IrisVariety iv = (IrisVariety) value;
			return (double)iv.ordinal()/(IrisVariety.values().length-1);
		}
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		IrisVariety[] variety = IrisVariety.values();
		return variety[(int) (value*(variety.length-1))];
	}
}
