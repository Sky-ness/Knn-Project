package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

import utils.IPoint;

@SuppressWarnings("PMD.ModifiedCyclomaticComplexity")
public class Titanic implements IPoint {
	@CsvBindByName(column = "PassengerId")
	protected int passengerId;
	@CsvBindByName(column = "Survived")
	protected int survived;
	@CsvBindByName(column = "Pclass")
	protected int pClass;
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

	@SuppressWarnings("PMD.CyclomaticComplexity")
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
			pClass= Integer.valueOf(param[2]);
		} catch (Exception e) {
			pClass=0;
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
		
		String emb = param[11].toUpperCase();
		
		Embarked [] em = Embarked.values();
		embarked=null;
		for(Embarked e: em) {

			if(emb.equalsIgnoreCase(e.name())){
				embarked = e;
			}
		}

	}


	public int getPassengerId() {return passengerId;}
	public int getSurvived() {return survived;}
	public int getPclass() {return pClass;}
	public String getName() {return name;}
	public Sexe getSex() {return sex;}
	public double getAge() {return age;}
	public int getSibSp() {return sibSp;}
	public int getParch() {return parch;}
	public String getTicket() {return ticket;}
	public double getFare() {return fare;}
	public String getCabin() {return cabin;}
	public Embarked getEmbarked() {return embarked;}
	@Override
	public Object getValue(Column col){
		Field[] fs = this.getClass().getDeclaredFields();
		String colName = col.getName();
		for(Field f : fs) {
			if(colName.equals(f.getName())){
				try {
					return f.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	@Override
	public double getNormalizedValue(Column xcol){
		return xcol.getNormalizedValue(this);
	}



}
