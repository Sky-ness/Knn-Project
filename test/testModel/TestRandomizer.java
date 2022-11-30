package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IPoint;
import model.Pokemon;
import model.Randomizer;

class testRandomizer {
	Randomizer randominzer;
	@BeforeEach
	void init() {
		randominzer = new Randomizer();
	}
	
	@Test
	void testNeighborManhattan() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("null");
		List<IPoint> pokemons = new ArrayList<IPoint>();
		pokemons.add(new Pokemon());
		
		List<IPoint> testVoisin = randominzer.neighborManhattan(1, null, pokemons, null);
		int i = 0;
		for(String s :voisin) {
			assertEquals(s,((Pokemon)testVoisin.get(i)).getName());
			i++;
		}
	}

	@Test
	void testNeighborEuclidienne() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("null");
		List<IPoint> pokemons = new ArrayList<IPoint>();
		pokemons.add(new Pokemon());
		
		List<IPoint> testVoisin = randominzer.neighborEuclidienne(1, null, pokemons, null);
		int i = 0;
		for(String s :voisin) {
			assertEquals(s,((Pokemon)testVoisin.get(i)).getName());
			i++;
		}
	}
}
