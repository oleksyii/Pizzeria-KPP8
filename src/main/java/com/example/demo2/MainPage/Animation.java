package com.example.demo2.MainPage;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animation {
    public void animateClient(Client client, double targetX) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3), client);
        translateTransition.setToX(targetX);  // Встановлюємо відстань по осі X від поточної позиції до цільової
        translateTransition.play();
    }

    public void animateCook(Cook cook, double standStillDuration) {
        TranslateTransition moveLeft = new TranslateTransition(Duration.seconds(2), cook);
        moveLeft.setByX(-120);

        TranslateTransition standStill = new TranslateTransition(Duration.seconds(standStillDuration), cook);
        standStill.setByX(0);

        TranslateTransition moveBack = new TranslateTransition(Duration.seconds(2), cook);
        moveBack.setByX(120);

        moveLeft.setOnFinished(event -> {
            cook.changeState(CookState.AT_OVEN);
            standStill.play();
            standStill.setOnFinished(e -> {
                moveBack.play();
                moveBack.setOnFinished(f -> {
                    // Оновлення стану тільки після закінчення анімації
                    cook.changeState(CookState.AT_TABLE);
                });
            });
        });

        moveLeft.play();
    }
}
