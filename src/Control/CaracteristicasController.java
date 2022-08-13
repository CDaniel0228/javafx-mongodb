package Control;

import Modelo.Caracteristicas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CaracteristicasController implements Initializable {
    Caracteristicas_db caracteristicas_db=new Caracteristicas_db();
    Producto_db producto_db = new Producto_db();
    Alertas alertas =new Alertas();


    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnModificar;
    @FXML
    private ComboBox listaProductos;
    @FXML
    private TextArea boxDescripcion;
    @FXML
    private TextField boxNombre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listarProductos();
    }


    @FXML
    private void onClick(ActionEvent e) {
        if (e.getSource().equals(btnGuardar)) {
            Caracteristicas caracteristicas=new Caracteristicas();
            caracteristicas.setProducto(listaProductos.getValue().toString());
            caracteristicas.setNombre(boxNombre.getText());
            caracteristicas.setDescripcion(boxDescripcion.getText());
            if(caracteristicas_db.registrar(caracteristicas) && !vacio()){
                alertas.informar("", "Se guardo exitosamente");
                limpiar();
            }
        } else if (e.getSource().equals(btnModificar)) {

        }
    }
    
    public boolean vacio() {
        return boxNombre.getText().isEmpty() || boxDescripcion.getText().isEmpty()
                || listaProductos.getValue()==null;
    }

    public void limpiar() {
        boxNombre.setText("");
        boxDescripcion.setText("");
        listaProductos.setValue("");
    }
    
    public void listarProductos() {
        listaProductos.getItems().clear();
        for (int i = 0; i < producto_db.buscarNombre().size(); i++) {
            listaProductos.getItems().add(producto_db.buscarNombre().get(i));
        }
    }

}
