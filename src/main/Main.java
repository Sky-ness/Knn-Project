package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.DataSet;
import model.Iris;
import model.Parser;
import view.GraphView;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		DataSet ds = Parser.readFile("data/iris.csv", Iris.class);
		new GraphView(ds);
	}
}
