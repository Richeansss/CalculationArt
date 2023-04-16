package com.example.colculationart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.PopupWindow;
import javafx.util.StringConverter;

import java.security.cert.PolicyNode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArtController {

    @FXML
    private Button myButton;

    @FXML
    private Slider slider;

    @FXML
    private TextField LabelArtStat1;

    @FXML
    private Tooltip tooltip;
    @FXML
    private Line progressLine;
    @FXML
    void displayImage(ActionEvent event) {

    }


    @FXML
    public void initialize() {
        List<Double> validValues = Arrays.asList(4.1, 4.7, 5.3, 5.8, 8.2, 8.7, 9.3, 9.9, 10.5, 11.1, 11.7, 12.2, 12.8, 13.4, 14.0, 14.6, 15.2, 15.7, 15.8, 16.3, 16.9, 17.5, 18.1, 18.6, 18.7, 19.2, 19.8, 20.4, 21.0, 21.6, 22.1, 22.2, 22.7, 23.3);

        slider.setMax(validValues.size() - 1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);


        for (int i = 0; i < validValues.size(); i++) {
            slider.setLabelFormatter(new StringConverter<Double>() {
                @Override
                public String toString(Double value) {
                    return String.valueOf(validValues.get(value.intValue()));
                }

                @Override
                public Double fromString(String string) {
                    return (double) validValues.indexOf(Double.parseDouble(string));
                }
            });
        }



        LabelArtStat1.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double value = Double.parseDouble(newValue);
                if (validValues.contains(value)) {
                    int index = validValues.indexOf(value);
                    slider.setValue(index);
                } else {
                    LabelArtStat1.setText(oldValue);
                }
            } catch (NumberFormatException e) {
                LabelArtStat1.setText(oldValue);
            }
        });

        Tooltip tooltip = new Tooltip();
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int index = newValue.intValue();
            tooltip.setText(String.valueOf(validValues.get(index)));
            Tooltip.install(slider, tooltip);
        });

        slider.setStyle(".track {-fx-background-color: green;}");
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int index = newValue.intValue();
            LabelArtStat1.setText(String.valueOf(validValues.get(index)));
            double value = validValues.get(index);
            if (value < 10) {        slider.setStyle(".track {-fx-background-color: red;}");
            } else if (value < 20) {        slider.setStyle(".track {-fx-background-color: yellow;}");
            } else {        slider.setStyle(".track {-fx-background-color: green;}");
            }    slider.applyCss();});

        LabelArtStat1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    double value = Double.parseDouble(LabelArtStat1.getText());
                    if (validValues.contains(value)) {
                        int index = validValues.indexOf(value);
                        slider.setValue(index);
                    } else {
                        LabelArtStat1.setText(String.valueOf(validValues.get(slider.valueProperty().intValue())));
                    }
                } catch (NumberFormatException e) {
                    LabelArtStat1.setText(String.valueOf(validValues.get(slider.valueProperty().intValue())));
                }
            }
        });
    }
}