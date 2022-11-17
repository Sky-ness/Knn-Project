package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	
	private static final int NB_TYPES = 19;
	
	@Override
	public double normalize(Object value) {
		if(PokemonType.class.equals(value.getClass())) {
			PokemonType pt = (PokemonType) value;
			return pt.getValue()/NB_TYPES;
		}
			
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value < 0 || value > 1)
			return null;
		return PokemonType.values()[(int) (value * NB_TYPES)];
	}

}
