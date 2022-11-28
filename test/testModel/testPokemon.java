package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Column;
import model.Pokemon;
import model.PokemonType;

public class testPokemon {
	@Test
	void testInstantationGeneriqueSansErreur() {
		Pokemon pokemon = new Pokemon("Lucagod","1","1","1","1","1","1","1","1","Fire","FIGHTING","1","true");
		assertEquals("Lucagod",pokemon.getName());
		assertEquals(1,pokemon.getAttack());
		assertEquals(1,pokemon.getBaseEggSteps());
		assertEquals(1.0,pokemon.getCaptureRate());
		assertEquals(1,pokemon.getDefense());
		assertEquals(1,pokemon.getXpGrowth());
		assertEquals(1,pokemon.getHp());
		assertEquals(1,pokemon.getSpAttack());
		assertEquals(1,pokemon.getSpDefense());
		
		assertEquals(PokemonType.FIRE,pokemon.getType1());
		assertEquals(PokemonType.FIGHTING,pokemon.getType2());
		assertEquals(1.0,pokemon.getSpeed());
		assertEquals(true,pokemon.getLegendary());
	}
	
	@Test
	void testInstantationGeneriqueAvecErreur() {
		Pokemon pokemon = new Pokemon("Lucagod","","","","","","","","","","","","zzz");
		assertEquals("Lucagod",pokemon.getName());
		assertEquals(0,pokemon.getAttack());
		assertEquals(0,pokemon.getBaseEggSteps());
		assertEquals(0.0,pokemon.getCaptureRate());
		assertEquals(0,pokemon.getDefense());
		assertEquals(0,pokemon.getXpGrowth());
		assertEquals(0,pokemon.getHp());
		assertEquals(0,pokemon.getSpAttack());
		assertEquals(0,pokemon.getSpDefense());
		
		assertEquals(null,pokemon.getType1());
		assertEquals(null,pokemon.getType2());
		assertEquals(0.0,pokemon.getSpeed());
		assertEquals(false,pokemon.getLegendary());

	}
	
	@Test
	void testGetValue() {
		Pokemon pokemon = new Pokemon();
		assertEquals(null,pokemon.getValue(new Column(null, null)));
	}
}
