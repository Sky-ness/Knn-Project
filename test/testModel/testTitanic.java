package testModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Column;
import model.Embarked;
import model.NullObject;
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
		assertEquals(null,titanic.getName());
		assertEquals(null,titanic.getSex());
		assertEquals(0,titanic.getAge());
		assertEquals(0,titanic.getSibSp());
		assertEquals(0,titanic.getParch());
		assertEquals(null,titanic.getTicket());
		assertEquals(0,titanic.getFare());
		assertEquals(null,titanic.getCabin());
		assertEquals(null,titanic.getEmbarked());
	}
	
	@Test
	void testGetValue() {
		Titanic titanic = new Titanic();
		assertEquals(new NullObject().toString(), titanic.getValue(new Column(null, null)).toString());
	}
	
	@Test
	void testToString() {
		Titanic titanic = new Titanic("1","0","3","Sir Faker","MALE","26.0","1","0","Goat","7.25","y","C");
		String res = "Titanic [passengerId=1, survived=0, Pclass=3, name=Sir Faker, sex=MALE, age=26.0, sibSp=1, parch=0, ticket=Goat, fare=7.25, cabin=y, embarked=C]"
;		
		assertEquals(res,titanic.toString());
	}

}
