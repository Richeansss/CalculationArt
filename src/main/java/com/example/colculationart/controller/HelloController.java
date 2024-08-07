package com.example.colculationart.controller;

import com.example.colculationart.DataBaseHandler;
import com.example.colculationart.utils.DatabaseConnection;
import com.example.colculationart.HMap;
import com.example.colculationart.Tables;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

import static com.example.colculationart.utils.DatabaseConnection.getConnection;


public class HelloController {
    private String artifactType;
    private String bestArtifact;
    private String mainStat;
    private String subStat1;
    private String subStat2;
    private String subStat3;
    private String subStat4;

    @FXML
    private Label welcomeText;
    @FXML
    private Label WhachLable;
    @FXML
    private Label GobletLable;
    @FXML
    private Label HatLabel;




    @FXML
    private ComboBox<String> ChoiceCharacterStatusBox;

    @FXML
    ImageView CharcterView;
    @FXML
    ImageView ArtUiLabel;
    @FXML
    Button myButton;
    @FXML
    Button selectCharacterButton;
    @FXML
    Button refrashTablesButton;
    @FXML
    Button updateMainTableButton;
    @FXML
    ScrollPane PerfectTable;
    @FXML
    private Label testlable;
    @FXML
    TilePane tilePanePerfect;
    @FXML
    TilePane tilePaneCompatibility;
    @FXML
    TilePane tilePaneSoSo;
    @FXML
    TilePane tilePaneBad;
    //public void displayImage(){
    //
   // }

    @FXML

    private final HashMap<String, String> Character = HMap.getCharactersID();

    @FXML
    private void initialize(){
        processResultSet("perfectart", null, tilePanePerfect);
        processResultSet("compatibility", "perfectart", tilePaneCompatibility);
        processResultSet("soso", "compatibility", tilePaneSoSo);
        processResultSet("bad", "soso", tilePaneBad);


        myButton.setOnAction(event -> {

            try {
                DataBaseHandler.executeQuery(getConnection(), bestArtifact,artifactType,mainStat,subStat1, subStat2, subStat3, subStat4);
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Art-view.fxml"));
            try {

                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

             */
        });

        //updateMainTableButton.setOnAction(event -> {
        //    ParserHtml.PerCharacter();
        //});

        selectCharacterButton.setOnAction(event -> {
            try {
                DataBaseHandler.executeQuery(getConnection(), "Sands","Noblesse Oblige","ATK","CRIT DMG", "ATK", "CRIT RATE", "Energy Recharge");
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        refrashTablesButton.setOnAction(event -> {
            try {
                Tables.dropPerfectArtTable(DatabaseConnection.getConnection());
                Tables.dropBadTable(getConnection());
                Tables.dropSoSoTable(getConnection());
                Tables.dropCompatibilityTable(getConnection());
                System.out.println("Дочерние таблицы очищены");
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    private void processResultSet(String mainTableName, String relatedTableName, TilePane tilePane) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql;
            if (relatedTableName != null) {
                sql = String.format("SELECT DISTINCT * FROM %s WHERE NOT EXISTS ( SELECT 1 FROM %s WHERE %s.SetName = %s.SetName)",
                        mainTableName, relatedTableName, relatedTableName, mainTableName);
            } else {
                sql = String.format("SELECT DISTINCT * FROM %s", mainTableName);
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                int maxSetNameLength = 20;
                while (resultSet.next()) {
                    String setName = resultSet.getString("SetName");
                    String limitedSetName = setName.length() > maxSetNameLength ?
                            breakAtWholeWord(setName, maxSetNameLength) :
                            setName;

                    Text setNameText = new Text(limitedSetName);
                    Text nameText = new Text(resultSet.getString("Name"));

                    setStyles(nameText);
                    setNameText.setStyle("-fx-font-size: 10px; -fx-text-alignment: center;");

                    Tooltip tooltip = createTooltip(resultSet);
                    double textWidth = calculateTextWidth(tooltip.getText());
                    tooltip.setMaxWidth(textWidth);

                    String characterImageName = resultSet.getString("Name");
                    String characterImagePath = "/com/example/colculationart/image/" + characterImageName + ".png";

                    Image characterImage = loadImage(characterImagePath);
                    ImageView characterImageView = createImageView(characterImage);
                    Tooltip.install(characterImageView, tooltip);

                    VBox vbox = createVBox(characterImageView, nameText, setNameText);

                    tilePane.getChildren().add(vbox);
                }

            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String breakAtWholeWord(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }

        int lastIndex = text.lastIndexOf(" ", maxLength);
        return text.substring(0, lastIndex) + "\n" + text.substring(lastIndex + 1);
    }

    private void setStyles(Text text) {
        text.setStyle("-fx-alignment: center; -fx-max-width: 40px; -fx-font-size: 10px;");
    }

    private Tooltip createTooltip(ResultSet resultSet) throws SQLException {
        return new Tooltip("Имя: " + resultSet.getString("Name") +
                "\n Название билда: " + resultSet.getString("SetName") +
                "\n Лучшее оружие: " + resultSet.getString("BestWeapon") +
                "\nАльтернативное оружие: " + resultSet.getString("ReplacementWeapons") +
                "\nСэт артефактов: " + resultSet.getString("BestArtifacts"));
    }

    private double calculateTextWidth(String text) {
        Text dummyText = new Text(text);
        dummyText.setStyle("-fx-font-size: 14px;");
        return dummyText.getLayoutBounds().getWidth();
    }

    private Image loadImage(String imagePath) {
        //System.out.println("Trying to load image from: " + imagePath);

        if (getClass().getResource(imagePath) != null) {
            //System.out.println("Image found at: " + imagePath);
            return new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        } else {
            //System.out.println("Image not found. Using alternative image.");
            return new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/Alhaitham.png");
        }
    }

    private ImageView createImageView(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    private VBox createVBox(ImageView imageView, Text nameText, Text setNameText) {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, nameText, setNameText);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

    public void initData(String artifactType, String bestArtifact, String mainStat, String subStat1, String subStat2, String subStat3, String subStat4) {
        this.artifactType = artifactType;
        this.bestArtifact = bestArtifact;
        this.mainStat = mainStat;
        this.subStat1 = subStat1;
        this.subStat2 = subStat2;
        this.subStat3 = subStat3;
        this.subStat4 = subStat4;

        // Используйте параметры по мере необходимости в других частях вашего контроллера
    }

}