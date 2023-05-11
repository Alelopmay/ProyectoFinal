package org.example.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.SEX;
import org.example.Domain.Swimmer;
import org.example.dao.SwimmerDAO;

import java.io.IOException;
import java.sql.SQLException;

import static org.example.Domain.SEX.*;

public class ControlerModifySwimmer {

    @FXML
    private Button buttonModify;
    @FXML
    private Button buttonExit;
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
    @FXML
    private TextField CodInt;

    /**
     *
     * @throws IOException
     * este funcion acciona el modificar Nadador
     */

    @FXML
    public void buttonModifySwimmer()throws IOException{
       ModifySwimmer();
    }

    /**
     * estaa funcion modifica el nadador
     * @throws IOException
     */


    private void ModifySwimmer()throws IOException {
        SwimmerDAO SDAO=new SwimmerDAO();
        int Cod_Swimmer= Integer.parseInt(CodInt.getText());
        String Name=TextName.getText();
        String Last_Name=TextLast_Name.getText();
        int Age= Integer.parseInt(intAge.getText());
        SEX Sex = choiceBoxSexo.getValue();

        try {
            //este el el mejage de
             Swimmer S=new Swimmer(Cod_Swimmer,Name,Last_Name,Age,Sex,"");
            SDAO.update(S);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nadador Modificado");
            alert.setHeaderText(null);
            alert.setContentText("Nadador Modificado con exito");
            alert.showAndWait();

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de base de datos");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo modificar el nadador en la base de datos.");
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


    @FXML
    public void exit()throws IOException{
        App.setRoot("adSw");
    }

}
