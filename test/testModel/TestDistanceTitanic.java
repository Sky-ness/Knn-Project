package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Distance;
import model.Parser;

public class testDistanceTitanic {
	Parser parser = new Parser();
	Distance distance;
	
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		parser.loadFromString("data/titanic.csv");
		distance = new Distance();
	}
	
	@Test
	public void TestDistanceManhattanPokemon() {
		assertEquals(0.0,distance.distanceManhattan(parser.getListPoints().get(0),parser.getListPoints().get(1), parser.getListColumns()));
		assertEquals(0.0,distance.distanceManhattan(parser.getListPoints().get(0),parser.getListPoints().get(2), parser.getListColumns()));
		assertEquals(0.0,distance.distanceManhattan(parser.getListPoints().get(0),parser.getListPoints().get(3), parser.getListColumns()));

		
	}
	

	@Test
	public void TestDistanceEuclidiennePokemon() {
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListPoints().get(0),parser.getListPoints().get(1), parser.getListColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListPoints().get(0),parser.getListPoints().get(2), parser.getListColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(parser.getListPoints().get(0),parser.getListPoints().get(3), parser.getListColumns()));
		
	}
}

