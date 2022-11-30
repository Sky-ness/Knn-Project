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

	
	public Titanic(String ...param){
		try {
			passengerId = Integer.valueOf(param[0]);
		} catch (Exception e) {
			passengerId = 0;
		}

		try {
			survived= Integer.valueOf(param[1]);
		} catch (Exception e) {
			survived=0;
		}


		try {
			Pclass= Integer.valueOf(param[2]);
		} catch (Exception e) {
			Pclass=0;
		}

		name = param[3];


		Sexe [] se = Sexe.values();
		sex = null;
		for(Sexe s:se) {
			if(s.name().equalsIgnoreCase(param[4])) {
				sex = s;
			}
		}

		try {
			age = Double.valueOf(param[5]);
		} catch (Exception e) {
			age = 0.0;
		}

		try {
			sibSp = Integer.valueOf(param[6]);
		} catch (Exception e) {
			sibSp = 0;
		}

		try {
			parch = Integer.valueOf(param[7]);
		} catch (Exception e) {
			parch = 0;
		}

		ticket = param[8];

		try {
			fare= Double.valueOf(param[9]);
		} catch (Exception e) {
			fare=0.0;
		}

		cabin = param[10];
		Character [] valideEmbaked = new Character [] {'S','C','Q'};

		embarked=0;
		Character emb = param[10].toUpperCase().charAt(0);
		for(Character c:valideEmbaked) {
			if(c.equals(emb)) {
				embarked=c;
			}

		}





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
