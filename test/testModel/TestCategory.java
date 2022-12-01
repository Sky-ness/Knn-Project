package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;
import model.Column;
import model.IPoint;
import model.Iris;
import model.Parser;

public class TestCategory {

	Category cat;
	
	@BeforeEach
	void init() {
		cat = new Category("Cat", new ArrayList<>(),new ArrayList<Column>());
	}
	
	@Test
	void testInit() {
		List<IPoint> pts = new ArrayList<>();
		pts.add(new Iris("1", "1", "1", "1", "SETOSA"));
		cat.addAllLine(pts);
		assertEquals("Cat", cat.getTitle());
		assertEquals(1, cat.getNbLines());

		assertEquals(pts.toString(), cat.getListPoints().toString());
		assertNull(cat.getListColumns());
	}
	
	@Test
	void testSetter() {
		List<IPoint> pts = new ArrayList<>();
		pts.add(new Iris("10", "10", "10", "10", "VERSICOLOR"));
		
		assertNotEquals(pts.toString(), cat.getListPoints().toString());
		cat.setLines(pts);
		assertEquals(pts.toString(), cat.getListPoints().toString());
	}
	
	@Test
	void testAdd() {
		List<IPoint> pts = new ArrayList<>();
		pts.add(new Iris("1", "1", "1", "1", "SETOSA"));
		pts.add(new Iris("10", "10", "10", "10", "VERSICOLOR"));
		assertNotEquals(pts.toString(), cat.getListPoints().toString());
		cat.addAllLine(pts);
		assertEquals(pts.toString(), cat.getListPoints().toString());
		
		Iris ir = new Iris("2", "2", "2", "2", "VIRGINICA");
		pts.add(ir);
		cat.addLine(ir);
		assertEquals(pts.toString(), cat.getListPoints().toString());
	}
	
	@Test
	void testIterator() {
		while(cat.iterator().hasNext())
		assertEquals(cat.iterator().next(), cat.iterator());
	}

	@Test
	void testToString() {
		assertEquals("Category [title=Cat]", cat.toString());
	}
	
	@Test
	void testGetterCol() {
		assertEquals(new ArrayList<Column>(), cat.getListeColumns());
	}
	
	@Test
	void testSetterCol() {
		Parser p = new Parser();
		p.loadFromString("data/iris.csv");
		cat.setListeColumns(p.getListColumns());
		assertEquals(p.getListColumns(), cat.getListeColumns());
	}


}
