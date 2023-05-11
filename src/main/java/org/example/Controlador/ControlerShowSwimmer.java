package org.example.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Domain.Swimmer;
import org.example.dao.SwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ControlerShowSwimmer {
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonModify;
    @FXML
    private TableView<Swimmer> swimmerTableView; // Crear una variable TableView para los nadadores
    @FXML
    private TextField searchField;
    @FXML
    private TableColumn<Swimmer, Integer> CodColumn;
    @FXML
    private TableColumn<Swimmer, String> nameColumn;
    @FXML
    private TableColumn<Swimmer, String> lastnameColumn;
    @FXML
    private TableColumn<Swimmer, Integer> ageColumn;
    @FXML
    private TableColumn<Swimmer, String> sexColumn;
    @FXML
    private TableColumn<Swimmer, String> categoryColumn;


    /**
     * ObservableList que crea un FXcollection para mostrar un arraylist en la tabla del FXML
     */
    private ObservableList<Swimmer> swimmerList = FXCollections.observableArrayList();

    @FXML
    private void handleButtonExit() throws IOException {
        App.setRoot("adSw");
    }

    public void initialize() {

        try {

            CodColumn.setCellValueFactory(new PropertyValueFactory("Cod_Nadador"));
            nameColumn.setCellValueFactory(new PropertyValueFactory("Nombre"));
            lastnameColumn.setCellValueFactory(new PropertyValueFactory("Apellido"));
            ageColumn.setCellValueFactory(new PropertyValueFactory("Edad"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory("Categoria"));
            sexColumn.setCellValueFactory(new PropertyValueFactory("Sexo"));

            SwimmerDAO SDAO= new SwimmerDAO();
            List<Swimmer> aux = SDAO.findAll();
            swimmerList.setAll(aux);

            //swimmerList.addAll(SDAO.findAll());

            swimmerTableView.setItems(swimmerList);
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

    }






}
