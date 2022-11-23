package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Column;
import model.Embarked;
import model.Sexe;
import model.Titanic;

class testTitanic {
	
	@Test
	void testInstantationGeneriqueSansErreur() {
		Titanic titanic = new Titanic("1","0","3","Sir Faker","MALE","26.0","1","0","Goat","7.25","y","C");
		assertEquals(1,titanic.getPassengerId());
		assertEquals(0,titanic.getSurvived());
		assertEquals(3,titanic.getPclass());
		assertEquals("Sir Faker",titanic.getName());
		assertEquals(Sexe.MALE,titanic.getSex());
		assertEquals(26.0,titanic.getAge());
		assertEquals(1,titanic.getSibSp());
		assertEquals(0,titanic.getParch());
		assertEquals("Goat",titanic.getTicket());
		assertEquals(7.25,titanic.getFare());
		assertEquals("y",titanic.getCabin());
		assertEquals(Embarked.C,titanic.getEmbarked());
	}
	
	@Test
	void testInstantationGeneriqueAvecErreur() {
		Titanic titanic = new Titanic("","","","","","","","","","","","");
		assertEquals(0,titanic.getPassengerId());
		assertEquals(0,titanic.getSurvived());
		assertEquals(0,titanic.getPclass());
		assertEquals("",titanic.getName());
		assertEquals(null,titanic.getSex());
		assertEquals(0,titanic.getAge());
		assertEquals(0,titanic.getSibSp());
		assertEquals(0,titanic.getParch());
		assertEquals("",titanic.getTicket());
		assertEquals(0,titanic.getFare());
		assertEquals("",titanic.getCabin());
		assertEquals(null,titanic.getEmbarked());
		Titanic titanic2 = new Titanic("","","","","","","","","","","","S");
		assertEquals(Embarked.S,titanic2.getEmbarked());
		Titanic titanic3 = new Titanic("","","","","","","","","","","","Q");
		assertEquals(Embarked.Q,titanic3.getEmbarked());
	}
	
	@Test
	void testGetValue() {
		Titanic titanic = new Titanic();
		assertEquals(null,titanic.getValue(new Column(null, null)));
	}

}
