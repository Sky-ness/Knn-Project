package model;

import utils.IValueNormalizer;

public class PokemonTypeNormalizer implements IValueNormalizer{
	
	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		PokemonType pt;
		PokemonType[] pokemonTypes = PokemonType.values();
		if(PokemonType.class.equals(value.getClass())) {
			 pt = (PokemonType) value;
			return (double)pt.ordinal()/(pokemonTypes.length-1);
		}	
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value > 1 || value < 0)
			return null;
		PokemonType[] pkType = PokemonType.values();
		return pkType[(int) (value*(pkType.length-1))];
	}
}
