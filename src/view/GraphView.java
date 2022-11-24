package view;

import java.io.File;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import model.Column;
import model.Parser;
import utils.AbstractSubject;
import utils.IPoint;

@SuppressWarnings("PMD.TooManyFields")
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
	private MenuItem titanicLoadButton;
	@FXML
	private Button robustesse;
	private static final String PATHPOKEMON="data/pokemon_train.csv";
	private static final String PATHIRIS="data/iris.csv";
	private static final String PATHTITANIC="data/titanic.csv";
	
	private Column defaultXCol;
	private Column defaultYCol;
	
	private ObservableList<String> absColItems;
	private ObservableList<String> ordColItems;
	private ObservableList<Series<Double,Double>> chartData;
	
	public GraphView(Parser p){
		super(p);
		
		try {
			vb = initFxml("fxmlModel/graphique.fxml");
			
			start(PATHPOKEMON);
			
			irisLoadButton.setOnAction(e-> {
				start(PATHIRIS);
			});
			pokemonLoadButton.setOnAction(e-> {
				start(PATHPOKEMON);
			});
			titanicLoadButton.setOnAction(e-> {
				start(PATHTITANIC);
			});
			explorateur.setOnAction(e-> {
				File f = new FileChooser().showOpenDialog(this);
				if (f!=null)
					start(f.getAbsolutePath());
			});
			/*
			 * evenement
			 */
			addPoint.setOnAction(e-> new AddPointView(parser));
			pointView.setOnAction(e-> new PointView(parser));
			classification.setOnAction(e-> new ClassificationView(parser));
			robustesse.setOnAction(e-> new RobustesseView(parser));
			
			clear.setOnAction(e-> resetModel());

			eventDetachWindow(p);			
			afficher(vb);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}
		
	}
	private void start(String path) {
		resetModel();
		parser.loadFromString(path);
		loadView();
	}
	public void loadView() {
		defaultXCol = parser.defaultXCol();
		absCol.setValue(defaultXCol.getName());
		absColItems = absCol.getItems();
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				absColItems.add(c.getName());
		
		defaultYCol = parser.defaultYCol();
		ordCol.setValue(defaultYCol.getName());
		ordColItems = ordCol.getItems();
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				ordColItems.add(c.getName());
		
		pointGenerator();
		load.setOnAction(e -> pointGenerator());
	}

	private void resetModel(){
		chartData = chart.getData();
		if(absColItems != null)
			absColItems.clear();
		if(ordColItems != null)
			ordColItems.clear();
		if(chartData != null)
			chartData.clear();
	}

	private void pointGenerator(){
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());

		XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
		series1.setName(parser.getTitle());

		for(IPoint i : parser.getListPoints()) {
			series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
		}
		
		chartData.clear();
		chartData.addAll(series1);
	}
	

	@Override
	public void update(AbstractSubject subj) {
		loadView();
		System.out.println("ajout d'un point dans le graph");
	}

}
