package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Parser;

public class testParser {
	Parser parser;
	
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		parser = new Parser();
		parser.loadFromString("data/iris.csv");
	}
	
	
	@Test
	void testGetTitle() {
		assertEquals("Iris",parser.getTitle());
	}
	
	@Test
	void testNbLines() {
		assertEquals(150,parser.getNbLines());
	}
	
	@Test
	void testIterator() {
		assertIterableEquals(parser, parser);
	}
	
	@Test
	void testnbColumns() {
		assertEquals(5,parser.nbColumns());
	}
	
	
	@Test
	void testColumnX() {
		assertEquals("Column name=sepalLength",parser.defaultXCol().toString());

	}
	
	@Test
	void testColumnY() {
		assertEquals("Column name=sepalWidth",parser.defaultYCol().toString());
	}
	
	@Test
	void testaddPoint() {
		
	}
	
	@Test
	void testLoadFile() {
		Parser par = new Parser();
		par.loadFromString("");
		
		assertEquals("Other",par.getTitle());
		assertEquals(null,par.defaultXCol());
		assertEquals(null,par.defaultYCol());
	}
	
}
