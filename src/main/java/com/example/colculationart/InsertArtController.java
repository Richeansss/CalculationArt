package com.example.colculationart;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;

import static com.example.colculationart.DataBaseHandler.getConnection;

public class InsertArtController {

    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML
    private ComboBox<String> comboBox3;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private VBox vbox3;

    @FXML
    private VBox vbox4;

    @FXML
    private VBox vbox5;

    @FXML
    private VBox vbox6;
    @FXML
    private VBox vbox7;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField5;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;

    @FXML
    private Slider slider4;

    @FXML
    private Slider slider5;

    @FXML
    private Slider slider6;

    @FXML
    private void initialize() {
        try {
            DataBaseHandler.getConnection();
            comboBox1.getItems().addAll(HMap.getArtNameMap().keySet());
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        comboBox2.getItems().addAll("Sands", "Goblet", "Circlet");
        vbox2.setDisable(true);
        vbox3.setDisable(true);
        vbox4.setDisable(true);
        vbox5.setDisable(true);
        vbox6.setDisable(true);
        vbox7.setDisable(true);

        // Add a listener to comboBox1's value property
        comboBox1.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Check if comboBox1 is not selected

            boolean isComboBox1NotSelected = (newValue == null || comboBox1.getValue() == null);
            // Set disable property for other VBox elements based on the condition
            vbox2.setDisable(isComboBox1NotSelected);


            // You can also clear values or perform other actions if needed
            if (isComboBox1NotSelected) {
                clearValuesInVBox(vbox2);
                clearValuesInVBox(vbox3);
                clearValuesInVBox(vbox4);
                clearValuesInVBox(vbox5);
                clearValuesInVBox(vbox6);
            }
        });

        comboBox2.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox2NotSelected = (newValue == null || comboBox1.getValue() == null);
            String selectedValue = comboBox2.getValue();

            // Set disable property for other VBox elements based on the condition
            vbox3.setDisable(isComboBox2NotSelected);
            vbox4.setDisable(isComboBox2NotSelected);
            vbox5.setDisable(isComboBox2NotSelected);
            vbox6.setDisable(isComboBox2NotSelected);
            switch (selectedValue) {
                case "Circlet" ->
                        comboBox3.getItems().addAll("ATK", "DEF", "HP", "Elemental Mastery", "CRIT DMG", "CRIT RATE", "Healing bonus");
                case "Sands" ->
                        comboBox3.getItems().addAll("ATK", "DEF", "HP", "Elemental Mastery", "Energy Recharge");
                case "Goblet" ->
                        comboBox3.getItems().addAll("ATK", "DEF", "HP", "Elemental Mastery", "Dendro DMG Bonus", "Anemo DMG Bonus", "Hydro DMG Bonus", "Cryo DMG Bonus", "Physical DMG Bonus", "Pyro DMG Bonus", "Electro DMG Bonus");
            }


        });
    }



    private void clearValuesInVBox(VBox vbox) {
        // Implement logic to clear values in the specified VBox
        // For example, if it contains text fields, set their text to an empty string
    }

    @FXML
    private void handleActionButton() {
        // Add your action logic when the button is clicked
    }
}
