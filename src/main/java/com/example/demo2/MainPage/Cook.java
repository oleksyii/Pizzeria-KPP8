package com.example.demo2.MainPage;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;

public class Cook extends VBox {
    private CookState state;
    private boolean isCookWorking = false;
    public Cook(CookState state) {
        this.state = state;
        renderCook();
    }

    public void renderCook() {
        getChildren().clear();
        ImageView cookImage = new ImageView(Cook.class.getResource("/cook_icon.png").toExternalForm());
        ImageView cloudImage = new ImageView();
        ImageView cuttingOrBackingImage = new ImageView();
        if(isCookWorking) {
            cloudImage = new ImageView(Cook.class.getResource("/MainPage/cloud.png").toExternalForm());
            String imageName = this.state.equals(CookState.AT_TABLE) ? "/MainPage/cutting-in-progress.png": "/MainPage/backing-in-progress.png";
            cuttingOrBackingImage = new ImageView(Cook.class.getResource(imageName).toExternalForm());
        }

        VBox cloudImageBox = new VBox();

        cookImage.setFitHeight(70);
        cookImage.setFitWidth(70);

        cloudImage.setFitHeight(60);
        cloudImage.setFitWidth(60);

        cuttingOrBackingImage.setFitHeight(20);
        cuttingOrBackingImage.setFitWidth(20);

        VBox cuttingOrBackingImageBox = new VBox();
        cuttingOrBackingImageBox.getChildren().add(cuttingOrBackingImage);
        cuttingOrBackingImageBox.setPadding(new Insets(-40, 0, 0, 22));

        cloudImageBox.getChildren().addAll(cloudImage, cuttingOrBackingImageBox);

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
}
