package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    @FXML
    protected void printOutToConsole() {
        myCircle.setCenterY(y -= 1);
    }
}