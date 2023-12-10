package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Client extends ImageView {

    private int orderId;
    public Client(int orderId) {
        super (new Image(Client.class.getResource("/MainPage/client.png").toExternalForm()));
        this.orderId = orderId;

        setFitHeight(60);
        setFitWidth(60);

    }

    public int getOrderId() {
        return orderId;
    }
}
