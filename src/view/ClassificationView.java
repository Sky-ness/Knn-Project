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

public class ClassificationView extends AbstractView{
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

	private DataSet datas;

	public ClassificationView(Parser p) {

		datas =p.getDatas();
		Stage stage = initStage();
		try {
			VBox fxml = initFxml("fxmlModel/classification.fxml");
			Scene scene = initScene(fxml);
			classMethod.setValue("KNN");
			classMethod.getItems().add("Randomizer");
			classMethod.getItems().add("KNN");
			
			buttonSelectPoint.setOnAction(e-> new PointView(p));
			labelSelectPoint.setOnMouseClicked(e-> labelSelectPoint.setText(PointView.selectedPoint.toString()));
			classifier.setOnAction(e-> {
				/*
				 * point View en static a changer pour l'actualisé sur toutes les vues
				 */
				modelClassification(classMethod.getValue(),PointView.selectedPoint,new Distance(),(int) neighborSlider.getValue());
			});
			stage.setScene(scene);
		}catch(Exception e) {e.printStackTrace();}
		stage.show();
	}
	/*
	 * retourne la liste des voisins les plus proches
	 */
	private List<IPoint> modelClassification(String classification, IPoint point, Distance distance,int voisin) {
		if (classification.equals("Knn")) {
			Knn k = new Knn();
			return k.neighbor(voisin, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		if (classification.equals("Randomizer")) {
			Randomizer r = new Randomizer();
			return r.neighbor(voisin, point, distance, datas.getListePoints(), datas.getListeColumns());
		}
		return null;
	}
}
