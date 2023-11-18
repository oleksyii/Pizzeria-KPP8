package com.example.demo2.MainPage;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;

public class Cook extends VBox {
    public Cook(String state) {
        ImageView cookImage = new ImageView(Cook.class.getResource("/cook_icon.png").toExternalForm());
        ImageView cloudImage = new ImageView(Cook.class.getResource("/MainPage/cloud.png").toExternalForm());
        VBox cloudImageBox = new VBox();

        cookImage.setFitHeight(70);
        cookImage.setFitWidth(70);

        cloudImage.setFitHeight(60);
        cloudImage.setFitWidth(60);

        String imageName = state.equals("atTable") ? "/MainPage/cutting-in-progress.png": "/MainPage/backing-in-progress.png";
        ImageView cuttingOrBackingImage = new ImageView(Cook.class.getResource(imageName).toExternalForm());
        cuttingOrBackingImage.setFitHeight(20);
        cuttingOrBackingImage.setFitWidth(20);

        VBox cuttingOrBackingImageBox = new VBox();
        cuttingOrBackingImageBox.getChildren().add(cuttingOrBackingImage);
        cuttingOrBackingImageBox.setPadding(new Insets(-40, 0, 0, 22));

        cloudImageBox.getChildren().addAll(cloudImage, cuttingOrBackingImageBox);

        if(state.equals("atTable")) {
            setPadding(new Insets(0, 0, 0, 110));
            cloudImageBox.setPadding(new Insets(0, 0, -10, -50));
        } else {
            cloudImageBox.setPadding(new Insets(0, 0, -10, 50));
        }

        getChildren().addAll(cloudImageBox, cookImage);
    }
}
