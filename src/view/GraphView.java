package view;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphView extends Stage{
	public GraphView(/*DataSet ds*/){
		Stage stage = initStage();
		try {
			VBox fxml = initFxml();
			Scene scene = initScene(fxml);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	public Stage initStage() {
		Stage stage = new Stage();
		stage.setTitle("Graphique");
		return stage;
	}
	public Scene initScene(VBox vbox) {
		Scene scene = new Scene(vbox);
		return scene;
	}
	public VBox initFxml()throws IOException{
		FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "classification.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		VBox vbox = (VBox) loader.load(fxmlStream);
		return vbox;
	}

}
