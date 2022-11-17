package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Boolean_Normalizer;

class Boolean_NormalizerTest {
	Boolean_Normalizer boo_normalizer;

	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		boo_normalizer = new Boolean_Normalizer();
	}
	
	
	@Test
	void testNormalise() {
		assertEquals(1.0,boo_normalizer.normalize(true));
		assertEquals(0.0,boo_normalizer.normalize(false));
	}
	
	@Test
	void testDenormalise() {
		assertEquals(true,boo_normalizer.denormalize(1.0));
		assertEquals(false,boo_normalizer.denormalize(0.0));
	}

}
