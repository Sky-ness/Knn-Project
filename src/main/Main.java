package main;

import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import model.DataSet;
import utils.IColumn;
import utils.IPoint;
import view.GraphView;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		List<IPoint> iris = null;
		List<IColumn> colonnes = null;
		DataSet ds = new DataSet("Iris",iris,colonnes);
		new GraphView(ds);
	}
}
