package model;

import com.opencsv.bean.CsvBindByName;

public class Titanic extends IPoint {
	@CsvBindByName(column = "PassengerId")
	protected int passengerId;
	@CsvBindByName(column = "Survived")
	protected int survived;
	@CsvBindByName(column = "Pclass")
	protected int Pclass;
	@CsvBindByName(column = "Name")
	protected String name;
	@CsvBindByName(column = "Sex")
	protected Sexe sex;
	@CsvBindByName(column = "Age")
	protected double age;
	@CsvBindByName(column = "SibSp")
	protected int sibSp;
	@CsvBindByName(column = "Parch")
	protected int parch;
	@CsvBindByName(column = "Ticket")
	protected String ticket;
	@CsvBindByName(column = "Fare")
	protected double fare;
	@CsvBindByName(column = "Cabin")
	protected String cabin;
	@CsvBindByName(column = "Embarked")
	protected Embarked embarked;
	
	public Titanic(){
		
	}
	
	public Titanic(Object ...objects){
		
	}
	
	public Titanic(int passengerId, int survived, int pclass, String name, Sexe sex, double age, int sibSp, int parch,
			String ticket, double fare, String cabin, Embarked embarked) {
		super();
		this.passengerId = passengerId;
		this.survived = survived;
		Pclass = pclass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}
	
	
	@Override
	public String toString() {
		return "Titanic [passengerId=" + passengerId + ", survived=" + survived + ", Pclass=" + Pclass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}

	public int getPassengerId() {return passengerId;}
	public int getSurvived() {return survived;}
	public int getPclass() {return Pclass;}
	public String getName() {return name;}
	public Sexe getSex() {return sex;}
	public double getAge() {return age;}
	public int getSibSp() {return sibSp;}
	public int getParch() {return parch;}
	public String getTicket() {return ticket;}
	public double getFare() {return fare;}
	public String getCabin() {return cabin;}
	public Embarked getEmbarked() {return embarked;}
}
