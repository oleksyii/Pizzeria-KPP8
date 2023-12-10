package com.example.demo2.MainPage;

import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.CooksManagement.strategies.CookStatus;
import code.example.demo2.UIManagement.controllers.PizzeriaController;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Animation {
    public static void animateClient(Client client, double targetX) {
        Platform.runLater(() -> {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), client);
            translateTransition.setToX(targetX);  // Встановлюємо відстань по осі X від поточної позиції до цільової
            translateTransition.play();
        });
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
                    PizzeriaController.generateTable();
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
                    PizzeriaController.generateTable();
                });
                moveRight.play();
            });
        } else {
            System.out.println("Animation skipped due to invalid cookId or missing cook");
        }
    }

    public static void animateClientRemoval(Client client, HBox clientsQueue, int indexToRemove) {
        TranslateTransition moveRight = new TranslateTransition(Duration.seconds(1.5), client);
        moveRight.setByY(80);

        moveRight.setOnFinished(event -> {
            // Викликається після закінчення анімації
            clientsQueue.getChildren().remove(indexToRemove);
        });

        moveRight.play();
    }

    // TODO: figure out how use those two methods below

//    public static void animateClientRemoval(Client client, HBox clientsQueue, int indexToRemove) {
//        TranslateTransition leaveTransition = new TranslateTransition(Duration.seconds(1), client);
//        leaveTransition.setByY(-80);
//
//        leaveTransition.setOnFinished(event -> {
//            // Додаємо затримку перед початком анімації зміщення по X
//            PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
//            pause.setOnFinished(e -> animateShiftClientsX(clientsQueue, indexToRemove));
//            pause.play();
//        });
//
//        leaveTransition.play();
//    }
//
//    private static void animateShiftClientsX(HBox clientsQueue, int indexToRemove) {
//        List<TranslateTransition> shiftTransitions = new ArrayList<>();
//
//        for (int i = indexToRemove + 1; i < clientsQueue.getChildren().size(); i++) {
//            Node node = clientsQueue.getChildren().get(i);
//            TranslateTransition shiftLeft = new TranslateTransition(Duration.seconds(0.5), node);
//            shiftLeft.setByX(-45);
//            shiftTransitions.add(shiftLeft);
//        }
//
//        ParallelTransition parallelTransition = new ParallelTransition(shiftTransitions.toArray(new Transition[0]));
//
//        parallelTransition.setOnFinished(e -> {
//            // Після закінчення анімації зміщення по X
//            clientsQueue.getChildren().remove(indexToRemove);
//        });
//
//        parallelTransition.play();
//    }


}
