package model;

import utils.IValueNormalizer;

public class Pokemon_Type_Normalizer implements IValueNormalizer{
	
	
	protected Double[] createTab() {
		PokemonType[] PkType = PokemonType.values();
		Double[] tab = new Double[PkType.length];
		for(int i = 0; i<tab.length;i++) {
			tab[i] = (double)i/(tab.length-1);
		}
		return tab;
	}
	
	@Override
	public double normalize(Object value) {
		PokemonType[] PkType = PokemonType.values();
		Double[] tab = createTab();
		int i = 0;
		for(PokemonType type : PkType){
			if(value.equals(type)) {
				return tab[i];
			}
			i++;
		}
		
		return 0;
	}

	@Override
	public Object denormalize(double value) {
		PokemonType[] PkType = PokemonType.values();
		Double[] tab = createTab();
		int i = 0;
		for(double db : tab) {
			if(value == db) {
				return PkType[i];
			}
			i++;
		}
		return null;
	}
}
