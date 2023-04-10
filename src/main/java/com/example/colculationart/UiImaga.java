package com.example.colculationart;

import javafx.scene.image.Image;


public class UiImaga {
    public static Image GetCharacter(String Temp){
        Image Img = new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/" + Temp + ".png");
        return Img;
    }
    public static Image GetArt(String Temp){
        Image Img = new Image("file:///C:/Users/Алексей/IdeaProjects/Colculationart/src/main/resources/com/example/colculationart/image/art/" + Temp + ".png");
        return Img;
    }
}
