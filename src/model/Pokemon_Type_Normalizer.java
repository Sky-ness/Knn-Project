package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	
	// nombre de types-1
	private static final int NB_TYPES = 18;
	
	@Override
	public double normalize(Object value) {
		if(PokemonType.class.equals(value.getClass())) {
			PokemonType pt = (PokemonType) value;
			return pt.ordinal()/NB_TYPES;
		}
			
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value < 0 || value > 1)
			return null;
		PokemonType.BUG.ordinal();
		return PokemonType.values()[(int) (value * NB_TYPES)];
	}

}
