package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Group root = new Group();
//        Scene scene = new Scene(root, 500, 500, Color.rgb(245, 245, 245));
//
//        Image icon = new Image("pizza-box.png");
//        primaryStage.getIcons().add(icon);
//        primaryStage.setTitle("Whoa the effects!");
//
//        Text text  = new Text();
//        text.setText("WHOOOOA");
//        text.setX(50.0);
//        text.setY(50.0);
//        text.setFont(Font.font("Verdana", 50));
//        text.setFill(Color.gray(0.5));
//
//        root.getChildren().add(text);

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Hello world");
//        Must be at the end
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}