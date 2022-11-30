package testNormalize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IrisVariety;
import model.IrisVarietyNormalizer;

public class IrisVariety_NormalizerTest {

	IrisVarietyNormalizer irisvariety;

	@BeforeEach
	void init() {
		 irisvariety= new IrisVarietyNormalizer();
	}
	
	@Test
	void normalizeTest() {
		assertEquals(0.0,irisvariety.normalize(null));
		assertEquals(-1,irisvariety.normalize(0));
		assertEquals(0/(2+0.0),irisvariety.normalize(IrisVariety.SETOSA));
		assertEquals(1/(2+0.0),irisvariety.normalize(IrisVariety.VERSICOLOR));
		assertEquals(2/(2+0.0),irisvariety.normalize(IrisVariety.VIRGINICA));
	}

	@Test
	void denormalizeTest() {
		assertEquals(IrisVariety.SETOSA,irisvariety.denormalize(0/(2+0.0)));
		assertEquals(IrisVariety.VERSICOLOR,irisvariety.denormalize(1/(2+0.0)));
		assertEquals(IrisVariety.VIRGINICA,irisvariety.denormalize(2/(2+0.0)));
	}
}
