package com.example.demo2.MainPage;

import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animation {
    public static void animateClient(Client client, double targetX) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), client);
        translateTransition.setToX(targetX);  // Встановлюємо відстань по осі X від поточної позиції до цільової
        translateTransition.play();
    }

    public static void startCookAnimation(int cookId) {
        Cook currentUiCook;
        ObservableList<Node> uiCooksChildren = PizzeriaController.getUiCooks().getChildren();

        if (cookId >= 0 && cookId < uiCooksChildren.size()) {
            currentUiCook = (Cook) uiCooksChildren.get(cookId);
        } else {
            currentUiCook = null;
            System.out.println("Invalid cookId: " + cookId);
        }

        if (currentUiCook != null) {
            System.out.println("cook" + currentUiCook);

            Platform.runLater(() -> {
                TranslateTransition moveLeft = new TranslateTransition(Duration.seconds(2), currentUiCook);
                moveLeft.setByX(-120);

                moveLeft.setOnFinished(event -> {
                    currentUiCook.changeState(CookState.AT_OVEN);
                });
                moveLeft.play();
            });
        } else {
            System.out.println("Animation skipped due to invalid cookId or missing cook");
        }
    }

    public static void finishCookAnimation(int cookId) {
        Cook currentUiCook;
        ObservableList<Node> uiCooksChildren = PizzeriaController.getUiCooks().getChildren();

        if (cookId >= 0 && cookId < uiCooksChildren.size()) {
            currentUiCook = (Cook) uiCooksChildren.get(cookId);
        } else {
            currentUiCook = null;
            System.out.println("Invalid cookId: " + cookId);
        }

        if (currentUiCook != null) {
            System.out.println("cook" + currentUiCook);

            Platform.runLater(() -> {
                TranslateTransition moveRight = new TranslateTransition(Duration.seconds(2), currentUiCook);
                moveRight.setByX(120);

                moveRight.setOnFinished(event -> {
                    currentUiCook.changeState(CookState.AT_TABLE);
                });
                moveRight.play();
            });
        } else {
            System.out.println("Animation skipped due to invalid cookId or missing cook");
        }
    }

}
