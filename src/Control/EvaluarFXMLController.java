package Control;

import Modelo.Calificacion;
import Modelo.Caracteristicas;
import Modelo.Producto;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javax.swing.table.DefaultTableModel;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class EvaluarFXMLController implements Initializable {

    double asesor = 1, tecnico = 1, ventas = 1, total = 1;
    Producto_db producto_db = new Producto_db();
    Caracteristicas_db caracteristicas_db = new Caracteristicas_db();

    @FXML
    private TableColumn caractColumn;
    @FXML
    private TableColumn evalColumn;
    @FXML
    private TableColumn eval2Column;
    @FXML
    private TableColumn eval3Column;
    @FXML
    private TableColumn totalColumn;
    @FXML
    private TableView tabla;
    @FXML
    private ComboBox listaProductos;
    @FXML
    private Button btnGuardar;
    ObservableList<Calificacion> personas;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarProductos();
        caractColumn.setCellValueFactory(new PropertyValueFactory("caracteristicas"));

        evalColumn.setCellValueFactory(new PropertyValueFactory("asesor"));
        evalColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        eval2Column.setCellValueFactory(new PropertyValueFactory("tecnico"));
        eval2Column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        eval3Column.setCellValueFactory(new PropertyValueFactory("ventas"));
        eval3Column.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        totalColumn.setCellValueFactory(new PropertyValueFactory("total"));

        /*ObservableList selectedCells = tabla.getSelectionModel().getSelectedCells();
            selectedCells.addListener(new ListChangeListener() {
                @Override
                public void onChanged(ListChangeListener.Change c) {
                    
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println(tablePosition.getRow()+" "+tablePosition.getColumn());
                    System.out.println("Selected Value " +val);
                }
            })
            tabla.setItems(selectedCells);*/
    }

    public void listarTabla() {
        if (listaProductos.getValue() != null) {
            tabla.getItems().clear();
            for (int i = 0; i < caracteristicas_db.buscarInformacion(listaProductos.getValue().toString()).size(); i++) {
                tabla.getItems().add(new Calificacion(caracteristicas_db.buscarInformacion(listaProductos.getValue().toString()).get(i).toString(), asesor, tecnico, ventas, total));
            }
        }
    }

    public void listarProductos() {
        listaProductos.getItems().clear();
        for (int i = 0; i < producto_db.buscarNombre().size(); i++) {
            listaProductos.getItems().add(producto_db.buscarNombre().get(i));
        }
    }

    @FXML
    private void onClick(ActionEvent e) {
        if (e.getSource().equals(btnGuardar)) {
        } else if (e.getSource().equals(listaProductos)) {
            listarTabla();
        }
    }

    @FXML
    private void onCambio(TableColumn.CellEditEvent e) {
        if (e.getSource().equals(evalColumn)) {
            ObservableList selectedCells = tabla.getSelectionModel().getSelectedCells();
            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
            tecnico=(double) tablePosition.getTableColumn().getCellData(tablePosition.getRow());
            total=(asesor + tecnico + ventas) / 3;
            List<Calificacion> lista = tabla.getSelectionModel().getSelectedItems();
            System.out.println(lista.get(0).getCaracteristicas());
            tabla.getItems().set(tablePosition.getRow(), new Calificacion("dd", asesor, tecnico, ventas, total));
            System.out.println(tablePosition.getRow());
            asesor = (double) e.getNewValue();
        } else if (e.getSource().equals(eval2Column)) {
            tecnico = (double) e.getNewValue();
        } else if (e.getSource().equals(eval3Column)) {
            ventas = (double) e.getNewValue();
        }
        total = (asesor + tecnico + ventas) / 3;
        System.out.println(total);

    }

    public void getTablaPersonasSeleccionada() {
        if (tabla != null) {

        }

    }

}
