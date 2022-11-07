package csvReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ChargementDonneesUtil {

    public static List<FormatDonneeBrut> charger(String fileName) throws IOException {
        return new CsvToBeanBuilder<FormatDonneeBrut>(Files.newBufferedReader(Paths.get(fileName)))
                .withSeparator(';')
                .withType(FormatDonneeBrut.class)
                .build().parse();
    }
    
    public static double normaliser_0_1 (double valeur, double min, double max) {
    	return (valeur-min)/(max-min);
    }
    
    public static List<Personne> personnesNormalisees (List<FormatDonneeBrut> donnees) {
    	List<Personne> res = new ArrayList<>();
    	int min = 99999, max = 0;
    	for (FormatDonneeBrut fdb : donnees) {
			if(min > fdb.getScore())
				min = fdb.getScore();
			else if( max < fdb.getScore())
				max = fdb.getScore();
		}
    	System.out.println(max + " " + min);
    	for (FormatDonneeBrut fdb : donnees) {
    		System.out.println(normaliser_0_1(fdb.getScore(), min, max));
			res.add(new Personne(fdb.getNom() + " " + fdb.getPrenom(),
					fdb.getDateNaissance(),
					fdb.getGenre(),
					fdb.getTaille(),
					normaliser_0_1(fdb.getScore(), min, max),
					fdb.getSouscription().getV()));
		}
    	return res;
    }
}