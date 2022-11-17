package view;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Parser;
import utils.IPoint;

public class GraphView extends Stage{
	@FXML
	private ScatterChart<Double,Double> chart;

	@FXML
	private Button Clear;

	@FXML
	private ComboBox<String> absCol;

	@FXML
	private ComboBox<String> ordCol;

	@FXML
	private Button ajoutPoint;

	@FXML
	private Button classifier;

	@FXML
	private MenuBar menu;

	public DataSet ds2;

	public GraphView(DataSet ds){
		ds2=ds;
		Parser p = new Parser();
		Stage stage = initStage();
		try {
			VBox fxml = initFxml();
			Scene scene = initScene(fxml);
			Column absSelected=p.defaultXCol();
			Column ordSelected=p.defaultXCol();
			// ajout des colonnes dans la comboBox

			absCol.setValue(p.defaultXCol().getName());
			for(Column c: ds.getListeColumns())
				absCol.getItems().add(c.getName());
			
			ordCol.setValue(p.defaultYCol().getName());
			for(Column c: ds.getListeColumns())
				ordCol.getItems().add(c.getName());

			EventHandler<ActionEvent> absSelect =
					new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e)
				{
//					absSelected = searchColumnbyName(ordCol.getValue());
				}
			};

			EventHandler<ActionEvent> ordSelect =
					new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e)
				{
//					ordSelected = searchColumnbyName(ordCol.getValue());
				}
			};
			
			absCol.setOnAction(absSelect);
			ordCol.setOnAction(ordSelect);
			
			// ajout des points dans le graphique
//
//			XYChart.Series series1 = new XYChart.Series();
//
//			if (classifier.isPressed()) {
//				for(IPoint i : ds.getListePoints()) {
//					series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
//				}
//			}
			
			stage.setScene(scene);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}

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
		loader.setController(this);
		String fxmlDocPath = "fxmlModel/classification.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		VBox vbox = (VBox) loader.load(fxmlStream);
		return vbox;
	}

	Column searchColumnbyName(String name){
		for(Column c : ds2.getListeColumns())
			if(name.equals(c.getName())) 
				return c;
		return null;
	}
}
