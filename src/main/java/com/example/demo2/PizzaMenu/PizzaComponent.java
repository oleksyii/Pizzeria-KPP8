package com.example.demo2.PizzaMenu;

import code.example.demo2.UIManagement.models.PizzeriaSimulator;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import java.util.*;

public class PizzaComponent extends HBox {
    public PizzaComponent(Integer id, List<String> ingredients, String name, String description) {
        Label nameLabel = new Label();
        nameLabel.setText(name);
        Label descriptionLabel = new Label();
        descriptionLabel.setText(description);

        nameLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 32px; -fx-font-weight: 800; -fx-underline: true; -fx-text-fill: white;");

        CheckBox checkBox = new CheckBox();

        PizzeriaSimulator instance = PizzeriaSimulator.getInstance();
        Set<Integer> pizzasIds = new HashSet<>(instance.getMenu().getIdsSet());

        if(pizzasIds.contains(id)) {
            checkBox.setSelected(true);
        }

        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                instance.addPizza(id);
            } else {
                instance.removePizza(id);
            }
        });

        VBox checkBoxVBox = new VBox();
        checkBoxVBox.getChildren().add(checkBox);
        checkBoxVBox.setAlignment(Pos.CENTER);
        checkBoxVBox.setPadding(new Insets(10, 0, 0, 10));

        HBox nameHBox = new HBox();
        nameHBox.getChildren().addAll(nameLabel, checkBoxVBox);

        descriptionLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 16px; -fx-font-weight: 700; -fx-text-fill: #5F2D04;");

        String resourceName = "/pizzas/" + id % 5 + ".jpg";
        ImageView imageView = new ImageView(new Image(getClass().getResource(resourceName).toExternalForm()));
        imageView.setFitWidth(148);
        imageView.setFitHeight(148);

        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(10);
        clip.setArcHeight(10);
        imageView.setClip(clip);

        StackPane imageStackPane = new StackPane();
        imageStackPane.setMaxWidth(170);
        imageStackPane.setMinWidth(170);
        imageStackPane.setMaxHeight(170);
        imageStackPane.setMinHeight(170);
        imageStackPane.setStyle("-fx-background-color: #5F2D04; -fx-background-radius: 10;");
        imageStackPane.getChildren().add(imageView);

        HBox ingredientsHBox = new HBox();
        ingredientsHBox.setSpacing(5);

        for (String ingredient : ingredients) {
            PizzaIngredient pizzaIngredient = new PizzaIngredient(ingredient);
            ingredientsHBox.getChildren().add(pizzaIngredient);
        }

        StackPane spacer = new StackPane();
        spacer.setMinHeight(40);

        VBox labelsVBox = new VBox();
        labelsVBox.getChildren().addAll(nameHBox, descriptionLabel, spacer, ingredientsHBox);
        labelsVBox.setSpacing(5);

        HBox imageAndLabelsHBox = new HBox();
        imageAndLabelsHBox.getChildren().addAll(imageStackPane, labelsVBox);
        imageAndLabelsHBox.setSpacing(20);

        VBox contextAndTimeVBox = new VBox();

        contextAndTimeVBox.getChildren().add(imageAndLabelsHBox);
        contextAndTimeVBox.setSpacing(10);

        getChildren().addAll(contextAndTimeVBox);
        setPadding(new Insets(25, 0, 15, 0));
    }
}
