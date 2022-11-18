package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

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

	public Pokemon() {
		
	}
	
	public Pokemon(String name, int attack, int baseEggSteps, double captureRate, int defense, int xpGrowth, int hp,
			int spAttack, int spDefense, PokemonType type1, PokemonType type2, double speed, boolean legendary) {
		super();
		this.name = name;
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.xpGrowth = xpGrowth;
		this.hp = hp;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.type1 = type1;
		this.type2 = type2;
		this.speed = speed;
		this.legendary = legendary;
	}
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
	public Object getValue(Column col){
		Field[] fs = this.getClass().getDeclaredFields();
		for(Field f : fs) {
			if(f.getName().equals(col.getName())){
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