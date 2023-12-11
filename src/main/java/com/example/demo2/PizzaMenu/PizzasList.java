package com.example.demo2.PizzaMenu;

import java.util.List;

public class PizzasList {
    public static  List<PizzaComponent> getPizzas() {
        PizzaComponent pizza1 = new PizzaComponent(
                1,
                List.of("Cheese", "Tomatos", "Pineapple"),
                "Margherita",
                "Classic Margherita Pizza"
        );

        PizzaComponent pizza2 = new PizzaComponent(
                2,
                List.of("Cheese", "Tomatos", "Pineapple"),
                "Pepperoni",
                "Pepperoni Pizza"
        );

        PizzaComponent pizza3 = new PizzaComponent(
                3,
                List.of("Cheese", "Tomatos", "Pineapple"),
                "Vegetarian",
                "Vegetarian Pizza"
        );

        PizzaComponent pizza4 = new PizzaComponent(
                4,
                List.of("Cheese", "Tomatoes", "Olives"),
                "Mediterranean",
                "Mediterranean Pizza"
        );

        PizzaComponent pizza5 = new PizzaComponent(
                5,
                List.of("Cheese", "Tomatoes", "Bacon"),
                "Bacon Deluxe",
                "Deluxe Pizza with Bacon"
        );

        PizzaComponent pizza6 = new PizzaComponent(
                6,
                List.of("Cheese", "Tomatoes", "Mushrooms"),
                "Mushroom Madness",
                "Pizza loaded with Mushrooms"
        );

        PizzaComponent pizza7 = new PizzaComponent(
                7,
                List.of("Cheese", "Tomatoes", "Ham"),
                "Hawaiian",
                "Classic Hawaiian Pizza"
        );

        PizzaComponent pizza8 = new PizzaComponent(
                8,
                List.of("Cheese", "Tomatoes", "Sausage"),
                "Sausage Feast",
                "Pizza with a Feast of Sausage"
        );

        PizzaComponent pizza9 = new PizzaComponent(
                9,
                List.of("Cheese", "Tomatoes", "Peppers"),
                "Spicy Veggie",
                "Spicy Vegetable Pizza"
        );

        PizzaComponent pizza10 = new PizzaComponent(
                10,
                List.of("Cheese", "Tomatoes", "Onions"),
                "Onion Delight",
                "Pizza with a Delight of Onions"
        );

        return List.of(pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7, pizza8, pizza9, pizza10);
    }

}
