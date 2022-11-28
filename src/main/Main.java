package main;

import Controller.GraphView;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Parser;

@SuppressWarnings("PMD.ShortClassName")
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parser p = new Parser();
		new GraphView(p);
	}
}
