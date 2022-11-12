package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

import utils.IColumn;
import utils.IPoint;

public class Titanic implements IPoint {
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
	private double age;
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
	public char getEmbarked() {return embarked;}
	@Override
	public Object getValue(IColumn col) throws IllegalArgumentException, IllegalAccessException {
		Field[] fs = this.getClass().getFields();
		for(Field f : fs) {
			if(f.getName().equals(col.getName())){
				return f.get(this);
			}
		}
		return null;
		
		/*
		switch(col.getName()) {
		case "passengerId":
			return passengerId;
		case "survived":
			return survived;
		case "Pclass":
			return Pclass;
		case "name":
			return name;
		case "sex":
			return sex;
		case "age":
			return age;
		case "sibSp":
			return sibSp;
		case "parch":
			return parch;
		case "ticket":
			return ticket;
		case "fare":
			return fare;
		case "cabin":
			return cabin;
		case "embarked":
			return embarked;
		default:
			return null;
		}
		*/
	}
	@Override
	public double getNormalizedValue(IColumn xcol) {
		return xcol.getNormalizedValue(this);
	}



}
