package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.SEX;
import org.example.Domain.swimmer;
import org.example.dao.SwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;

import static org.example.Domain.SEX.*;

/**
 *
 */
public class ControlerAddSwimmer {



    @FXML
    private Button ButtonAddSwimmer;

    @FXML
    private TextField TextName;
    @FXML
    private TextField TextLast_Name;
    @FXML
    private ChoiceBox<SEX> choiceBoxSexo;
    @FXML
    private  SEX[] sex={MASCULINO,FEMENINO,NOBINARIA};
    @FXML
    private TextField intAge;

    /**
     *
     * @throws IOException
     * Este boton es para volver  las opciones de nadador
     */

    @FXML
    private void ButtonExit()throws IOException {
        App.setRoot("adSw");
    }

    /**
     *
     * @throws IOException
     * este boton es para iniciar el addSwimmer
     */
    @FXML
    private void ButtonAddSwimmer() throws IOException {
       addSwimmer();

    }

    /**
     * esta funcion se encarga de añadir los nadadores a la base de datos
     * @throws IOException
     */

    private void addSwimmer() throws IOException {
        SwimmerDAO SDAO = new SwimmerDAO();

        String Name = TextName.getText();
        String Last_Name = TextLast_Name.getText();
        int Age = Integer.parseInt(intAge.getText());
        SEX Sex = choiceBoxSexo.getValue();
        //este es el mensage de que se a añadido correctamente
        try {
            swimmer S = new swimmer(0,Name,Last_Name,Age,Sex,"");
            SDAO.save(S);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nadador introducido");
            alert.setHeaderText(null);
            alert.setContentText("Nadador introducido con exito");
            alert.showAndWait();

            //este es el mensage de que no se ha podido añadir
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

    /**
     * esta funcion es para inicializar el enum del genero
     */
    @FXML
    public void initialize() {
        // Agregar opciones de la enumeración SEX al ChoiceBox
        choiceBoxSexo.getItems().addAll(SEX.values());
    }

}
