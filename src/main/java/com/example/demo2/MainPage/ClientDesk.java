package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ClientDesk extends ImageView {
    public ClientDesk() {
        super(new Image(Oven.class.getResource("/MainPage/client_desk.png").toExternalForm()));

        setFitHeight(140);
        setFitWidth(140);
    }
}
