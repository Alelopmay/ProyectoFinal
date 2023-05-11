package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.Swimmer;
import org.example.dao.SwimmerDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class ControlerDeleteSwimmer {
    private Connection conn;
    SwimmerDAO SDAO=new SwimmerDAO();

    @FXML
    private Button ButtonDeleteSwimmer;
    @FXML
    private Button ButtonExit;

    @FXML
    private TextField IntCod_Swimmer;

    /**
     *
     * @throws IOException
     * esta es la funcion para usar el boton que inicializa el DeleteSwimmer
     */
    @FXML
    private void ButtonDeleteSwimmer()throws IOException {
        DeleteSwimmer();
    }

    /**
     *
     * @throws IOException
     * esta funcion es para el boton para salir de el DeleteSwimmer para volver a las opciones del nadador
     */
    @FXML
    private void ButtonExit()throws IOException {
        App.setRoot("AdSw");
    }

    /**
     * esta funcion es la encargada de eliminar el nadador de la base de datos
     */
    private void DeleteSwimmer() {
        int cod_Swimmer = Integer.parseInt(IntCod_Swimmer.getText());
        try {
            Swimmer swimmerToDelete = SDAO.findById(cod_Swimmer);
            if (swimmerToDelete != null) {
                //mensage de dato eliminado de manera correcta
                SDAO.delete(swimmerToDelete);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar Nadador");
                alert.setHeaderText(null);
                alert.setContentText("Nadador eliminado con exito");
                alert.showAndWait();
            } else {
                //mensaje error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al eliminar el nadador");
                alert.setHeaderText(null);
                alert.setContentText("Fallo al eliminar el nadador");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting swimmer.");
        }
    }
}
