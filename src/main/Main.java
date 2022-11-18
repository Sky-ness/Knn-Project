package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.GraphView;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new GraphView();
	}
}
