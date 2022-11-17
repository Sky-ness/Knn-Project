package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSet;
import model.Distance;
import model.Iris;
import model.Knn;
import model.Parser;
import model.Titanic;
import utils.IPoint;

public class testDistanceTitanic {
	DataSet ds;
	Distance distance;
	
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		ds = Parser.readFile("data/titanic.csv", Titanic.class);
		distance = new Distance();
	}
	
	@Test
	public void TestDistanceManhattanPokemon() {
		assertEquals(0.0,distance.distanceManhattan(ds.getListePoints().get(0),ds.getListePoints().get(1), ds.getListeColumns()));
		assertEquals(0.0,distance.distanceManhattan(ds.getListePoints().get(0),ds.getListePoints().get(2), ds.getListeColumns()));
		assertEquals(0.0,distance.distanceManhattan(ds.getListePoints().get(0),ds.getListePoints().get(3), ds.getListeColumns()));

		
	}
	

	@Test
	public void TestDistanceEuclidiennePokemon() {
		assertEquals(0.0,distance.distanceEuclidienne(ds.getListePoints().get(0),ds.getListePoints().get(1), ds.getListeColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(ds.getListePoints().get(0),ds.getListePoints().get(2), ds.getListeColumns()));
		assertEquals(0.0,distance.distanceEuclidienne(ds.getListePoints().get(0),ds.getListePoints().get(3), ds.getListeColumns()));
		
	}
}

