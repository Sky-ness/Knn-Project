package model;

import com.opencsv.bean.CsvBindByName;

import util.IColumn;
import util.IPoint;
import util.Sexe;

public class Titanic {
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
	

}
