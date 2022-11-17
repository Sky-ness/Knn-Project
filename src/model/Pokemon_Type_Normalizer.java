package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	
	

	@Override
	public double normalize(Object value) {
		PokemonType[] PkType = PokemonType.values();
		int i = 0;
		for(PokemonType type : PkType){
			if(value.equals(type)) {
				return (double)i/(PkType.length-1);
			}
			i++;
		}
		return 0;
	}

	@Override
	public Object denormalize(double value) {
		PokemonType[] PkType = PokemonType.values();
		return PkType[(int) (value*(PkType.length-1))];
	}
	
	public static void main(String[] args) {
		Pokemon_Type_Normalizer pk = new Pokemon_Type_Normalizer();
		System.out.println(pk.normalize(PokemonType.GHOST));
		System.out.println(pk.normalize(PokemonType.DARK));
		System.out.println(pk.denormalize(0));
	}
}
