package com.example.colculationart.controller;

import com.example.colculationart.DataBaseHandler;
import com.example.colculationart.utils.DatabaseConnection;
import com.example.colculationart.HMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

import static com.example.colculationart.utils.DatabaseConnection.getConnection;

public class InsertArtController {

    @FXML
    private ChoiceBox<String> choiceBox1;  // Замена ComboBox на ChoiceBox
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private ChoiceBox<String> choiceBox3;
    @FXML
    private ChoiceBox<String> choiceBox4;
    @FXML
    private ChoiceBox<String> choiceBox5;
    @FXML
    private ChoiceBox<String> choiceBox6;
    @FXML
    private ChoiceBox<String> choiceBox7;

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
    private Button actionButton;

    @FXML
    private void initialize() {
        ComboBox<HBox> comboBox = new ComboBox<>();

        try {
            DatabaseConnection.getConnection();
            choiceBox1.getItems().addAll(HMap.getArtNameMap().keySet());


            for (Map.Entry<String, String> entry : HMap.getArtNameMap().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                String artImagePath = "/com/example/colculationart/image/art/big_img/" + value + "_5.png";
                Image artImage = loadImage(artImagePath);
                ImageView imageViewTemp = new ImageView(artImage);
                imageViewTemp.setFitWidth(25);
                imageViewTemp.setPreserveRatio(true);

                HBox hboxTemp = new HBox();
                Label textTemp = new Label();

                textTemp.setText(key);
                hboxTemp.getChildren().addAll(imageViewTemp, textTemp);

                comboBox.getItems().add(hboxTemp);
            }
            vbox1.getChildren().addAll(comboBox);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(comboBox.getValue());
        });

        choiceBox2.getItems().addAll("Sands", "Goblet", "Circlet");
        vbox2.setDisable(true);
        vbox3.setDisable(true);
        vbox4.setDisable(true);
        vbox5.setDisable(true);
        vbox6.setDisable(true);
        vbox7.setDisable(true);


        // Add a listener to comboBox1's value property
        choiceBox1.valueProperty().addListener((observable, oldValue, newValue) -> {

            boolean isComboBox1NotSelected = (newValue == null || choiceBox1.getValue() == null);

            vbox2.setDisable(isComboBox1NotSelected);
            String selectedBestArtifact = choiceBox1.getValue();



            // You can also clear values or perform other actions if needed
            if (isComboBox1NotSelected) {
                clearValuesInVBox(vbox2);
                clearValuesInVBox(vbox3);
                clearValuesInVBox(vbox4);
                clearValuesInVBox(vbox5);
                clearValuesInVBox(vbox6);
            }

            String artImagePath = "/com/example/colculationart/image/art/" + HMap.getArtNameMap().get(selectedBestArtifact) + ".png";

            Image artImage = loadImage(artImagePath);
            artImg.setImage(artImage);

            artLabel.setText(selectedBestArtifact);

        });

        choiceBox2.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox2NotSelected = (newValue == null || choiceBox2.getValue() == null);
            String selectedBestArtifact = choiceBox1.getValue();
            String selectedArtType = choiceBox2.getValue();

            vbox3.setDisable(isComboBox2NotSelected);
            textField1.setDisable(!isComboBox2NotSelected);
            slider1.setDisable(!isComboBox2NotSelected);

            switch (selectedArtType) {
                case "Circlet" -> {
                    choiceBox3.getItems().setAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "CRIT DMG", "CRIT RATE", "Healing bonus");

                    String artImagePath = "/com/example/colculationart/image/art/big_img/" + HMap.getArtNameMap().get(selectedBestArtifact) + "_1.png";
                    Image artImage = loadImage(artImagePath);
                    artImg.setImage(artImage);

                    artType.setText(selectedArtType);
                }
                case "Sands" -> {
                    choiceBox3.getItems().setAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "Energy Recharge");

                    String artImagePath = "/com/example/colculationart/image/art/big_img/" + HMap.getArtNameMap().get(selectedBestArtifact) + "_3.png";
                    Image artImage = loadImage(artImagePath);
                    artImg.setImage(artImage);


                    artType.setText(selectedArtType);
                }

                case "Goblet" -> {
                    choiceBox3.getItems().setAll("ATK%", "DEF%", "HP%", "Elemental Mastery", "Dendro DMG Bonus", "Anemo DMG Bonus", "Hydro DMG Bonus", "Cryo DMG Bonus", "Physical DMG Bonus", "Pyro DMG Bonus", "Electro DMG Bonus");

                    String artImagePath = "/com/example/colculationart/image/art/big_img/" + HMap.getArtNameMap().get(selectedBestArtifact) + "_2.png";
                    Image artImage = loadImage(artImagePath);
                    artImg.setImage(artImage);

                    artType.setText(selectedArtType);
                }
            }

        });

        choiceBox3.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox3NotSelected = (newValue == null || choiceBox3.getValue() == null);
            String selectedMainStat = choiceBox3.getValue();
            ObservableList<String> statList = FXCollections.observableArrayList(
                    "ATK", "ATK%", "DEF", "DEF%", "HP", "HP%", "Elemental Mastery", "Energy Recharge", "CRIT DMG", "CRIT RATE"
            );

            if (selectedMainStat != null){
                statList.remove(selectedMainStat);
                choiceBox4.setItems(statList);
                choiceBox5.setItems(statList);
                choiceBox6.setItems(statList);
                choiceBox7.setItems(statList);
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

        choiceBox4.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox4NotSelected = (newValue == null || choiceBox4.getValue() == null);
            String selectedValue4 = choiceBox4.getValue();

            textField2.setDisable(isComboBox4NotSelected);
            slider2.setDisable(isComboBox4NotSelected);
        });

        choiceBox5.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox5NotSelected = (newValue == null || choiceBox5.getValue() == null);
            String selectedValue5 = choiceBox5.getValue();

            textField3.setDisable(isComboBox5NotSelected);
            slider3.setDisable(isComboBox5NotSelected);
        });

        choiceBox6.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox6NotSelected = (newValue == null || choiceBox6.getValue() == null);
            String selectedValue6 = choiceBox6.getValue();

            textField4.setDisable(isComboBox6NotSelected);
            slider4.setDisable(isComboBox6NotSelected);
        });

        choiceBox7.valueProperty().addListener((observable, oldValue, newValue) -> {
            boolean isComboBox7NotSelected = (newValue == null || choiceBox7.getValue() == null);
            String selectedValue7 = choiceBox7.getValue();

            textField5.setDisable(isComboBox7NotSelected);
            slider5.setDisable(isComboBox7NotSelected);
        });

        actionButton.setOnAction(event -> {
            try {
                DataBaseHandler.executeQuery(getConnection(), choiceBox1.getValue(), choiceBox2.getValue(), choiceBox3.getValue(), choiceBox4.getValue(), choiceBox5.getValue(), choiceBox6.getValue(), choiceBox7.getValue());

                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();
                HelloController helloController = loader.getController();

                // Передача параметров
                helloController.initData(choiceBox1.getValue(), choiceBox2.getValue(), choiceBox3.getValue(), choiceBox4.getValue(), choiceBox5.getValue(), choiceBox6.getValue(), choiceBox7.getValue());

                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
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
