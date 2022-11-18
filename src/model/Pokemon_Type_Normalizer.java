package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	
	// nombre de types-1
	private static final int NB_TYPES = 17;
	

	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		if(PokemonType.class.equals(value.getClass())) {
			PokemonType pt = (PokemonType) value;
			return (double)pt.ordinal()/NB_TYPES;
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
