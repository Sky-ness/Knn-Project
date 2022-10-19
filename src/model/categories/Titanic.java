package model.categories;

import com.opencsv.bean.CsvBindByName;

import model.abstracts.Point;
import model.enums.Sexe;
import util.IColumn;
import util.IPoint;

public class Titanic extends Point {
	@CsvBindByName(column = "PassengerId")
	private int passengerId;
	@CsvBindByName(column = "Survived")
	private int survived;
	@CsvBindByName(column = "Pclass")
	private int Pclass;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Sex")
	private Sexe sex;
	@CsvBindByName(column = "Age")
	private int age;
	@CsvBindByName(column = "SibSp")
	private int sibSp;
	@CsvBindByName(column = "Parch")
	private int parch;
	@CsvBindByName(column = "Ticket")
	private String ticket;
	@CsvBindByName(column = "Fare")
	private double fare;
	@CsvBindByName(column = "Cabin")
	private String cabin;
	@CsvBindByName(column = "Embarked")
	private char embarked;
	public int getPassengerId() {
		return passengerId;
	}
	public int getSurvived() {
		return survived;
	}
	public int getPclass() {
		return Pclass;
	}
	public String getName() {
		return name;
	}
	public Sexe getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public int getSibSp() {
		return sibSp;
	}
	public int getParch() {
		return parch;
	}
	public String getTicket() {
		return ticket;
	}
	public double getFare() {
		return fare;
	}
	public String getCabin() {
		return cabin;
	}
	public char getEmbarked() {
		return embarked;
	}
	
	

}