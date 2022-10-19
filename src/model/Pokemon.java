package model;

import com.opencsv.bean.CsvBindByName;

import pokemon.Type;
import util.IColumn;
import util.IPoint;

public class Pokemon extends Point{
	
	@CsvBindByName(column = "name")
	String name;
	@CsvBindByName(column = "attack")
	int attack;
	@CsvBindByName(column = "base_egg_steps")
	int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	double captureRate;
	@CsvBindByName(column = "defense")
	int defense;
	@CsvBindByName(column = "experience_growth")
	int xpGrowth;
	@CsvBindByName(column = "hp")
	int hp;
	@CsvBindByName(column = "sp_attack")
	int spAttack;
	@CsvBindByName(column = "sp_defense")
	int spDefense;
	@CsvBindByName(column = "type1")
	Type type1;
	@CsvBindByName(column = "type2")
	Type type2;
	@CsvBindByName(column = "speed")
	double speed;
	@CsvBindByName(column = "is_legendary")
	boolean legendary;
	

	// Getters
	public String getName() {return name;}
	public int getAttack() {return attack;}
	public int getBaseEggSteps() {return baseEggSteps;}
	public double getCaptureRate() {return captureRate;}
	public int getDefense() {return defense;}
	public int getXpGrowth() {return xpGrowth;}
	public int getHp() {return hp;}
	public int getSpAttack() {return spAttack;}
	public int getSpDefense() {return spDefense;}
	public Type getType1() {return type1;}
	public Type getType2() {return type2;}
	public double getSpeed() {return speed;}
	public boolean getLegendary() {return legendary;}


	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", attack=" + attack + ", base=" + baseEggSteps + ", captureRate=" + captureRate
				+ ", defense=" + defense + ", xpGrowth=" + xpGrowth + ", hp=" + hp + ", spAttack=" + spAttack
				+ ", spDefense=" + spDefense + ", type1=" + type1 + ", type2=" + type2 + ", speed=" + speed
				+ ", legendary=" + legendary + "]";
	}
	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}



}