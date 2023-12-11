package com.example.demo2.MainPage;

import code.example.demo2.CooksManagement.KitchenManager;
import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Cook extends VBox {
    private CookState state;
    private boolean isCookWorking = false;
    private boolean isPaused = false;
    public Cook(CookState state) {
        this.state = state;
        renderCook();
    }

    public void renderCook() {
        getChildren().clear();
        ImageView cookImage = new ImageView(Cook.class.getResource("/cook_icon.png").toExternalForm());
        ImageView cloudImage = new ImageView();
        ImageView cuttingOrBackingImage = new ImageView();
        ImageView sleepImage = new ImageView();
        if (isCookWorking) {
            if(!this.getCookPauseValue()) {
                cloudImage = new ImageView(Cook.class.getResource("/MainPage/cloud.png").toExternalForm());
                String imageName = this.state.equals(CookState.AT_TABLE) ? "/MainPage/cutting-in-progress.png" : "/MainPage/backing-in-progress.png";
                cuttingOrBackingImage = new ImageView(Cook.class.getResource(imageName).toExternalForm());
            } else {
                cloudImage = new ImageView(Cook.class.getResource("/MainPage/cloud.png").toExternalForm());
                sleepImage = new ImageView(Cook.class.getResource("/MainPage/sleep_icon.png").toExternalForm());
            }
        }

        VBox cloudImageBox = new VBox();

        cookImage.setFitHeight(70);
        cookImage.setFitWidth(70);

        cloudImage.setFitHeight(60);
        cloudImage.setFitWidth(60);

        cuttingOrBackingImage.setFitHeight(20);
        cuttingOrBackingImage.setFitWidth(20);
        sleepImage.setFitHeight(20);
        sleepImage.setFitWidth(20);

        VBox cuttingOrBackingImageBox = new VBox();
        VBox sleepImageBox = new VBox();
        cuttingOrBackingImageBox.getChildren().add(cuttingOrBackingImage);
        sleepImageBox.getChildren().add(sleepImage);
        cuttingOrBackingImageBox.setPadding(new Insets(-40, 0, 0, 22));
        sleepImageBox.setPadding(new Insets(-40, 0, 0, 22));
        if (this.getCookPauseValue()) {
            cloudImageBox.getChildren().addAll(cloudImage, sleepImageBox);
        } else {
            cloudImageBox.getChildren().addAll(cloudImage, cuttingOrBackingImageBox);
        }

        if(this.state.equals(CookState.AT_TABLE)) {
            setPadding(new Insets(0, 0, 0, 110));
            cloudImageBox.setPadding(new Insets(0, 0, -10, -50));
        } else {
            cloudImageBox.setPadding(new Insets(0, 0, -10, 50));
        }

        getChildren().addAll(cloudImageBox, cookImage);
    }

    public void setIsCookWorking(boolean isCookWorking) {
         this.isCookWorking = isCookWorking;
         renderCook();
    }

    public void changeState(CookState state) {
        getChildren().clear();
        this.state = state;
        renderCook();
    }

    public CookState getState() {
        return this.state;
    }

    public void setCookPause(boolean status) {
        this.isPaused = status;
    }

    public boolean getCookPauseValue() {
        return this.isPaused;
    }
}
