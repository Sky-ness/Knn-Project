package model;

public enum PokemonType {
	BUG(1),DARK(2),DRAGON(3),ELECTRIC(4),FAIRY(5),
	FIGHTING(6),FIRE(7),FLYING(8),GHOHST(9),GRASS(10),
	GROUND(11),ICE(12),NORMAL(13),POISON(14),PSYCHIC(15),
	ROCK(16),STEEL(17),WATER(18),GHOST(19);

	double value;
	
	PokemonType(int i) {
		value = i;
	}

	double getValue() {
		return value;
	}
	
}
