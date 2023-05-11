package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.*;
import org.example.dao.TrialSwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;

import static org.example.Domain.Meters.*;
import static org.example.Domain.Meters.M1500;
import static org.example.Domain.SEX.*;
import static org.example.Domain.category.*;
import static org.example.Domain.pool_type.Pool25;
import static org.example.Domain.pool_type.Pool50;
import static org.example.Domain.style.*;
import static org.example.Domain.style.Espalda;

public class ControlerModifyTrialSwimmer {

    @FXML
    private Button ButtonModify;

    @FXML
    private TextField IdInt;
    @FXML
    private Button ButtonExit;
    @FXML
    private ChoiceBox<SEX> choiceBoxSexo;
    @FXML
    private ChoiceBox<category> choiceBoxCategory;
    @FXML
    private ChoiceBox<pool_type> choiceBoxpolltype;
    @FXML
    private ChoiceBox<org.example.Domain.Meters> choiceBoxtestDistance;
    @FXML
    private ChoiceBox<style> choiceBoxStyle;
    @FXML
    private  SEX[] Sex={MASCULINO,FEMENINO,NOBINARIA};
    @FXML
    private  category[] Category={ Pre_Benjamin,Benjamin,Alevin,Infantil,Juvenil,Junior,Senior};
    @FXML
    private  pool_type[]Pool_Types={ Pool25,Pool50};
    @FXML
    private  style[]Styles={ Crol,Mariposa,Braza,Espalda};
    @FXML
    private  org.example.Domain.Meters[]Meters={M50,M100,M200,M400,M800,M1500};




    /**
     *
     * @throws IOException
     * esta funcion es par iniciar el modificar prueba
     */

    @FXML
    private void ButtonModify() throws IOException {
        ModifyTrial();
    }

    /**
     *
     * @throws IOException
     * esta funcion añadira los la prueba en la base de datos
     */
    private void ModifyTrial() throws IOException {
        TrialSwimmerDAO TRDAO=new TrialSwimmerDAO();
        int Id= Integer.parseInt(IdInt.getText());
        SEX sex = choiceBoxSexo.getValue();
        category Category = choiceBoxCategory.getValue();
        pool_type PoolType = choiceBoxpolltype.getValue();
        Meters meters = choiceBoxtestDistance.getValue();
        style Style=choiceBoxStyle.getValue();

        try {
            //estos es un mensage de que se ha ñadido correctamente
            TrialSwimmer TS=new TrialSwimmer(Id,sex,Category,PoolType,meters,Style);
            TRDAO.update(TS);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("prueba Introducida");
            alert.setHeaderText(null);
            alert.setContentText("prueba Introducida con exito");
            alert.showAndWait();



        } catch (SQLException e) {
            // Error al insertar en la base de datos, mostrar alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de base de datos");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo insertar la prueba en la base de datos.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Agregar opciones de la enumeración SEX al ChoiceBox
        choiceBoxSexo.getItems().addAll(SEX.values());
        choiceBoxCategory.getItems().addAll(category.values());
        choiceBoxCategory.getItems().addAll(category.values());
        choiceBoxpolltype.getItems().addAll(pool_type.values());
        choiceBoxtestDistance.getItems().addAll(org.example.Domain.Meters.values());
        choiceBoxStyle.getItems().addAll(style.values());
    }




    @FXML
    private void ButtonExit()throws IOException {
        App.setRoot("option_manipulate_trial");
    }


}
