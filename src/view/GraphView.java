package view;

import java.io.File;
import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Parser;
import utils.IPoint;

public class GraphView extends AbstractView{
	@FXML
	private ScatterChart<Double,Double> chart;

	@FXML
	private Button clear;

    @FXML
    private Button viewPoint;

	@FXML
	private Button addPoint;

	@FXML
	private Button classifier;
	
    @FXML
    private MenuItem titanicLoadButton;

    @FXML
    private MenuItem pokemonLoadButton;
    
    @FXML
    private MenuItem irisLoadButton;

	@FXML
	private ComboBox<String> absCol;

	@FXML
	private ComboBox<String> ordCol;

    @FXML
    private ComboBox<String> classMethod;

    @FXML
    private MenuItem explorateur;


    @FXML
    private Label robustesse;

	public DataSet datas;

	public GraphView(Parser p){
		datas=p.getDatas();
		Stage stage = initStage();
		try {
			VBox fxml = initFxml();
			Scene scene = initScene(fxml);
			//Column absSelected=p.defaultXCol();
			//Column ordSelected=p.defaultYCol();
			// ajout des colonnes dans la comboBox

			//absCol.setValue(absSelected.getName());
			for(Column c: datas.getListeColumns())
				absCol.getItems().add(c.getName());
			
			//ordCol.setValue(ordSelected.getName());
			for(Column c: datas.getListeColumns())
				ordCol.getItems().add(c.getName());

			classMethod.getItems().add("Randomizer");
			classMethod.getItems().add("Knn");
			
			
			absCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					
				}
			});
			ordCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					
				}
			});
			
			// ajout des points dans le graphique

			XYChart.Series series1 = new XYChart.Series();
			series1.setName("test");
			for(IPoint i : datas.getListePoints()) {
				series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
			}
			
			// évenement 
			
			irisLoadButton.setOnAction(e-> new Parser());
			pokemonLoadButton.setOnAction(e-> new Parser());
			titanicLoadButton.setOnAction(e-> new Parser());
			
			classifier.setOnAction(e-> chart.getData().addAll(series1));
			clear.setOnAction(e-> chart.getData().removeAll(series1));
			addPoint.setOnAction(e-> new AddPointView(p));
			viewPoint.setOnAction(e-> new PointView(p));
			explorateur.setOnAction(e-> {File f = new FileChooser().showOpenDialog(this);});
			
			stage.setScene(scene);
			

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
		/*
		 * mettre un systeme de search file dans le menu file 
		 */

		/*
		 * mettre les colonnes sur la gauche du graphique avec des canvas de différentes couleur 
		 */
		stage.show();
	}

	Column searchColumnbyName(String name){
		for(Column c : datas.getListeColumns())
			if(name.equals(c.getName())) 
				return c;
		return null;
	}
}
