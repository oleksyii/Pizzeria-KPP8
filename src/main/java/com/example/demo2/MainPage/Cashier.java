package com.example.demo2.MainPage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cashier extends ImageView {
    private int cashierId;
    public Cashier() {
        super(new Image(Oven.class.getResource("/MainPage/cash-machine.png").toExternalForm()));

        cashierId = 0;
        setFitHeight(110);
        setFitWidth(110);
    }

    public void setCashierId(int id) {
        this.cashierId = id;
    }

    public int getCashierId() {
        return this.cashierId;
    }
}
