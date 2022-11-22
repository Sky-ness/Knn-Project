package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	

	@Override
	public double normalize(Object value) {
		if(value==null) {
			return 0;
		}
		if(PokemonType.class.equals(value.getClass())) {
			PokemonType pt = (PokemonType) value;
			return (double)pt.ordinal()/(PokemonType.values().length-1);
		}
		
			
		return -1;
	}

	@Override
	public Object denormalize(double value) {
		if(value > 1 || value < 0)
			return null;
		PokemonType[] PkType = PokemonType.values();
		return PkType[(int) (value*(PkType.length-1))];
	}
}
