package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.bean.CsvToBeanBuilder;

import model.ColumnIris;
import model.Distance;
import model.Iris;
import model.Knn;
import utils.IColumn;
import utils.IPoint;

public class testDistanceIris {
	List<IPoint> iris;
	Knn knn;
	@BeforeEach

	public void init() throws IllegalStateException, IOException {
		iris= new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get("data/iris.csv")))
				.withSeparator(',')
				.withType(Iris.class)
				.build().parse();
		knn = new Knn();
	}


	@Test
	public void TestDistanceEuclidienneIris() {
		int k = 3;
		List<IPoint> iTrieAvecColumnNorm = new ArrayList<IPoint>();
		List<IColumn> listeColumn = new ArrayList<IColumn>();
		// Faudra ajouter les bonnes colonnes
		// Ici ça sera sepal with length et petal with length
		listeColumn.add(new ColumnIris());
		
		iTrieAvecColumnNorm = knn.neighbor(k, iris.get(7),new Distance(),iris, listeColumn);
		
		List<IPoint> iTrieSansColumnNorm = new ArrayList<IPoint>();
		iTrieSansColumnNorm = neighborSansNorm(k, iris.get(7), iris);
		
		for(int i =0;i<k;i++) {
			assertEquals(iTrieSansColumnNorm.get(i), iTrieAvecColumnNorm.get(i));
		}
		

	}
	@Test
	public void TestDistanceManhattanIris() {

	}


	public List<IPoint> neighborSansNorm(int k, IPoint point,List<IPoint> list) {
		List<IPoint> test= new ArrayList<IPoint>();

		list.sort((i1,i2) -> Double.compare(DistanceManhattanIris(point,i1),DistanceManhattanIris(point,i2)));
		for(int i = 0; i < k; i++) {
			test.add(list.get(i));
		}
		return test;
	}

	public double DistanceManhattanIris(IPoint i1, IPoint i2) {
		double sepalLength=Math.abs(((Iris)i1).getSepalLength() - ((Iris)i2).getSepalLength()+0.0);
		double sepalWidth=Math.abs(((Iris)i1).getSepalWidth() - ((Iris)i2).getSepalWidth()+0.0);
		double petalLength=Math.abs(((Iris)i1).getPetalLength()- ((Iris)i2).getPetalLength()+0.0);
		double petalWidth=Math.abs(((Iris)i1).getPetalWidth()- ((Iris)i2).getPetalWidth()+0.0);

		return sepalLength+sepalWidth+petalLength+petalWidth;
	}

	public void DistanceEuclidienneIris() {
	}
}

