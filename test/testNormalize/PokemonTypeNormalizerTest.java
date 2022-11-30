package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PokemonType;
import model.PokemonTypeNormalizer;

public class PokemonTypeNormalizerTest {
	
	PokemonTypeNormalizer pokemon_type_normalizer;

	@BeforeEach
	void init() {
		pokemon_type_normalizer = new PokemonTypeNormalizer();
	}
	
	@Test
	void normalizeTest() {
		assertEquals(0, pokemon_type_normalizer.normalize(null));
		assertEquals(-1, pokemon_type_normalizer.normalize(151));
		assertEquals(1/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.DARK));
		assertEquals(2/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.DRAGON));
		assertEquals(3/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.ELECTRIC));
		assertEquals(4/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.FAIRY));
		assertEquals(5/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.FIGHTING));
		assertEquals(6/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.FIRE));
		assertEquals(7/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.FLYING));
		assertEquals(8/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.GRASS));
		assertEquals(9/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.GROUND));
		assertEquals(10/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.ICE));
		assertEquals(11/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.NORMAL));
		assertEquals(12/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.POISON));
		assertEquals(13/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.PSYCHIC));
		assertEquals(14/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.ROCK));
		assertEquals(15/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.STEEL));
		assertEquals(16/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.WATER));
		assertEquals(17/(17+0.0), pokemon_type_normalizer.normalize(PokemonType.GHOST));

	}

	@Test
	void denormalizeTest() {
		assertEquals(null, pokemon_type_normalizer.denormalize(10));
		assertEquals(PokemonType.DARK, pokemon_type_normalizer.denormalize(1/(17+0.0)));
		assertEquals(PokemonType.DRAGON, pokemon_type_normalizer.denormalize(2/(17+0.0)));
		assertEquals(PokemonType.ELECTRIC, pokemon_type_normalizer.denormalize(3/(17+0.0)));
		assertEquals(PokemonType.FAIRY, pokemon_type_normalizer.denormalize(4/(17+0.0)));
		assertEquals(PokemonType.FIGHTING,  pokemon_type_normalizer.denormalize(5/(17+0.0)));
		assertEquals(PokemonType.FIRE, pokemon_type_normalizer.denormalize(6/(17+0.0)));
		assertEquals(PokemonType.FLYING, pokemon_type_normalizer.denormalize(7/(17+0.0)));
		assertEquals(PokemonType.GRASS, pokemon_type_normalizer.denormalize(8/(17+0.0)));
		assertEquals(PokemonType.GROUND, pokemon_type_normalizer.denormalize(9/(17+0.0)));
		assertEquals(PokemonType.ICE, pokemon_type_normalizer.denormalize(10/(17+0.0)));
		assertEquals(PokemonType.NORMAL, pokemon_type_normalizer.denormalize(11/(17+0.0)));
		assertEquals(PokemonType.POISON, pokemon_type_normalizer.denormalize(12/(17+0.0)));
		assertEquals(PokemonType.PSYCHIC, pokemon_type_normalizer.denormalize(13/(17+0.0)));
		assertEquals(PokemonType.ROCK, pokemon_type_normalizer.denormalize(14/(17+0.0)));
		assertEquals(PokemonType.STEEL, pokemon_type_normalizer.denormalize(15/(17+0.0)));
		assertEquals(PokemonType.WATER, pokemon_type_normalizer.denormalize(16/(17+0.0)));
		assertEquals(PokemonType.GHOST, pokemon_type_normalizer.denormalize(17/(17+0.0)));
	}
	
}
