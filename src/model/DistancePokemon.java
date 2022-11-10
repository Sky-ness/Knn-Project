package model;

import utils.IDistance;
import utils.IPoint;

public class DistancePokemon implements IDistance{

	@Override
	public double distanceEuclidienne(IPoint i1, IPoint i2 ) {
		return Math.sqrt(Math.pow(((Pokemon)i1).getBaseEggSteps() - ((Pokemon)i2).getBaseEggSteps(), 2)
				+ Math.pow(((Pokemon)i1).getCaptureRate() - ((Pokemon)i2).getCaptureRate(), 2) 
				+ Math.pow(((Pokemon)i1).getSpeed() - ((Pokemon)i2).getSpeed(), 2)
				+ Math.pow(((Pokemon)i1).getXpGrowth() - ((Pokemon)i2).getXpGrowth(), 2));
	}

	@Override
	public double distanceManhattan(IPoint i1, IPoint i2) {
		return (((Pokemon)i1).getBaseEggSteps() - ((Pokemon)i2).getBaseEggSteps()) 
				+ (((Pokemon)i1).getCaptureRate() - ((Pokemon)i2).getCaptureRate())
				+ (((Pokemon)i1).getSpeed() - ((Pokemon)i2).getSpeed())
				+ (((Pokemon)i1).getXpGrowth() - ((Pokemon)i2).getXpGrowth());
	}


}
