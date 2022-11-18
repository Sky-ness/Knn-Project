package view;


import java.util.ArrayList;
import java.util.List;

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
import utils.IPoint;

public class AddPointView extends AbstractView{

	public DataSet datas;

	public AddPointView(Parser p) {
		datas=p.getDatas();
		Stage stage = initStage();
		VBox vb = new VBox(); 
		Button b = new Button("valider");
		b.setAlignment(Pos.CENTER);
		List<Label> listLbl = new ArrayList<Label>();
		List<TextField> listTf = new ArrayList<TextField>();
		
		for(Column c: datas.getListeColumns()) {
			Label column = new Label(c.getName());
			TextField tf =new TextField();
			listLbl.add(column);
			listTf.add(tf);
		}
		
//		b.setOnAction(e-> p.getDatas().addLine(new IPoint()));
		for(int i=0;i<listLbl.size();i++) {
			vb.getChildren().addAll(listLbl.get(i),listTf.get(i));
		}
		vb.getChildren().add(b);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

}