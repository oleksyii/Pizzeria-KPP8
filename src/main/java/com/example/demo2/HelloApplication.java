package com.example.demo2;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.CooksManagement.strategies.CookType;
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

        SettingsPage settingsPage = new SettingsPage();
        MenuPage menuPage = new MenuPage();
        PizzaConfiguration configuration = new PizzaConfiguration();
        MainPage mainPage = new MainPage();
        mainPage.start(primaryStage);

        PizzeriaSimulator p = new PizzeriaSimulator(
                4,
                3,
                new ArrayList<>(List.of(1)),
                ClientGenerationStrategies.Weekend,
                10000
        );

//        menuPage.start(primaryStage);
//        settingsPage.start(primaryStage);

//        p.getKitchenManager().morphCook(1, CookType.Creating);
//        p.getKitchenManager().morphCook(2, CookType.Creating);
//        p.getKitchenManager().morphCook(3, CookType.Baking);
//        p.getKitchenManager().morphCook(4, CookType.Baking);
    }

    public static void main(String[] args) {
        launch(args);
    }
}