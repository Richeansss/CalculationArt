package com.example.colculationart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.PopupWindow;
import javafx.util.StringConverter;

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
    void displayImage(ActionEvent event) {

    }


    @FXML
    public void initialize() {
        slider.setMin(0.0);
        slider.setMax(25.0);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(1.0);

        List<Double> validValues = Arrays.asList(0.0, 4.1, 4.7, 5.3, 5.8, 8.2, 8.7, 9.3, 9.9, 10.5, 11.1, 11.7, 12.2, 12.8, 13.4, 14.0, 14.6, 15.2, 15.7, 15.8, 16.3, 16.9, 17.5, 18.1, 18.6, 18.7, 19.2, 19.8, 20.4, 21.0, 21.6, 22.1, 22.2, 22.7, 23.3);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double value) {
                double roundedValue = Math.round(value);
                double closestValidValue = validValues.stream().min(Comparator.comparingDouble(v -> Math.abs(v - roundedValue))).orElse(0.0);
                return String.format("%.1f", closestValidValue);
            }

            @Override
            public Double fromString(String string) {
                return Double.valueOf(string);
            }
        });

        tooltip.setAnchorLocation(PopupWindow.AnchorLocation.CONTENT_BOTTOM_LEFT);
        slider.setTooltip(tooltip);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double roundedValue = Math.round(newValue.doubleValue());
            tooltip.setText(String.format("%.1f", roundedValue));
            int minorTickCount = validValues.contains(roundedValue) ? validValues.size() - 1 : 0;
            slider.setMinorTickCount(minorTickCount);
            double closestValidValue = validValues.stream().min(Comparator.comparingDouble(v -> Math.abs(v - roundedValue))).orElse(0.0);
            slider.setValue(closestValidValue);
        });

        LabelArtStat1.setOnAction(event -> {
            try {
                double value = Double.parseDouble(LabelArtStat1.getText());
                double closestValidValue = validValues.stream().min(Comparator.comparingDouble(v -> Math.abs(v - value))).orElse(0.0);
                slider.setValue(closestValidValue);
                if (slider.getValue() != value) {
                    LabelArtStat1.setText(String.format("%.1f", slider.getValue()));
                }
            } catch (NumberFormatException e) {
                LabelArtStat1.setText("");
            }
        });

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!LabelArtStat1.getText().equals(newValue)) {
                LabelArtStat1.setText(String.format("%.1f", newValue));
            }
        });

        slider.setMinorTickCount(validValues.size() - 1);
    }
}