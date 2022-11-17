package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Column;
import model.DataSet;
import model.Distance;
import model.Knn;
import model.Parser;
import model.Pokemon;
import utils.IPoint;

public class testDistancePokemon {
	DataSet ds;
	List<IPoint> pokemon;
	Knn knn;
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		ds = Parser.readFile("data/pokemon_train.csv", Pokemon.class);
		knn= new Knn();
	}
	
	@Test
	public void TestDistanceManhattanPokemon() {
		int k = 3;
		List<IPoint> pTrieAvecColumnNorm = new ArrayList<IPoint>();
		List<Column> listeColumn = ds.getListeColumns();

		pTrieAvecColumnNorm = knn.neighbor(k,pokemon.get(12) ,new Distance(),pokemon,listeColumn);
		
		List<IPoint> pTrieSansColumnNorm = new ArrayList<IPoint>();
		pTrieSansColumnNorm = neighborSansNorm(k,pokemon.get(12),pokemon,true);
		
		
		for(int i =0;i<k;i++) {
			assertEquals(pTrieSansColumnNorm.get(i), pTrieAvecColumnNorm.get(i));
		}
		
	}
	

	@Test
	public void TestDistanceEuclidiennePokemon() {
		int k = 3;
		List<IPoint> pTrieAvecColumnNorm = new ArrayList<IPoint>();
		List<Column> listeColumn = ds.getListeColumns();

		pTrieAvecColumnNorm = knn.neighbor(k,pokemon.get(12) ,new Distance(),pokemon,listeColumn);
		
		
		
		List<IPoint> pTrieSansColumnNorm = new ArrayList<IPoint>();
		pTrieSansColumnNorm = neighborSansNorm(k,pokemon.get(12),pokemon,false);
		
		
		for(int i =0;i<k;i++) {
			assertEquals(pTrieSansColumnNorm.get(i), pTrieAvecColumnNorm.get(i));
		}
		
	}
	
	
	
	public List<IPoint> neighborSansNorm(int k, IPoint point,List<IPoint> list,boolean manhattan) {
	List<IPoint> test= new ArrayList<IPoint>();
	
	if(manhattan) {
		list.sort((i1,i2) -> Double.compare(DistanceManhattanPokemon(point,i1),DistanceManhattanPokemon(point,i2)));
	} else {
		list.sort((i1,i2) -> Double.compare(DistanceEuclidiennePokemon(point,i1),DistanceEuclidiennePokemon(point,i2)));
	}

	for(int i = 0; i < k; i++) {
		test.add(list.get(i));
	}
	return test;
}
	
	public double DistanceManhattanPokemon(IPoint i1, IPoint i2) {
		double speed =Math.abs(((Pokemon)i1).getSpeed() - ((Pokemon)i2).getSpeed()+0.0) ;
		double baseEgg = Math.abs(((Pokemon)i1).getBaseEggSteps() - ((Pokemon)i2).getBaseEggSteps()+0.0) ;
		double exp =Math.abs(((Pokemon)i1).getXpGrowth() - ((Pokemon)i2).getXpGrowth()+0.0) ;
		double capture=Math.abs(((Pokemon)i1).getCaptureRate() - ((Pokemon)i2).getCaptureRate() +0.0) ;
		
		return speed+baseEgg+exp+capture;
	}
	
	public double DistanceEuclidiennePokemon(IPoint i1, IPoint i2) {
        double distB = Math.pow(Math.abs(((Pokemon)i1).getBaseEggSteps() - ((Pokemon)i2).getBaseEggSteps() + 0.0), 2);
        double distE = Math.pow(Math.abs(((Pokemon)i1).getXpGrowth() - ((Pokemon)i2).getXpGrowth() + 0.0), 2);
        double distS = Math.pow(Math.abs(((Pokemon)i1).getSpeed() - ((Pokemon)i2).getSpeed() + 0.0), 2);
        double distC = Math.pow(Math.abs(((Pokemon)i1).getCaptureRate() - ((Pokemon)i2).getCaptureRate() + 0.0), 2);
        return Math.sqrt(distB + distE + distC + distS);
	}
	
}
