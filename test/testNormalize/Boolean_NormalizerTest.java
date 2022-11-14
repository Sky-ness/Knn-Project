package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.Boolean_Normalizer;

class Boolean_NormalizerTest {
	Boolean_Normalizer boo_normalizer;

	
	public void init() throws IllegalStateException, IOException {
		boo_normalizer = new Boolean_Normalizer();
	}
	@Test
	void testNormalise() {
		assertEquals(true,boo_normalizer.normalize(true));
		assertEquals(false,boo_normalizer.normalize(false));
	}
	
	@Test
	void testDenormalise() {
		assertEquals(1,boo_normalizer.normalize(true));
		assertEquals(0,boo_normalizer.normalize(false));
	}

}
