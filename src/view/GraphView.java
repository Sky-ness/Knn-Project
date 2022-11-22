package view;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Column;
import model.Parser;
import utils.IPoint;
import utils.Subject;

public class GraphView extends AbstractView {
	@FXML
	private ComboBox<String> absCol;
	@FXML
	private MenuItem addPoint;
	@FXML
	private ScatterChart<Double,Double> chart;
	@FXML
	private Button classification;
	@FXML
	private Button clear;
	@FXML
	private MenuItem explorateur;
	@FXML
	private MenuItem irisLoadButton;
	@FXML
	private Button load;
	@FXML
	private ComboBox<String> ordCol;
	@FXML
	private MenuItem pointView;
	@FXML
	private MenuItem pokemonLoadButton;
	@FXML
	private Label robustesse;
	@FXML
	private ProgressBar robustesseBar;
	@FXML
	private MenuItem titanicLoadButton;

	private final String pathPokemon="data/pokemon_train.csv";
	private final String pathIris="data/iris.csv";
	private final String pathTitanic="data/titanic.csv";
	
	public GraphView(Parser p){
		super(p);
		/*
		 *TODO update le dataSet des qu'on load un autre model au lieu d'utiliser un parser en paramètre 
		 */
		
		Stage stage = initStage();
		try {
			VBox fxml = initFxml("fxmlModel/graphique.fxml");
			Scene scene = initScene(fxml);
			
			start(pathPokemon);
			
			irisLoadButton.setOnAction(e-> {
				start(pathIris);
			});
			pokemonLoadButton.setOnAction(e-> {
				start(pathPokemon);
			});
			titanicLoadButton.setOnAction(e-> {
				start(pathTitanic);
			});
			explorateur.setOnAction(e-> {
				File f = new FileChooser().showOpenDialog(this);
				if (f!=null)
					start(f.getAbsolutePath());
			});
			addPoint.setOnAction(e-> new AddPointView(parser));
			pointView.setOnAction(e-> new PointView(parser));
			classification.setOnAction(e-> new ClassificationView(parser));
			clear.setOnAction(e-> resetModel());
			stage.setScene(scene);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
		stage.show();
	}
	private void start(String path) {
		resetModel();
		parser.loadFromString(path);
		loadView();
	}
	public void loadView() {

		absCol.setValue(parser.defaultXCol().getName());
		for(Column c: parser.getListeColumns())
			if(c.isNormalizable())
				absCol.getItems().add(c.getName());

		ordCol.setValue(parser.defaultYCol().getName());
		for(Column c: parser.getListeColumns())
			if(c.isNormalizable())
				ordCol.getItems().add(c.getName());
		pointGenerator();
		load.setOnAction(e -> pointGenerator());
		robustesseBar.setProgress(0.50);
	}

	private void resetModel(){
		absCol.getItems().clear();
		ordCol.getItems().clear();
		chart.getData().clear();
	}

	private void pointGenerator(){
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());

		XYChart.Series series1 = new XYChart.Series();
		series1.setName(parser.getTitle());

		for(IPoint i : parser.getListePoints()) {
			series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
		}
		
		chart.getData().clear();
		chart.getData().addAll(series1);
	}

	private Column searchColumnbyName(String name){
		for(Column c : parser.getListeColumns())
			if(name.equals(c.getName())) 
				return c;
		return null;
	}
	@Override
	public void update(Subject subj) {
		loadView();
		System.out.println("ajout d'un point dans le graph");
	}

}
