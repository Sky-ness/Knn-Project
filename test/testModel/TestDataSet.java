package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DataSet;
import model.IPoint;
import model.Iris;
import model.Parser;

public class TestDataSet {

	Parser parser;
	DataSet dataset;
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		parser = new Parser();
		parser.loadFromString("data/iris.csv");
		dataset = new DataSet(parser.getTitle(), parser.getListPoints());
		
	}
	
	@Test
	void testGetTitle() {
		assertEquals("Iris",dataset.getTitle());
	}
	
	@Test
	void testSetLine() {
		List<IPoint> test = new ArrayList<IPoint>();
		test.add(new Iris());
		dataset = new DataSet(parser.getTitle(),test);
		dataset.setLines(parser.getListPoints());
		assertEquals( parser.getListPoints(),dataset.getListPoints());
	}

	@Test
	void testAddLine() {
		Iris i = new Iris();
		dataset.addLine(i);
		assertEquals(i,dataset.getListPoints().get(dataset.getListPoints().size()-1));
	}

	@Test
	void testAddAllLine() {
		Iris i = new Iris();
		Iris i2 = new Iris();
		
		List<IPoint> lp = new ArrayList<IPoint>();
		dataset.addAllLine(lp);
	}

	@Test
	void testGetListColumns() {
		assertEquals(parser.getListColumns().toString(),dataset.getListColumns().toString());
	}
	
	@Test
	void testgetListPoints() {
		assertEquals(parser.getListPoints(),dataset.getListPoints());
	}
	
	@Test
	void getNormalizableColumns() {
		String res = "[sepalLength, sepalWidth, petalLength, petalWidth, variety]";
		assertEquals(res,dataset.getNormalizableColumns().toString());
		dataset.getNormalizableColumns();
	}
	
	@Test
	void testToString() {
		List<IPoint> iris = new ArrayList<IPoint>();
		iris.add(new Iris());
		iris.add(new Iris());
		dataset.setLines(iris);
		String res ="DataSet [title=IrisIris [sepalLength=0.0, sepalWidth=0.0, petalLength=0.0, petalWidth=0.0, variety=null]"
				+"\nIris [sepalLength=0.0, sepalWidth=0.0, petalLength=0.0, petalWidth=0.0, variety=null]"
					+	"\nListeColumns=[sepalLength, sepalWidth, petalLength, petalWidth, variety]"
;
;
		assertEquals(res,dataset.toString());
	}
	
}
