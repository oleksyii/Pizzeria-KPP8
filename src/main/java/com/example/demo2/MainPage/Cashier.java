package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cashier extends ImageView {
    public Cashier() {
        super(new Image(Oven.class.getResource("/MainPage/cash-machine.png").toExternalForm()));

        setFitHeight(110);
        setFitWidth(110);
    }
}
