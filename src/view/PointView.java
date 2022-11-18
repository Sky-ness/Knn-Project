package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.DataSet;
import model.Parser;
import utils.IPoint;

public class PointView extends AbstractView{

	public DataSet datas;

	public PointView(Parser p){
		datas=p.getDatas();
		
		Stage stage = initStage();
		VBox vb = new VBox(); 
		TableView<IPoint> table = new TableView<IPoint>();
		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();
		for(Column c: datas.getListeColumns()) {
			TableColumn column = new TableColumn(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint, String>("lastName"));
			listColumn.add(column);
		}

		table.getColumns().addAll(listColumn);
		Scene scene = initScene(vb);
		stage.setScene(scene);
		stage.show();
	}

}
