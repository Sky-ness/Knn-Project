package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Iris;
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
	
}