package com.example.colculationart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class InsertArtController {

    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML
    private ComboBox<String> comboBox3;
    @FXML
    private ComboBox<String> comboBox4;
    @FXML
    private ComboBox<String> comboBox5;
    @FXML
    private ComboBox<String> comboBox6;
    @FXML
    private ComboBox<String> comboBox7;

    @FXML
    Label artLabel;
    @FXML
    Label artType;

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
    private ImageView artImg;

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

            boolean isComboBox1NotSelected = (newValue == null || comboBox1.getValue() == null);
            vbox2.setDisable(isComboBox1NotSelected);
            String selectedValue1 = comboBox1.getValue();



            // You can also clear values or perform other actions if needed
            if (isComboBox1NotSelected) {
                clearValuesInVBox(vbox2);
                clearValuesInVBox(vbox3);
                clearValuesInVBox(vbox4);
                clearValuesInVBox(vbox5);
                clearValuesInVBox(vbox6);
            }

            String artImagePath = "/com/example/colculationart/image/art/" + HMap.getArtNameMap().get(selectedValue1) + ".png";

            Image artImage = loadImage(artImagePath);
            artImg.setImage(artImage);

            artLabel.setText(selectedValue1);

        });

        comboBox2.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox2NotSelected = (newValue == null || comboBox2.getValue() == null);
            String selectedArtType = comboBox2.getValue();

            // Set disable property for other VBox elements based on the condition
            vbox3.setDisable(isComboBox2NotSelected);
            textField1.setDisable(!isComboBox2NotSelected);
            slider1.setDisable(!isComboBox2NotSelected);



            switch (selectedArtType) {
                case "Circlet" -> {
                    comboBox3.getItems().addAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "CRIT DMG", "CRIT RATE", "Healing bonus");
                    artType.setText(selectedArtType);
                }
                case "Sands" -> {
                    comboBox3.getItems().addAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "Energy Recharge");
                    artType.setText(selectedArtType);
                }

                case "Goblet" -> {
                    comboBox3.getItems().addAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "Dendro DMG Bonus", "Anemo DMG Bonus", "Hydro DMG Bonus", "Cryo DMG Bonus", "Physical DMG Bonus", "Pyro DMG Bonus", "Electro DMG Bonus");
                    artType.setText(selectedArtType);
                }
            }

        });

        comboBox3.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox3NotSelected = (newValue == null || comboBox3.getValue() == null);
            String selectedMainStat = comboBox3.getValue();
            ObservableList<String> statList = FXCollections.observableArrayList(
                    "ATK", "ATK%", "DEF", "DEF%", "HP", "HP%", "Elemental Mastery", "Energy Recharge"
            );

            if (selectedMainStat != null){
                statList.remove(selectedMainStat);
                comboBox4.setItems(statList);
                comboBox5.setItems(statList);
                comboBox6.setItems(statList);
                comboBox7.setItems(statList);
            }
            vbox4.setDisable(isComboBox3NotSelected);
            textField2.setDisable(!isComboBox3NotSelected);
            slider2.setDisable(!isComboBox3NotSelected);

            vbox5.setDisable(isComboBox3NotSelected);
            textField3.setDisable(!isComboBox3NotSelected);
            slider3.setDisable(!isComboBox3NotSelected);

            vbox6.setDisable(isComboBox3NotSelected);
            textField4.setDisable(!isComboBox3NotSelected);
            slider4.setDisable(!isComboBox3NotSelected);

            vbox7.setDisable(isComboBox3NotSelected);
            textField5.setDisable(!isComboBox3NotSelected);
            slider5.setDisable(!isComboBox3NotSelected);

            textField1.setDisable(isComboBox3NotSelected);
            slider1.setDisable(isComboBox3NotSelected);
        });

        comboBox4.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox4NotSelected = (newValue == null || comboBox4.getValue() == null);
            String selectedValue4 = comboBox4.getValue();

            textField2.setDisable(isComboBox4NotSelected);
            slider2.setDisable(isComboBox4NotSelected);
        });

        comboBox5.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox5NotSelected = (newValue == null || comboBox5.getValue() == null);
            String selectedValue5 = comboBox5.getValue();

            textField3.setDisable(isComboBox5NotSelected);
            slider3.setDisable(isComboBox5NotSelected);
        });

        comboBox6.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox6NotSelected = (newValue == null || comboBox6.getValue() == null);
            String selectedValue6 = comboBox6.getValue();

            textField4.setDisable(isComboBox6NotSelected);
            slider4.setDisable(isComboBox6NotSelected);
        });

        comboBox7.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox7NotSelected = (newValue == null || comboBox7.getValue() == null);
            String selectedValue7 = comboBox7.getValue();

            textField5.setDisable(isComboBox7NotSelected);
            slider5.setDisable(isComboBox7NotSelected);
        });
    }

    private Image loadImage(String imagePath) {
        if (getClass().getResource(imagePath) != null) {
            return new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        } else {
            return new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/Alhaitham.png");
        }
    }

    private ImageView createImageView(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);
        return imageView;
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
