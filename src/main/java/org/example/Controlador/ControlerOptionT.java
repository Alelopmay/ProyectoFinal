package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;

public class ControlerOptionT {

    @FXML
    private Button ButtonAdd;
    @FXML
    private Button ButtonDelete;
    @FXML
    private Button ButtonShow;
    @FXML
    private Button ButtonExit;

    @FXML
    private Button Buttonmodify_trial;
    @FXML
    private void ButtonExit() throws IOException {
        App.setRoot("HOME1");
    }
    @FXML
    private void ButtonAdd() throws IOException {
        App.setRoot("add_trial");
    }
    @FXML
    private void ButtonDelete() throws IOException {
        App.setRoot("Delete_trial");
    }
    @FXML
    private void ButtonShow() throws IOException {
        App.setRoot("ShowTrialSwimmer");
    }
    @FXML
    private void Buttonmodify() throws IOException {
        App.setRoot("modify_trial");
    }
}
