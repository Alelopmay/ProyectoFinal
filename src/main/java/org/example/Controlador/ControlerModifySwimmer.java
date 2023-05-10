package org.example.Controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.Domain.SEX;

import java.io.IOException;

public class ControlerModifySwimmer {

    @FXML
    private Button buttonModify;
    @FXML
    private Button buttonExit;
    @FXML
    private TextField IntCod_Swimmer;
    @FXML
    private TextField TextName;
    @FXML
    private TextField TextLast_Name;
    @FXML
    private ChoiceBox<SEX> choiceBoxSexo;
    @FXML
    private TextField intAge;


    private void ButtonModifySwimmer()throws IOException {
        int Cod_Swimmer= Integer.parseInt(intAge.getText());
        String Name=TextName.getText();
        String Last_Name=TextLast_Name.getText();
        int Age= Integer.parseInt(intAge.getText());
        String Category="";
        ObservableList<SEX> Sex = FXCollections.observableArrayList(SEX.values());
        choiceBoxSexo.setItems(Sex);
        ModifySwimmer( Cod_Swimmer,Age, Category, Name,  Last_Name,  Sex);
    }
    public void ModifySwimmer(int codSwimmer, int age, String category, String name, String lastName, ObservableList<SEX> sex) {

       /* for (Swimmer swimmer : swimmers) {
            if (swimmer.getCod_Swimmer() == codSwimmer) {
                swimmer.setAge(age);
                swimmer.setCategory(category);
                swimmer.setName(name);
                swimmer.setLast_Name(lastName);
                swimmer.setSex(sex.toString());
                return;
            }
        }
        System.out.println("No se encontró un nadador con el código " + codSwimmer);*/
    }
    @FXML
    public void exit()throws IOException{
        App.setRoot("adSw");
    }

}
