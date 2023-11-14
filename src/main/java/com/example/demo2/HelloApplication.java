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
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.util.List;

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

//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        primaryStage.setTitle("Hello world");
//
//        primaryStage.getIcons().add(new Image("pizza-box.png"));
////        Must be at the end
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        StackPane root = new StackPane();

        Image backgroundImage = new Image(getClass().getResource("/pizza-background.png").toExternalForm()); // Provide the correct path to your image
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1500);
        backgroundImageView.setFitHeight(800);

        VBox pizzaBox = new VBox();
        pizzaBox.setSpacing(20);
        pizzaBox.setPadding(new Insets(20));

        PizzaComponent pizza1 = new PizzaComponent(
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza1.setPizzaName("Margherita");
        pizza1.setPizzaDescription("Classic Margherita Pizza");
        pizza1.setEstimatedTime("20 minutes");

        PizzaComponent pizza2 = new PizzaComponent(
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza2.setPizzaName("Pepperoni");
        pizza2.setPizzaDescription("Pepperoni Pizza");
        pizza2.setEstimatedTime("25 minutes");

        PizzaComponent pizza3 = new PizzaComponent(
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza3.setPizzaName("Vegetarian");
        pizza3.setPizzaDescription("Vegetarian Pizza");
        pizza3.setEstimatedTime("22 minutes");

        pizzaBox.getChildren().addAll(pizza1, pizza2, pizza3);

        root.getChildren().addAll(backgroundImageView, pizzaBox);

        Scene scene = new Scene(root, 1920, 1080);

        primaryStage.setTitle("Pizza App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}