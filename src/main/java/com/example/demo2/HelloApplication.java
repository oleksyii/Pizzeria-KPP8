package com.example.demo2;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import com.example.demo2.Configuration.PizzaConfiguration;
import com.example.demo2.MainPage.MainPage;
import com.example.demo2.PizzaMenu.MenuPage;
import com.example.demo2.Settings.SettingsPage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PizzaConfiguration configuration = new PizzaConfiguration();
        configuration.start(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}