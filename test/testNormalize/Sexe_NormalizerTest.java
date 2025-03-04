package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Sexe;
import model.SexeNormalizer;

public class Sexe_NormalizerTest {

	SexeNormalizer sexe_normalizer;

	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		sexe_normalizer = new SexeNormalizer();
	}
	
	
	@Test
	void testNormalise() {
		assertEquals(0.0,sexe_normalizer.normalize(null));
		assertEquals(0,sexe_normalizer.normalize(Sexe.MALE));
		assertEquals(1,sexe_normalizer.normalize(Sexe.FEMALE));
		assertEquals(-1,sexe_normalizer.normalize("zzzz"));
	}
	
	@Test
	void testDenormalise() {
		assertEquals(Sexe.MALE,sexe_normalizer.denormalize(0));
		assertEquals(Sexe.FEMALE,sexe_normalizer.denormalize(1));
	}

}
