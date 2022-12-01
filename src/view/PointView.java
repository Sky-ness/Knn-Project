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
import model.AbstractPoint;
import model.Column;
import model.Parser;
import utils.AbstractSubject;
import utils.Observer;

public class PointView extends AbstractView implements Observer{

	protected static AbstractPoint selectedPoint ;
	private TableView<AbstractPoint> table = new TableView<AbstractPoint>();;
	private Button button;

	public PointView(Parser p){
		super(p);

		vb = new VBox();
		load();

		eventDetachWindow(p);
		afficher(vb);
	}

	public List<TableColumn<AbstractPoint,?>> columnFactory() {
		List<TableColumn<AbstractPoint,?>> listColumn = new ArrayList<>();

		for(Column c: parser.getListColumns()) {
			TableColumn<AbstractPoint,Double> column = new TableColumn<AbstractPoint,Double>(c.getName());
			column.setMinWidth(100);
			column.setCellValueFactory(new PropertyValueFactory<AbstractPoint,Double>(c.getName()));
			listColumn.add(column);
		}

		return listColumn;
	}
	@Override
	public void load() {
		reset();
		initTable();
		setButton(table);

		vb.getChildren().addAll(table,button);
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
		ObservableList<AbstractPoint> data = FXCollections.observableArrayList(parser.getListPoints());		
		table.setItems(data);
		table.getColumns().addAll(columnFactory());	
	}	
	private  void setButton(TableView<AbstractPoint> table) {
		button = new Button("selectionner un point");
		button.setOnAction(e->{
			selectedPoint = table.getSelectionModel().getSelectedItem();
			stage.close();
		});
	}

	@Override
	public void update(AbstractSubject subj) {
		load();
	}
}
