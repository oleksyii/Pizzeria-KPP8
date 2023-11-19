package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Client extends ImageView {
    public Client() {
        super (new Image(Client.class.getResource("/MainPage/client.png").toExternalForm()));

        setFitHeight(60);
        setFitWidth(60);

    }
}
