package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Parser;

public class AddPointView extends AbstractView{

	public DataSet datas;

	public AddPointView(Parser p) {
		datas=p.getDatas();
		Stage stage = initStage();
		VBox vb = new VBox(); 
		Button b = new Button("valider");
		b.setAlignment(Pos.CENTER);
		
		for(Column c: datas.getListeColumns()) {
			Label column = new Label(c.getName());
			TextField tf = new TextField();
			vb.getChildren().addAll(column,tf);
		}

		vb.getChildren().add(b);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

}
