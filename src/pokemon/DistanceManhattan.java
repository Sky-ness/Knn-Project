package pokemon;

public class DistanceManhattan implements Distance {

	@Override
	public double distance(Pokemon p1, Pokemon p2) {

		return (p1.getBaseEggSteps() - p2.getBaseEggSteps()) 
				+ (p1.getCaptureRate() - p2.getCaptureRate())
				+ (p1.getSpeed() - p2.getSpeed())
				+ (p1.getXpGrowth() - p2.getXpGrowth());

	}

}
