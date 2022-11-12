package view;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSet;

public class GraphView extends Stage{
	public GraphView(DataSet ds){
		Stage stage = initStage();
		try {
			VBox fxml = initFxml();
			Scene scene = initScene(fxml);
			stage.setScene(scene);
			
		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
		/*
		 * ajout des colonnes dans la comboBox
		 */
		
		/*
		 * ajout des points dans le graphique
		 */
		
		/*
		 * bouton classifier pour refresh 
		 */
		
		/*
		 * mettre un systeme de search file dans le menu file 
		 */
		
		/*
		 * mettre les colonnes sur la gauche du graphique avec des canvas de différentes couleur 
		 */
		
		stage.show();
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
        String fxmlDocPath = "fxmlModel/classification.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        VBox vbox = (VBox) loader.load(fxmlStream);
		return vbox;
	}

}
