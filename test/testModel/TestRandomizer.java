package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.AbstractPoint;
import model.Pokemon;
import model.Randomizer;

public class TestRandomizer {
	Randomizer randominzer;
	@BeforeEach
	void init() {
		randominzer = new Randomizer();
	}
	
	@Test
	void testNeighborManhattan() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("null");
		List<AbstractPoint> pokemons = new ArrayList<AbstractPoint>();
		pokemons.add(new Pokemon());
		
		List<AbstractPoint> testVoisin = randominzer.neighborManhattan(1, null, pokemons, null);
		int i = 0;
		for(String s :voisin) {
			assertEquals(0,((Pokemon)testVoisin.get(i)).getAttack());
			i++;
		}
	}

	@Test
	void testNeighborEuclidienne() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("null");
		List<AbstractPoint> pokemons = new ArrayList<AbstractPoint>();
		pokemons.add(new Pokemon());
		List<AbstractPoint> testVoisin = randominzer.neighborEuclidienne(1, null, pokemons, null);
		int i = 0;
		for(String s :voisin) {
			assertEquals(0,((Pokemon)testVoisin.get(i)).getAttack());
			i++;
		}
	}
}
