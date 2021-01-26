package com.internshala.temperatureController;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomelabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField inputField;

    @FXML
    public Button convertBtn;

    private static final String C_TO_F_TEXT ="Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT="Fahrenheit to Celsius";

    private boolean isC_TO_F = true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(C_TO_F_TEXT)){
                isC_TO_F = true;
            }else {
                isC_TO_F = false;
            }
        });

        convertBtn.setOnAction(event ->{
            convert();
        });

    }

    private void convert() {
        String input = inputField.getText();
        float enteredTemp = 0.0f;
        try {
             enteredTemp = Float.parseFloat(input);
        }catch (Exception ex){
            warnUser();
            return;
        }


        float newTemp = 0.0f;

        if(isC_TO_F){
            newTemp = (enteredTemp*9/5)+32;
        }else {
            newTemp = (enteredTemp-32)* 5/9;
        }

        diplay(newTemp);

    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred.");
        alert.setHeaderText("Invalid Input");
        alert.setContentText("Please enter the valid Temperature");
        alert.show();
    }

    private void diplay(float newTemp) {
        String unit = isC_TO_F? "F": "C";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new Temperature is "+newTemp+" "+unit);
        alert.show();
    }
}
