package Control;

import Modelo.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HomeController implements Initializable {
    Alertas alertas =new Alertas();
    Producto_db producto_db = new Producto_db();

    @FXML
    private Button btnAgregar;
    @FXML
    private TextArea boxDescripcion;
    @FXML
    private TextField boxNombre;
    @FXML
    private TextField boxMercadoObjetivo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClick(ActionEvent evt) {
        if (evt.getSource() == btnAgregar) {
            Producto producto = new Producto();
            producto.setNombre(boxNombre.getText());
            producto.setDescripcion(boxDescripcion.getText());
            producto.setMercadoObjetivo(boxMercadoObjetivo.getText());
            if (producto_db.registrar(producto) && !vacio()) {
                limpiar();
                alertas.informar("", "Se guardo exitosamente");
            }
        }
    }

    
    public boolean vacio() {
        return boxNombre.getText().isEmpty() || boxDescripcion.getText().isEmpty()
                || boxMercadoObjetivo.getText().isEmpty();
    }

    public void limpiar() {
        boxNombre.setText("");
        boxDescripcion.setText("");
        boxMercadoObjetivo.setText("");
    }
    

}
