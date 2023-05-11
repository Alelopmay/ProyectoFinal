package org.example.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.App;
import org.example.Domain.Swimmer;
import org.example.Domain.TrialSwimmer;
import org.example.dao.TrialSwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;

public class ControlerShowTrial {
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonModify;
    @FXML
    private TableView<TrialSwimmer> TrialTableView; // Crear una variable TableView para los nadadores
    @FXML
    private TextField searchField;
    @FXML
    private TableColumn<Swimmer, Integer> IdColumn;
    @FXML
    private TableColumn<Swimmer, String> CategoryColumn;
    @FXML
    private TableColumn<Swimmer, String> StyleColumn;
    @FXML
    private TableColumn<Swimmer, String> poolTypeColumn;
    @FXML
    private TableColumn<Swimmer, String> MetersColumn;
    @FXML
    private TableColumn<Swimmer, String> SexColumn;


    /**
     * ObservableList que crea un FXcollection para mostrar un arraylist en la tabla del FXML
     */
    private ObservableList<TrialSwimmer> trialList = FXCollections.observableArrayList();

    @FXML
    private void handleButtonExit() throws IOException {
        App.setRoot("adSw");
    }

    public void initialize() {

        try {

            IdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            CategoryColumn.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
            StyleColumn.setCellValueFactory(new PropertyValueFactory<>("estilos"));
            poolTypeColumn.setCellValueFactory(new PropertyValueFactory<>("tipo_piscina"));
            MetersColumn.setCellValueFactory(new PropertyValueFactory<>("Metros"));
            SexColumn.setCellValueFactory(new PropertyValueFactory<>("Sexo"));

            TrialSwimmerDAO TDAO=new TrialSwimmerDAO();
            trialList.addAll(TDAO.findAll());

            TrialTableView.setItems(trialList);
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

