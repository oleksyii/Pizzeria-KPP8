package com.example.demo2;

import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import javafx.application.Application;
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

//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        primaryStage.setTitle("Hello world");
//
//        primaryStage.getIcons().add(new Image("pizza-box.png"));
////        Must be at the end
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        SettingsPage settingsPage = new SettingsPage();
        MenuPage menuPage = new MenuPage();
        menuPage.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}