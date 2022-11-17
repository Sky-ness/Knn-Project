package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PokemonType;
import model.Pokemon_Type_Normalizer;

class PokemonTypeNormalizerTest {
	
	Pokemon_Type_Normalizer ptn;

	@BeforeEach
	void init() {
		ptn = new Pokemon_Type_Normalizer();
	}
	
	@Test
	void normalizeTest() {
		assertEquals(1/19, ptn.normalize(PokemonType.BUG));
	}
	
	@Test
	void denormalizeTest() {
		assertNull(2);
		assertEquals(PokemonType.BUG, 1/19);
	}
	
}
