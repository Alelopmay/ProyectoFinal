package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.MarkRecord;
import org.example.Domain.Swimmer;
import org.example.Domain.TrialSwimmer;
import org.example.dao.MarkrecordDAO;

import java.io.IOException;
import java.sql.SQLException;

public class ControlerAddMark {
    @FXML
    private Button exit;
    @FXML
    private Button ButtonAdd;
    @FXML
    private TextField IntCod;
    @FXML
    private TextField IntId;
    @FXML
    private TextField MarkTime;

    @FXML
    private void ButtonExit() throws IOException {
        App.setRoot("Option_Mark");
    }

    @FXML
    private void ButtonAdd() throws IOException {
        Add_Mark();
    }

    private void Add_Mark() throws IOException {
        Swimmer S = new Swimmer();
        TrialSwimmer T = new TrialSwimmer();
        MarkrecordDAO MDAO = new MarkrecordDAO();
        int Cod_Swimmer = Integer.parseInt(IntCod.getText());
        int Id = Integer.parseInt(IntId.getText());
        String Time = MarkTime.getText();
        try {
            Swimmer swimmer = new Swimmer();
            swimmer.setCod_Swimmer(Cod_Swimmer);

            TrialSwimmer trialSwimmer = new TrialSwimmer();
            trialSwimmer.setId(Id);

            MarkRecord M = new MarkRecord(swimmer, trialSwimmer, 0, Time, null);
            // Resto del código para guardar la marca en la base de datos
            MDAO.save(M);

        } catch (SQLException e) {
            // Error al insertar en la base de datos, mostrar alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de base de datos");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo insertar el Nadador en la base de datos.");
            alert.showAndWait();
            e.printStackTrace();
        }

    }
}
