package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import model.ColumnTitanic;
import model.Distance;
import model.Iris;
import model.Knn;
import model.Sexe;
import model.Titanic;
import utils.IColumn;
import utils.IPoint;

public class testDistanceTitanic {
	List<IPoint> titanic;
	Knn knn;
	@BeforeEach

	public void init() throws IllegalStateException, IOException {
		titanic= new CsvToBeanBuilder<IPoint>(Files.newBufferedReader(Paths.get("data/Titanic.csv")))
				.withSeparator(',')
				.withType(Titanic.class)
				.build().parse();
		knn = new Knn();
	}
	
	@Test
	public void TestDistanceEuclidienneTitanic() {
		int k = 3;
		List<IPoint> tTrieAvecColumnNorm = new ArrayList<IPoint>();
		List<IColumn> listeColumn = new ArrayList<IColumn>();
		// Faudra ajouter les bonnes colonnes
		// Ici ça sera 
		listeColumn.add(new ColumnTitanic());
		
		tTrieAvecColumnNorm = knn.neighbor(k, titanic.get(7),new Distance(), titanic, listeColumn);
		
		List<IPoint> tTrieSansColumnNorm = new ArrayList<IPoint>();
		tTrieSansColumnNorm = neighborSansNorm(k, titanic.get(7), titanic,true);
		
		for(int i =0;i<k;i++) {
			assertEquals(tTrieSansColumnNorm.get(i), tTrieAvecColumnNorm.get(i));
		}
		

	}
	@Test
	public void TestDistanceManhattanTitanic() {
		int k = 3;
		List<IPoint> tTrieAvecColumnNorm = new ArrayList<IPoint>();
		List<IColumn> listeColumn = new ArrayList<IColumn>();
		// Faudra ajouter les bonnes colonnes
		// Ici ça sera 
		listeColumn.add(new ColumnTitanic());
		 
		
		tTrieAvecColumnNorm = knn.neighbor(k, titanic.get(7),new Distance(), titanic, listeColumn);
		
		List<IPoint> tTrieSansColumnNorm = new ArrayList<IPoint>();
		tTrieSansColumnNorm = neighborSansNorm(k, titanic.get(7), titanic,false);
		
		for(int i =0;i<k;i++) {
			assertEquals(tTrieSansColumnNorm.get(i), tTrieAvecColumnNorm.get(i));
		}
	}


	public List<IPoint> neighborSansNorm(int k, IPoint point,List<IPoint> list,boolean manhattan) {
		List<IPoint> test= new ArrayList<IPoint>();
		if(manhattan) {
			list.sort((i1,i2) -> Double.compare(DistanceManhattanTitanic(point,i1),DistanceManhattanTitanic(point,i2)));
		} else {
			list.sort((i1,i2) -> Double.compare(DistanceEuclidienneTitanic(point,i1),DistanceEuclidienneTitanic(point,i2)));
		}
		
		for(int i = 0; i < k; i++) {
			test.add(list.get(i));
		}
		return test;
	}

	public double DistanceManhattanTitanic(IPoint i1, IPoint i2) {
		
		 int survived=Math.abs(((Titanic)i1).getSurvived() - ((Titanic)i2).getSurvived());
		 int Pclass=Math.abs(((Titanic)i1).getPclass() - ((Titanic)i2).getPclass());
		 double age=Math.abs(((Titanic)i1).getAge() - ((Titanic)i2).getAge()+0.0);
		 double fare=Math.abs(((Titanic)i1).getFare() - ((Titanic)i2).getFare()+0.0);

		return survived+Pclass+age+fare;
	}

	public double DistanceEuclidienneTitanic(IPoint i1, IPoint i2) {
		double distS = Math.pow(Math.abs(((Titanic)i1).getSurvived() - ((Titanic)i2).getSurvived() + 0.0), 2);
		double distP = Math.pow(Math.abs(((Titanic)i1).getPclass()- ((Titanic)i2).getPclass() + 0.0), 2);
		double distA = Math.pow(Math.abs(((Titanic)i1).getAge() - ((Titanic)i2).getAge()+ 0.0), 2);
		double distF = Math.pow(Math.abs(((Titanic)i1).getFare() - ((Titanic)i2).getFare() + 0.0), 2);
		return Math.sqrt(distS + distP + distA + distF);
	}
}

