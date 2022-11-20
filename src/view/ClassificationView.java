package view;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSet;
import model.Distance;
import model.Knn;
import model.Parser;
import model.Randomizer;
import utils.IPoint;
import utils.Observer;
import utils.Subject;

public class ClassificationView extends AbstractView implements Observer{
	@FXML
	private Button buttonSelectPoint;
	@FXML
	private ComboBox<String> classMethod;
	@FXML
	private Button classifier;
	@FXML
	private ComboBox<String> distance;
	@FXML
	private Slider neighborSlider;
	@FXML
	private Label labelSelectPoint;
    @FXML
    private Label testVoisin1;
    @FXML
    private Label testVoisin2;
    @FXML
    private Label testVoisin3;

	private DataSet datas;

	public ClassificationView(Parser p) {

		datas =p.getDatas();
		Stage stage = initStage();
		try {
			VBox fxml = initFxml("fxmlModel/classification.fxml");
			Scene scene = initScene(fxml);
			classMethod.setValue("KNN");
			classMethod.getItems().add("KNN");
			classMethod.getItems().add("Randomizer");

			
			buttonSelectPoint.setOnAction(e-> new PointView(p));
			labelSelectPoint.setOnMouseClicked(e-> labelSelectPoint.setText(PointView.selectedPoint.toString()));
			classifier.setOnAction(e-> {
				/*
				 *TODO Point View en static a update pour l'actualisé sur toutes les vues
				 *TODO Graphique a update quand on appuie sur la classification 
				 */
				List<IPoint> voisin = modelClassification(classMethod.getValue(),PointView.selectedPoint,new Distance(),(int) neighborSlider.getValue());
				testVoisin1.setText(voisin.get(1).toString());
				testVoisin2.setText(voisin.get(2).toString());
				testVoisin3.setText(voisin.get(3).toString());
			
			});
			stage.setScene(scene);
		}catch(Exception e) {e.printStackTrace();}
		stage.show();
	}
	/*
	 * retourne la liste des voisins les plus proches
	 */
	private List<IPoint> modelClassification(String classification, IPoint point, Distance distance,int voisin) {
		if (classification.equals("KNN")) {
			Knn k = new Knn();
			return k.neighbor(voisin, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		if (classification.equals("Randomizer")) {
			Randomizer r = new Randomizer();
			return r.neighbor(voisin, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		return null;
	}
	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Subject subj, Object data) {
		// TODO Auto-generated method stub
		
	}
}
