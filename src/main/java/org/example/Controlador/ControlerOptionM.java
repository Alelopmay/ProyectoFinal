package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;

public class ControlerOptionM {
    @FXML
    private Button ButtonAdd;
    @FXML
    private Button ButtonShow;
    @FXML
    private Button ButtonExit;

    @FXML
    private Button Buttonmodify_Mark;

    @FXML
    private void ButonAddMark() throws IOException {
        App.setRoot("add_mark");
    }
    @FXML
    private void ButonExit() throws IOException {
        App.setRoot("HOME1");
    }

}
