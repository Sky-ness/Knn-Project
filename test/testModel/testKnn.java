package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IPoint;
import model.Knn;
import model.Parser;
import model.Pokemon;

public class testKnn {
	Parser p ;
	Knn knn;
	int k;
	@BeforeEach
	void init() {
		p = new Parser();
		k = 3 ;
		knn = new Knn();
		p.loadFromString("data/pokemon_train.csv");
	}
	
	@Test
	void testNeighborManhattan() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("Dialga");
		voisin.add("Giratina");
		voisin.add("Palkia");
		voisin.add("Necrozma");
		List<IPoint> testVoisin = knn.neighborManhattan(k, p.getListPoints().get(12), p.getListPoints(), p.getListColumns());
		int i = 0;
		for(String s :voisin) {
			assertEquals(s,((Pokemon)testVoisin.get(i)).getName());
			i++;
		}
	}

	@Test
	void testNeighborEuclidienne() {
		List<String> voisin = new ArrayList<>() ;
		voisin.add("Dialga");
		voisin.add("Giratina");
		voisin.add("Palkia");
		voisin.add("Necrozma");
		List<IPoint> testVoisin = knn.neighborEuclidienne(k, p.getListPoints().get(12), p.getListPoints(), p.getListColumns());
		int i = 0;
		for(String s :voisin) {
			assertEquals(s,((Pokemon)testVoisin.get(i)).getName() );
			i++;
		}
	}

}
