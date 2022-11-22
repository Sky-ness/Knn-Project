package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSet;
import model.Distance;
import model.Parser;
import model.Pokemon;

public class testDistancePokemon {
	Parser parser = new Parser();
	Distance distance;
	
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		parser.loadFromString("data/pokemon_train.csv");
		distance = new Distance();
	}
	
	@Test
	public void TestDistanceManhattanPokemon() {
		assertEquals(0.0,distance.distanceManhattan(parser.getListePoints().get(0),parser.getListePoints().get(1), parser.getListeColumns()));
		assertEquals(0.0,distance.distanceManhattan(parser.getListePoints().get(0),parser.getListePoints().get(2), parser.getListeColumns()));
		assertEquals(0.0,distance.distanceManhattan(parser.getListePoints().get(0),parser.getListePoints().get(3), parser.getListeColumns()));


		
	}
	

	@Test
	public void TestDistanceEuclidiennePokemon() {
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListePoints().get(0),parser.getListePoints().get(1), parser.getListeColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListePoints().get(0),parser.getListePoints().get(2), parser.getListeColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListePoints().get(0),parser.getListePoints().get(3), parser.getListeColumns()));
		
	}
	
	
}
