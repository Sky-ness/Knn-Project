package view;


import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Iris;
import model.Parser;
import model.Pokemon;
import model.Titanic;

public class AddPointView extends AbstractView{

	public DataSet datas;

	public AddPointView(Parser p) {
		datas=p.getDatas();
		Stage stage = initStage();
		VBox vb = new VBox();
		vb.setPadding(new Insets(40,40,40,40));
		Button b = new Button("valider");
		b.setAlignment(Pos.CENTER);
		List<Label> listLbl = new ArrayList<Label>();
		List<TextField> listTf = new ArrayList<TextField>();

		for(Column c: datas.getListeColumns()) {
			Label label = new Label(c.getName());
			TextField tf =new TextField();
			listLbl.add(label);
			listTf.add(tf);
		}

		@SuppressWarnings("rawtypes")
		Class c = datas.getListePoints().get(0).getClass();
		b.setOnAction((event) -> {
			Object [] parameter = new Object [listTf.size()];
			for(int i =0;i<listTf.size();i++) {
				parameter[i]=listTf.get(i).getText();
			}


			if(c.equals(Iris.class)) {
				p.getDatas().addLine(new Iris(parameter));
				//System.out.println(new Iris(parameter));
			}

			if(c.equals(Pokemon.class)) {

			}
			
			if(c.equals(Titanic.class)) {

			}
			
			
	    });

		for(int i=0;i<listLbl.size();i++) {
			vb.getChildren().addAll(listLbl.get(i),listTf.get(i));
		}
		vb.getChildren().add(b);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

}
