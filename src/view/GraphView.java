package view;

import java.io.File;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.Column;
import model.Parser;
import utils.AbstractSubject;
import utils.IPoint;

@SuppressWarnings("PMD.TooManyFields")
public class GraphView extends AbstractView {
	@FXML
	private MenuItem explorateur;
	@FXML
	private MenuItem irisLoadButton;
	@FXML
	private MenuItem pokemonLoadButton;
	@FXML
	private MenuItem titanicLoadButton;
	@FXML
	private MenuItem addPoint;
	@FXML
	private MenuItem pointView;
	@FXML
	private ComboBox<String> absCol;
	@FXML
	private ComboBox<String> ordCol;
	@FXML
	private ScatterChart<Double,Double> chart;
	@FXML
	private Button clear;
	@FXML
	private Button load;
	@FXML
	private Button classification;
	@FXML
	private Button robustesse;
	@FXML
	private Label easterEgg;

	private static final String PATHPOKEMON="data/pokemon_train.csv";
	private static final String PATHIRIS="data/iris.csv";
	private static final String PATHTITANIC="data/titanic.csv";

	private Column defaultXCol;
	private Column defaultYCol;

	//	private ObservableList<String> absColItems;
	//	private ObservableList<String> ordColItems;
	//
	//	private ObservableList<Series<Double,Double>> chartData;

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

			addPoint.setOnAction(e-> new AddPointView(parser));
			pointView.setOnAction(e-> new PointView(parser));
			classification.setOnAction(e-> new ClassificationView(parser));
			robustesse.setOnAction(e-> new RobustesseView(parser));
			clear.setOnAction(e-> chart.getData().clear());
			easterEgg.setOnMouseClicked(e-> easterEgg.setText("vous avez un sacré petard mr Delecroix"));

			eventDetachWindow(p);			
			afficher(vb);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}

	}
	private void start(String path) {
		parser.loadFromString(path);
		load();
	}

	@Override
	public void load() {
		reset();

		//		defaultXCol = parser.defaultXCol();
		//		absCol.setValue(defaultXCol.getName());
		//		absColItems = absCol.getItems();
		//		for(Column c: parser.getListColumns())
		//			if(c.isNormalizable())
		//				absColItems.add(c.getName());

		defaultXCol = parser.defaultXCol();
		absCol.setValue(defaultXCol.getName());
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				absCol.getItems().add(c.getName());

		defaultYCol = parser.defaultYCol();
		ordCol.setValue(defaultYCol.getName());
		for(Column c: parser.getListColumns())
			if(c.isNormalizable())
				ordCol.getItems().add(c.getName());

		//		defaultYCol = parser.defaultYCol();
		//		ordCol.setValue(defaultYCol.getName());
		//		ordColItems = ordCol.getItems();
		//		for(Column c: parser.getListColumns())
		//			if(c.isNormalizable())
		//				ordColItems.add(c.getName());

		pointGenerator();
		load.setOnAction(e -> pointGenerator());
	}
	@Override
	public void reset(){
		//		chartData = chart.getData();
		//		if(absColItems != null)
		//			absColItems.clear();
		//		if(ordColItems != null)
		//			ordColItems.clear();
		//		if(chartData != null)
		//			chartData.clear();
	}

	private void pointGenerator(){
		Column absSelected=searchColumnbyName(absCol.getValue());
		Column ordSelected=searchColumnbyName(ordCol.getValue());

		XYChart.Series<Double, Double> series1 = new XYChart.Series<Double, Double>();
		series1.setName(parser.getTitle());

		for(IPoint i : parser.getListPoints()) {
			series1.getData().add(new XYChart.Data<Double, Double>(absSelected.getNormalizedValue(i),ordSelected.getNormalizedValue(i)));
		}
		chart.getData().clear();
		chart.getData().addAll(series1);
		
		for (Data<Double, Double> entry : series1.getData()) {                
			Tooltip t = new Tooltip(absSelected.getName() + "=" + absSelected.getDenormalizedValue(entry.getXValue()).toString() 
									+ "    "
									+ ordSelected.getName() +"=" + ordSelected.getDenormalizedValue(entry.getYValue()).toString());
			Tooltip.install(entry.getNode(), t);
		}
	}

	@Override
	public void update(AbstractSubject subj) {
		load();
		System.out.println("update le graph");
	}

}
