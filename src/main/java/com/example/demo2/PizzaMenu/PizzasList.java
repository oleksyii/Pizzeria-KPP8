package com.example.demo2.PizzaMenu;

import java.util.List;

public class PizzasList {
    public static  List<PizzaComponent> getPizzas() {
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

        PizzaComponent pizza4 = new PizzaComponent(
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Olives")
        );
        pizza4.setPizzaName("Mediterranean");
        pizza4.setPizzaDescription("Mediterranean Pizza");
        pizza4.setEstimatedTime("28 minutes");

        PizzaComponent pizza5 = new PizzaComponent(
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatoes", "Bacon")
        );
        pizza5.setPizzaName("Bacon Deluxe");
        pizza5.setPizzaDescription("Deluxe Pizza with Bacon");
        pizza5.setEstimatedTime("30 minutes");

        PizzaComponent pizza6 = new PizzaComponent(
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatoes", "Mushrooms")
        );
        pizza6.setPizzaName("Mushroom Madness");
        pizza6.setPizzaDescription("Pizza loaded with Mushrooms");
        pizza6.setEstimatedTime("26 minutes");

        PizzaComponent pizza7 = new PizzaComponent(
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Ham")
        );
        pizza7.setPizzaName("Hawaiian");
        pizza7.setPizzaDescription("Classic Hawaiian Pizza");
        pizza7.setEstimatedTime("24 minutes");

        PizzaComponent pizza8 = new PizzaComponent(
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                List.of("Cheese", "Tomatoes", "Sausage")
        );
        pizza8.setPizzaName("Sausage Feast");
        pizza8.setPizzaDescription("Pizza with a Feast of Sausage");
        pizza8.setEstimatedTime("27 minutes");

        PizzaComponent pizza9 = new PizzaComponent(
                "https://static.toiimg.com/thumb/56933159.cms?imgsize=686279&width=800&height=800",
                List.of("Cheese", "Tomatoes", "Peppers")
        );
        pizza9.setPizzaName("Spicy Veggie");
        pizza9.setPizzaDescription("Spicy Vegetable Pizza");
        pizza9.setEstimatedTime("29 minutes");

        PizzaComponent pizza10 = new PizzaComponent(
                "https://www.allrecipes.com/thmb/fFW1o307WSqFFYQ3-QXYVpnFj6E=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-4x3-BG-2974-a7a9842c14e34ca699f3b7d7143256cf.jpg",
                List.of("Cheese", "Tomatoes", "Onions")
        );
        pizza10.setPizzaName("Onion Delight");
        pizza10.setPizzaDescription("Pizza with a Delight of Onions");
        pizza10.setEstimatedTime("23 minutes");

        List<PizzaComponent> pizzas = List.of(pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7, pizza8, pizza9, pizza10);

        return pizzas;
    }

}
