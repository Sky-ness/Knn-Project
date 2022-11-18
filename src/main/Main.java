package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.DataSet;
import model.Parser;
import view.GraphView;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parser p = new Parser("Parser");
		p.loadFromFile("data/iris.csv");
		DataSet ds = p.getDatas();
		new GraphView(ds);
	}
}
