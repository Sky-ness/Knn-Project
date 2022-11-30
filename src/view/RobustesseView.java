package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import model.Column;
import model.Parser;
import model.Robustesse;
import utils.AbstractClassifier;
import utils.AbstractSubject;

public class RobustesseView extends AbstractView{
	@FXML
	private ComboBox<String> colonne;
	@FXML
	private ComboBox<String> distance;
	@FXML
	private ComboBox<String> classification;
	@FXML
	private ProgressBar robustesseBar;
	@FXML
	private Label robustesseIndicator;
	@FXML
	private Slider neighborSlider;
	@FXML
	private Button valider;

	public RobustesseView(Parser p) {
		super(p);

		try {
			vb = initFxml("fxmlModel/robustesse.fxml");

			load();
			valider.setOnAction(e-> afficherRobustesse(p));

			eventDetachWindow(p);
			afficher(vb);

		} catch (IOException e) {
			System.err.println("Erreur au chargement: " +e.getMessage());
		}

	}
	public void afficherRobustesse(Parser p) {
		Robustesse r = new Robustesse();
		AbstractClassifier a = ChooseClassifier(classification.getValue());
		Column c = searchColumnbyName(colonne.getValue());

		robustesseBar.setProgress(r.calc(p,(int)neighborSlider.getValue(),a,c)/100.0);
		robustesseIndicator.setText(""+r.calc(p,(int)neighborSlider.getValue(),a,c)+"%");
	}
	@Override
	public void reset() {
		colonne.getItems().clear();
		distance.getItems().clear();
		classification.getItems().clear();
	}
	@Override
	public void load() {
		reset();
		initComboBoxClassification(classification);
		initComboBoxDistance(distance);
		for(Column c: parser.getListColumns()) {
			colonne.getItems().add(c.getName());
		}
	}
	@Override
	public void update(AbstractSubject subj) {
		load();
		System.out.println("update robustesse");
	}
}
