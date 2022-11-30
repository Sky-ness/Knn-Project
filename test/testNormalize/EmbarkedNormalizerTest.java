package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Embarked;
import model.EmbarkedNormalizer;

public class EmbarkedNormalizerTest {
	EmbarkedNormalizer embarked_norm;

	@BeforeEach
	void init() {
		 embarked_norm= new EmbarkedNormalizer();
	}
	
	@Test
	void normalizeTest() {
		assertEquals(0.0,embarked_norm.normalize(null));
		assertEquals(-1,embarked_norm.normalize(0));
		assertEquals(0/(2+0.0),embarked_norm.normalize(Embarked.S));
		assertEquals(1/(2+0.0),embarked_norm.normalize(Embarked.C));
		assertEquals(2/(2+0.0),embarked_norm.normalize(Embarked.Q));
	}

	@Test
	void denormalizeTest() {
		assertEquals(null,embarked_norm.denormalize(5));
		assertEquals(Embarked.S,embarked_norm.denormalize(0/(2+0.0)));
		assertEquals(Embarked.C,embarked_norm.denormalize(1/(2+0.0)));
		assertEquals(Embarked.Q,embarked_norm.denormalize(2/(2+0.0)));
	}
}
