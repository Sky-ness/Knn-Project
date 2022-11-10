package model;

import com.opencsv.bean.CsvBindByName;

import utils.IColumn;
import utils.IPoint;

public class Pokemon implements IPoint{

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
	PokemonType type1;
	@CsvBindByName(column = "type2")
	PokemonType type2;
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
	public PokemonType getType1() {return type1;}
	public PokemonType getType2() {return type2;}
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
		switch(col.getName()) {
		case "name":
			return name;
		case "attack":
			return attack;
		case "baseEggSteps":
			return baseEggSteps;
		case "petalWidth":
			return captureRate;
		case "defense":
			return defense;
		case "xpGrowth":
			return xpGrowth;
		case "hp":
			return hp;
		case "spAttack":
			return spAttack;
		case "spDefense":
			return spDefense;
		case "type1":
			return type1;
		case "type2":
			return type2;
		case "speed":
			return speed;
		case "legendary":
			return legendary;
		default:
			return null;
		}
	}
	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}



}