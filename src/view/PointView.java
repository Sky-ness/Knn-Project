package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Parser;
import model.Test;
import utils.IPoint;

public class PointView extends AbstractView{


	public PointView(Parser p){
		
	    final ObservableList<IPoint> data = FXCollections.observableArrayList(p.getDatas().getListePoints());
		
		Stage stage = initStage();
		VBox vb = new VBox(); 
		TableView<IPoint> table = new TableView<IPoint>();
		table.setEditable(true);
		
		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();
		for(Column c: p.getDatas().getListeColumns()) {
			TableColumn column = new TableColumn(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint,Double>(c.getName()));
			listColumn.add(column);
		}
		
		table.setItems(data);
		table.getColumns().addAll(listColumn);
		vb.getChildren().add(table);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

}
