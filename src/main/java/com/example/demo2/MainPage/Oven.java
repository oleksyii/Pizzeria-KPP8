package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Oven extends ImageView {
    public Oven() {
        super(new Image(Oven.class.getResource("/MainPage/oven.png").toExternalForm()));

        setFitHeight(110);
        setFitWidth(110);
    }
}
