package model;

import java.lang.reflect.Field;

import com.opencsv.bean.CsvBindByName;

public class Pokemon extends IPoint{

	@CsvBindByName(column = "name")
	protected String name;
	@CsvBindByName(column = "attack")
	protected int attack;
	@CsvBindByName(column = "base_egg_steps")
	protected int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	protected double captureRate;
	@CsvBindByName(column = "defense")
	protected int defense;
	@CsvBindByName(column = "experience_growth")
	protected int xpGrowth;
	@CsvBindByName(column = "hp")
	protected int hp;
	@CsvBindByName(column = "sp_attack")
	protected int spAttack;
	@CsvBindByName(column = "sp_defense")
	protected int spDefense;
	@CsvBindByName(column = "type1")
	protected PokemonType type1;
	@CsvBindByName(column = "type2")
	protected PokemonType type2;
	@CsvBindByName(column = "speed")
	protected double speed;
	@CsvBindByName(column = "is_legendary")
	protected boolean legendary;

	public Pokemon() {

	}

	public Pokemon(String ...param) {
		name=param[0];

		try {
			attack=Integer.valueOf(param[1]);
		} catch (Exception e) {
			attack=0;
		}

		try {
			baseEggSteps =Integer.valueOf(param[2]);
		} catch (Exception e) {
			baseEggSteps = 0;
		}

		try {
			captureRate =Double.valueOf(param[3]);
		} catch (Exception e) {
			captureRate = 0.0;
		}

		try {
			defense=Integer.valueOf(param[4]);
		} catch (Exception e) {
			defense=0;
		}

		try {
			xpGrowth=Integer.valueOf(param[5]);
		} catch (Exception e) {
			xpGrowth=0;
		}

		try {
			hp=Integer.valueOf(param[6]);
		} catch (Exception e) {
			hp=0;
		}

		try {
			spAttack=Integer.valueOf(param[7]);
		} catch (Exception e) {
			spAttack=0;
		}
		try {
			spDefense=Integer.valueOf(param[8]);
		} catch (Exception e) {
			spDefense=0;
		}


		type1=checkPokemonType(param[9]);

		type2=checkPokemonType(param[10]);
		try {
			speed =Double.valueOf(param[11]);
		} catch (Exception e) {
			speed = 0.0;
		}

		legendary = Boolean.valueOf(param[12]);

	}

	private PokemonType checkPokemonType(String type) {
		PokemonType [] listeType=PokemonType.values();
		for(PokemonType pt : listeType) {
			if(type.equalsIgnoreCase(pt.name())) {
				return pt;
			}
		}
		return null; 
	}

	
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", xpGrowth=" + xpGrowth + ", hp=" + hp + ", spAttack="
				+ spAttack + ", spDefense=" + spDefense + ", type1=" + type1 + ", type2=" + type2 + ", speed=" + speed
				+ ", legendary=" + legendary + "]";
	}

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
	public Object getValue(Column col){
		Field[] fs = this.getClass().getDeclaredFields();
		String colName = col.getName() == null ? "" : col.getName();
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