package com.example.demo2.PizzaMenu;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class PizzaIngredient extends HBox {
    public PizzaIngredient(String ingredient) {
        Label ingredientLabel = new Label();
        ingredientLabel.setText(ingredient);
        ingredientLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 14px; -fx-font-weight: 700; -fx-text-fill: white;");

        StackPane ingredientStackPane = new StackPane();
        ingredientStackPane.setStyle("-fx-background-color: #AF5D26; -fx-background-radius: 10;");
        ingredientStackPane.setPadding(new Insets(1, 9, 1, 9));
        ingredientStackPane.getChildren().add(ingredientLabel);

        getChildren().addAll(ingredientStackPane);
    }
}