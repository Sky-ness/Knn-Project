package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Iris;
import model.IrisVariety;

class testIris {

	@Test
	void testInstantationGeneriqueSansErreur() {
		String [] parameter = new String [] {"1.1","1.1","1.1","1.1","Setosa"};
		Iris iris = new Iris(parameter);
		
		assertEquals(1.1+0.0,iris.getPetalLength());
		assertEquals(1.1+0.0,iris.getPetalWidth());
		assertEquals(1.1+0.0,iris.getSepalLength());
		assertEquals(1.1+0.0,iris.getSepalWidth());
		assertEquals(IrisVariety.Setosa,iris.getVariety());
		
		iris = new Iris( "" , "" , "" , "", "Versicolor");
		assertEquals(IrisVariety.Versicolor,iris.getVariety());
		
		iris = new Iris( "" , "" , "" , "", "Virginica");
		assertEquals(IrisVariety.Virginica,iris.getVariety());
		
	}
	
	@Test
	void testInstantationGeneriqueAvecErreur() {
		String [] parameter = new String [] {"","","","",""};
		Iris iris = new Iris(parameter);
		
		assertEquals(0.0,iris.getPetalLength());
		assertEquals(0.0,iris.getPetalWidth());
		assertEquals(0.0,iris.getSepalLength());
		assertEquals(0.0,iris.getSepalWidth());
		assertEquals(null,iris.getVariety());
		
	}
	
	void testToString() {
		Iris iris = new Iris("1.1","1.1","1.1","1.1","Setosa");

		String test = "Iris [sepalLength="+iris.getSepalLength()+", sepaiWidth="+iris.getSepalWidth()
		+", petalLength="+iris.getPetalLength()+", petalWidth="+iris.getPetalWidth()+", variety=" + iris.getVariety();
		assertEquals(test,iris.toString());
		
	}
	
	void testGetValue() {
		Iris iris = new Iris("1.1","1.1","1.1","1.1","Setosa");
		assertEquals(null,iris.getValue(null));
		
	}
	
	

}
