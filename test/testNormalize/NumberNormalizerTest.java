package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Column;
import model.NumberNormalizer;
import model.Parser;

public class NumberNormalizerTest {
	NumberNormalizer number_norm;
	Parser p = new Parser();
	Column c;
	@BeforeEach
	void init() {
		p.loadFromString("data/iris.csv");
		c = p.getListColumns().get(0);
		number_norm= new NumberNormalizer(c);
	}

	@Test
	void denormalizeTest() {
		assertEquals(5.1,number_norm.denormalize(number_norm.normalize(p.getListPoints().get(0).getValue(c))));
		assertEquals(4.9,number_norm.denormalize(number_norm.normalize(p.getListPoints().get(1).getValue(c))));
		assertEquals(4.7,number_norm.denormalize(number_norm.normalize(p.getListPoints().get(2).getValue(c))));
	}
}
