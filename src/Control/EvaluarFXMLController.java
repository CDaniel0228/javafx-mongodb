/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Control;

import Modelo.Calificacion;
import Modelo.Producto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
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
    private SplitMenuButton listProducto;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       ObservableList data2 =  
            FXCollections.observableArrayList(  
            new Calificacion("Jacob", 1, 1, 1, 1));  
       
        caractColumn.setCellValueFactory(new PropertyValueFactory("Caracteristicas"));
        
        evalColumn.setCellValueFactory(new PropertyValueFactory("asesor"));
        
        eval2Column.setCellValueFactory(new PropertyValueFactory("tecnico"));
        //evalColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        eval3Column.setCellValueFactory(new PropertyValueFactory("ventas"));
        //evalColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        totalColumn.setCellValueFactory(new PropertyValueFactory("total"));
         
        evalColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tabla.setItems(data2);
    /*evalColumn.setOnEditCommit(data -> {
    System.out.println("Nuevo Nombre: " ); // data.getNewValue()
    System.out.println("Antiguo Nombre: "); // data.getOldValue()

});*/
        
    }    
    
    /*public void listarTabla(){

        Producto producto=new Producto();
        producto.setNombre(listaProductos.getSelectedItem().toString());
        if(!listaProductos.getSelectedItem().toString().equalsIgnoreCase("Producto")){      
            limpiarFilas(model);
            for (int i = 0; i < producto_db.buscarInformacion(producto).size(); i++) {
                model.addRow(new Object[]{producto_db.buscarInformacion(producto).get(i),1,1,1,1});
            }
        }else{
            limpiarFilas(model);
        }

    }
    
    public void limpiarFilas(DefaultTableModel model){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void listarProductos(){
        listaProductos.removeAllItems();
        listaProductos.addItem("Producto");
        for (int i = 0; i < producto_db.buscarNombre().size(); i++) {
             listaProductos.addItem(producto_db.buscarNombre().get(i));
        }
    }*/
    
}
