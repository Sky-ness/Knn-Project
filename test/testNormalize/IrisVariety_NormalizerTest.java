package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IrisVariety;
import model.IrisVariety_Normalizer;

class IrisVariety_NormalizerTest {

	IrisVariety_Normalizer irisvariety;

	@BeforeEach
	void init() {
		 irisvariety= new IrisVariety_Normalizer();
	}
	
	@Test
	void normalizeTest() {
		assertEquals(0.0,irisvariety.normalize(null));
		assertEquals(-1,irisvariety.normalize(0));
		assertEquals(0/(2+0.0),irisvariety.normalize(IrisVariety.Setosa));
		assertEquals(1/(2+0.0),irisvariety.normalize(IrisVariety.Versicolor));
		assertEquals(2/(2+0.0),irisvariety.normalize(IrisVariety.Virginica));
	}

	@Test
	void denormalizeTest() {
		assertEquals(IrisVariety.Setosa,irisvariety.denormalize(0/(2+0.0)));
		assertEquals(IrisVariety.Versicolor,irisvariety.denormalize(1/(2+0.0)));
		assertEquals(IrisVariety.Virginica,irisvariety.denormalize(2/(2+0.0)));
	}
}
