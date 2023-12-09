package com.example.demo2.PizzaMenu;

import java.util.List;

public class PizzasList {
    public static  List<PizzaComponent> getPizzas() {
        PizzaComponent pizza1 = new PizzaComponent(
                1,
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza1.setPizzaName("Margherita");
        pizza1.setPizzaDescription("Classic Margherita Pizza");

        PizzaComponent pizza2 = new PizzaComponent(
                2,
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza2.setPizzaName("Pepperoni");
        pizza2.setPizzaDescription("Pepperoni Pizza");

        PizzaComponent pizza3 = new PizzaComponent(
                3,
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatos", "Pineapple")
        );
        pizza3.setPizzaName("Vegetarian");
        pizza3.setPizzaDescription("Vegetarian Pizza");

        PizzaComponent pizza4 = new PizzaComponent(
                4,
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Olives")
        );
        pizza4.setPizzaName("Mediterranean");
        pizza4.setPizzaDescription("Mediterranean Pizza");

        PizzaComponent pizza5 = new PizzaComponent(
                5,
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatoes", "Bacon")
        );
        pizza5.setPizzaName("Bacon Deluxe");
        pizza5.setPizzaDescription("Deluxe Pizza with Bacon");

        PizzaComponent pizza6 = new PizzaComponent(
                6,
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatoes", "Mushrooms")
        );
        pizza6.setPizzaName("Mushroom Madness");
        pizza6.setPizzaDescription("Pizza loaded with Mushrooms");

        PizzaComponent pizza7 = new PizzaComponent(
                7,
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Ham")
        );
        pizza7.setPizzaName("Hawaiian");
        pizza7.setPizzaDescription("Classic Hawaiian Pizza");

        PizzaComponent pizza8 = new PizzaComponent(
                8,
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatoes", "Sausage")
        );
        pizza8.setPizzaName("Sausage Feast");
        pizza8.setPizzaDescription("Pizza with a Feast of Sausage");

        PizzaComponent pizza9 = new PizzaComponent(
                9,
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatoes", "Peppers")
        );
        pizza9.setPizzaName("Spicy Veggie");
        pizza9.setPizzaDescription("Spicy Vegetable Pizza");

        PizzaComponent pizza10 = new PizzaComponent(
                10,
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Onions")
        );
        pizza10.setPizzaName("Onion Delight");
        pizza10.setPizzaDescription("Pizza with a Delight of Onions");

        return List.of(pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7, pizza8, pizza9, pizza10);
    }

}
