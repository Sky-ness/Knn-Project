package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Column;
import model.IPoint;
import model.Parser;
import utils.AbstractSubject;
import utils.Observer;

public class PointView extends AbstractView implements Observer{

	protected static IPoint selectedPoint ;
	private TableView<IPoint> table = new TableView<IPoint>();;
	private Button b;
	Stage stage = initStage();

	public PointView(Parser p){
		super(p);

		vb = new VBox();
		load();

		eventDetachWindow(p);
		afficher(vb);
	}

	public List<TableColumn<IPoint,?>> columnFactory() {
		List<TableColumn<IPoint,?>> listColumn = new ArrayList<>();

		for(Column c: parser.getListColumns()) {
			TableColumn<IPoint,Double> column = new TableColumn<IPoint,Double>(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<IPoint,Double>(c.getName()));
			listColumn.add(column);
		}

		return listColumn;
	}
	@Override
	public void load() {
		reset();
		initTable();
		setButton(table);

		vb.getChildren().addAll(table,b);
		vb.setAlignment(Pos.CENTER);
	}
	@Override
	public void reset() {
		if (vb.getChildren() != null)
			vb.getChildren().clear();
		if (table.getColumns() != null)
			table.getColumns().clear();
	}
	private void initTable() {
		table.setEditable(true);
		ObservableList<IPoint> data = FXCollections.observableArrayList(parser.getListPoints());		
		table.setItems(data);
		table.getColumns().addAll(columnFactory());	
	}	
	private  void setButton(TableView<IPoint> table) {
		b = new Button("selectionner un point");
		b.setOnAction(e->{
			selectedPoint = table.getSelectionModel().getSelectedItem();
			stage.close();
		});
	}

	@Override
	public void update(AbstractSubject subj) {
		load();
	}
}
