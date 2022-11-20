package view;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.IPoint;

public class AbstractView extends Stage{
		
	public Stage initStage() {
		Stage stage = new Stage();
		stage.setTitle("Graphique");
		return stage;
	}
	public Scene initScene(VBox vbox) {
		Scene scene = new Scene(vbox);
		return scene;
	}
	public VBox initFxml(String path)throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		FileInputStream fxmlStream = new FileInputStream(path);
		VBox vbox = (VBox) loader.load(fxmlStream);
		return vbox;
	}
}
