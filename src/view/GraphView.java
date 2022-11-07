package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.DataSet;

public class GraphView extends Stage{
	public GraphView(DataSet ds){
		Stage s = initStage();
		HBox hb = initHbox();
		
		
	}
	public Stage initStage() {
		Stage stage = new Stage();
		stage.setTitle("Graphique");
		return stage;
	}
	public HBox initHbox() {
		HBox hbox = new HBox();
		hbox .setAlignment(Pos.CENTER);
		return hbox;
	}
}
