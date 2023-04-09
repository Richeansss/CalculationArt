package com.example.colculationart;

import javafx.scene.image.Image;


public class GetUiImaga {
    public static Image GetImageUiCharacter(String Temp){
        Image Img = new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/" + Temp + ".png");
        return Img;
    }
    public static Image GetImageUiArt(String Temp){
        Image Img = new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/art/" + Temp + ".png");
        return Img;
    }
}
