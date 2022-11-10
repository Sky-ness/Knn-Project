package testModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.bean.CsvToBeanBuilder;

import pokemon.Pokemon;

public class testDistancePokemon {
	
	@BeforeEach
	public void init() throws IllegalStateException, IOException {
		List<Pokemon> pokemon = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get("data/pokemon_train.csv")))
                .withSeparator(',')
                .withType(Pokemon.class)
                .build().parse();
		
	}
	@Test
	public void DistancePokemon() {
		
	}
}
