package pokemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

public class Pokemon {
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
	
	
	public static void main(String[] args) throws IllegalStateException, IOException {
		List<Pokemon> poke = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get("data/pokemon_train.csv")))
                .withSeparator(',')
                .withType(Pokemon.class)
                .build().parse();
		MethodeKnn mknn = new MethodeKnn("");
		// Récupère les 5 pokemon à une distance arbitraire de 0.002 du 1er pokemon du csv
		List<Pokemon> p = mknn.getKNN(5, poke.get(0), 0.002);
		System.out.println(mknn.maybeLegendary(poke.get(480), 10, 0.002));
		System.out.println(poke.get(480));
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

}
