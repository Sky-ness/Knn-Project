package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Knn;
import model.Parser;
import model.Robustesse;

public class TestRobustesse {
	
	Parser p;
	Robustesse rob;
	Knn knn;
	int k;
	@BeforeEach
	void init() {
		rob = new Robustesse();
		p = new Parser();
		k = 3 ;
		knn = new Knn();
		p.loadFromString("data/iris.csv");
	}
	
	
	@Test
	void RobustesseCalcTest() {
		assertEquals(100.0,rob.calc(p, k, knn, p.getListColumns().get(4)));
	}

}
