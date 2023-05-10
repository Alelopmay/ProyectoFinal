package org.example.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import org.example.App;
import org.example.Domain.swimmer;
import org.example.dao.SwimmerDAO;
import org.example.dao.TrialSwimmerDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.example.dao.SwimmerDAO.conn;


public class ControlerShowSwimmer {
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonModify;
    @FXML
    private TableView<swimmer> swimmerTableView; // Crear una variable TableView para los nadadores
    @FXML
    private TextField searchField;
    @FXML
    private TableColumn<swimmer, Integer> CodColumn;
    @FXML
    private TableColumn<swimmer, String> nameColumn;
    @FXML
    private TableColumn<swimmer, String> lastnameColumn;
    @FXML
    private TableColumn<swimmer, Integer> ageColumn;
    @FXML
    private TableColumn<swimmer, String> sexColumn;
    @FXML
    private TableColumn<swimmer, String> categoryColumn;

    /**
     * ObservableList que crea un FXcollection para mostrar un arraylist en la tabla del FXML
     */
    private ObservableList<swimmer> NadadoresList = FXCollections.observableArrayList();

    @FXML
    private void handleButtonExit() throws IOException {
        App.setRoot("adSw");
    }
    @FXML
    public void initialize() {
        SwimmerDAO SDAO= new SwimmerDAO();
        try {
            List<swimmer> swimmerList = SDAO.findAll();
            ObservableList<swimmer> observableSwimmerList = FXCollections.observableArrayList(swimmerList);

            CodColumn.setCellValueFactory(new PropertyValueFactory<>("Cod_Swimmer"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
            ageColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
            sexColumn.setCellValueFactory(new PropertyValueFactory<>("Sex"));

            swimmerTableView.setItems(observableSwimmerList);
        } catch (SQLException e) {
            // handle SQL exception
        }
    }
    @FXML
    private void ButtonExit()throws IOException {
        App.setRoot("adSw");
    }
    @FXML
    private void ButtonModify()throws IOException {
        initialize();
    }






}
