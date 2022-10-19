package pokemon;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class MethodeKnn {
	static List<Pokemon> datas;
	static double baseEggSteps;
	static double captureRate;
	static double xpGrowth;
	static double speed;
	static double normalisation;
	
	public MethodeKnn(String path) {
		try {
			datas = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get("data/pokemon_train.csv")))
	                .withSeparator(',')
	                .withType(Pokemon.class)
	                .build().parse();
			double baseEggStepsMax = 0 , baseEggStepsMin= Double.MAX_VALUE;
			double captureRateMax = 0, captureRateMin = Double.MAX_VALUE;
			double xpGrowthMax = 0, xpGrowthMin= Double.MAX_VALUE;
			double speedMax = 0, speedMin= Double.MAX_VALUE;
			for (Pokemon p : datas) {
				baseEggStepsMin = p.getBaseEggSteps() < baseEggStepsMin ?  p.getBaseEggSteps() : baseEggStepsMin;
				baseEggStepsMax = p.getBaseEggSteps() > baseEggStepsMax ?  p.getBaseEggSteps() : baseEggStepsMax;
				captureRateMin = p.getCaptureRate() < captureRateMin ? p.getCaptureRate() : captureRateMin;
				captureRateMax = p.getCaptureRate() > captureRateMax ? p.getCaptureRate() : captureRateMax;
				xpGrowthMin = p.getXpGrowth() < xpGrowthMin ? p.getXpGrowth() : xpGrowthMin;
				xpGrowthMax = p.getXpGrowth() > xpGrowthMax ? p.getXpGrowth() : xpGrowthMax;
				speedMin = p.getSpeed() < speedMin ? p.getSpeed() : speedMin;
				speedMax = p.getSpeed() > speedMax ? p.getSpeed() : speedMax;
			}
			baseEggSteps = baseEggStepsMax - baseEggStepsMin;
			captureRate = captureRateMax - captureRateMin;
			xpGrowth = xpGrowthMax - xpGrowthMin;
			speed = speedMax - speedMin;
			normalisation = baseEggSteps + captureRate + xpGrowth + speed;
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}
	
	
	public List<Pokemon> getKNN(int k, Pokemon p, double dist) {
		List<Pokemon> res = new ArrayList<>();
		Distance d = new DistanceEuclidienne();
		for (Pokemon pl : datas) {
			// divise par normalisation pour normaliser entre 0 et 1
			if(Double.compare(d.distance(pl, p)/normalisation, dist) <= 0) {
				res.add(pl);
			}
		}
		if(res.size() < k)
			return getKNN(k,p,++dist);
		// tri du plus proche au plus loin
		res.sort((p1,p2) -> Double.compare(d.distance(p1,p), d.distance(p2, p)));
		return res.subList(0, k);
	}
	
	// verifie si il y a une majorité de Légendaire dans la liste Knn
	public boolean maybeLegendary(Pokemon p, int k, double dist) {
		// Récupération de la liste de Knn
		List<Pokemon> nn = getKNN(k,p,dist);
		int nbL = 0;
		for (Pokemon pokemon : nn) {
			if(pokemon.getLegendary())
				nbL++;
		}
		return nbL/k > 0.5;
	}
	
}
