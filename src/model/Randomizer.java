package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AbstractClassifier;

public class Randomizer extends AbstractClassifier {

	@Override
	public List<AbstractPoint> neighborEuclidienne(int k, AbstractPoint point, List<AbstractPoint> points,
			List<Column> columns) {
		List<AbstractPoint> res = new ArrayList<AbstractPoint>();
		Collections.shuffle(points);

		for(int i=0;i<k;i++) {
			res.add(points.get(i));
		}
		return res;
	}

	@Override
	public List<AbstractPoint> neighborManhattan(int k, AbstractPoint point, List<AbstractPoint> points, List<Column> columns) {
		List<AbstractPoint> res = new ArrayList<AbstractPoint>();
		Collections.shuffle(points);

		for(int i=0;i<k;i++) {
			res.add(points.get(i));
		}
		return res;
	}


}
