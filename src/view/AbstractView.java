package view;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSet;
import model.Parser;
import utils.Observer;

public abstract class AbstractView extends Stage implements Observer{
		
	protected Parser parser;
	
	public AbstractView(Parser p) {
		this.parser=p;
		parser.attach(this);
		
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
	public VBox initFxml(String path)throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		FileInputStream fxmlStream = new FileInputStream(path);
		return (VBox) loader.load(fxmlStream);
	}
}
