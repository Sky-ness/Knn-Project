package main;

import java.util.List;

import model.DataSet;
import utils.IPoint;
import view.GraphView;

public class main {
	public static void main(String[] args) {
		List<IPoint> iris = null;
		DataSet ds = new DataSet("Iris",iris); 
		new GraphView(ds);
	}
}
