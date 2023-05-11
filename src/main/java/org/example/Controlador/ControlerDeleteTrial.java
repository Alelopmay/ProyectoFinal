package org.example.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.TrialSwimmer;
import org.example.dao.TrialSwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;

public class ControlerDeleteTrial {
    TrialSwimmerDAO daot = new TrialSwimmerDAO();

    @FXML
    private Button ButtonExit;
    @FXML
    private Button ButtonDelete;
    @FXML
    private TextField intId;

    /**
     *
     * @throws IOException
     * esta funcion es para salir y bolber a las opciones de las pruebas
     */
    @FXML
    private void ButtonExit()throws IOException {
        App.setRoot("option_manipulate_trial");
    }

    /**
     *
     * @throws IOException
     * @throws SQLException
     * esta funcion es para iniciar el deleteTrialById
     */
    @FXML
    private void ButtonDeleteTrial() throws IOException, SQLException {

       deleteTrialById();
    }

    /**
     *
     * @throws SQLException
     * esta es la funcion encargada de eliminar puebas por su id  en la base de datos
     */
    public void deleteTrialById() throws SQLException {
        int Id=Integer.parseInt(intId.getText());

        try {
            // mensage de dato eliminado de manera correcta
            TrialSwimmer swimmerToDelete = daot.findById(Id);
            if (swimmerToDelete != null) {
                daot.delete(swimmerToDelete);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Eliminar Prueba");
                alert.setHeaderText(null);
                alert.setContentText("prueba eliminada con exito");
                alert.showAndWait();
            } else {
                // mensage de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al eliminar  la prueba");
                alert.setHeaderText(null);
                alert.setContentText("Fallo al eliminar la prueba");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting Trial.");
        }
    }


    public void ButtonDeleteSwimmer(ActionEvent event) {
    }
}
