package org.example.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.example.App;
import org.example.Domain.trialSwimmer;
import org.example.dao.TrialSwimmerDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.example.dao.SwimmerDAO.conn;

public class ControlerShowTrial {
    @FXML
    private Button ButtonExit;
    @FXML
    private TableView<trialSwimmer> trialTableView; // Crear una variable TableView para las pruebas
    @FXML
    private TextField searchField;

    @FXML
    private void ButtonExit() throws IOException {
        App.setRoot("adSw");
    }

    public void initialize() {
        showAllTrial(); // Llamar a la función showAllTrial cargar el archivo FXML
    }

    public void showAllTrial() {
        Connection conn = null;
       TrialSwimmerDAO dao=new TrialSwimmerDAO();// Crear instancia de TrialSwimmer
        try {
            List<trialSwimmer> trialSwimmers = dao.findAll();// Obtener lista de nadadores de la base de datos

            // Crear una lista observable de nadadores
            ObservableList<trialSwimmer> observableSwimmers = FXCollections.observableArrayList(trialSwimmers);

            // Asignar la lista observable de nadadores a la tabla
            trialTableView.setItems(observableSwimmers);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initializelook()throws IOException {
        // Listener para detectar cuando se presiona Enter en el campo de búsqueda
        searchField.setOnKeyPressed(e -> {
            if ((e.getCode()) == KeyCode.ENTER) {
                searchTrial();
            }
        });
    }
    public void searchTrial() {

        TrialSwimmerDAO dao=new TrialSwimmerDAO();
        try {
            int Id = Integer.parseInt(searchField.getText());
            trialSwimmer trial = dao.findById(Id);
            if ( trial!= null) {
                ObservableList<trialSwimmer> observableTrial = FXCollections.observableArrayList(trial);
                trialTableView.setItems(observableTrial);
            } else {
                trialTableView.setItems(null);
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
