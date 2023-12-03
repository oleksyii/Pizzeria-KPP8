package code.example.demo2.OrdersManagement;

import java.lang.reflect.GenericArrayType;
import java.util.*;

public class Menu {
    private final Map<Integer, String> pizzas;
    private int counter;

    public Menu(List<Integer> pizzaIds){
        Map<Integer, String> allPizzas = getAllIdPizzasMap();
        pizzas = new HashMap<>();
        counter = 1;

        for (Map.Entry<Integer, String> entry : allPizzas.entrySet()) {
            if (pizzaIds.contains(entry.getKey())) {
                pizzas.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void addPizza(String pizza){
        this.pizzas.put(counter++, pizza);
    }

    public void setPizzas(Collection<String> pizzas) {
        pizzas.forEach(this::addPizza);
    }

    public String getPizzaById(int id){
        Optional<String> pizza = pizzas.entrySet()
                .stream()
                .filter(entry -> entry.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst();

        return pizza.orElse("");
    }

    public Integer getIdByName(String name){
        Optional<Integer> id = pizzas.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(Map.Entry::getKey)
                .findFirst();

        return id.orElse(0);
    }

    public Collection<String> getAllPizzas(){
        return pizzas.values();
    }

    public Map<Integer, String> getIdPizzaMap(){
        return pizzas;
    }

    public Collection<Integer> getIdsSet(){
        return pizzas.keySet();
    }

    public static Map<Integer, String> getAllIdPizzasMap() {
        Map<Integer, String> idPizzasMap = new HashMap<>();
        String[] pizzaNames = {"Margherita", "Pepperoni", "Vegetarian", "Mediterranean", "Bacon Deluxe",
                "Mushroom Madness", "Hawaiian", "Sausage Feast", "Spicy Veggie", "Onion Delight"};

        for (int i = 0; i < pizzaNames.length; i++) {
            idPizzasMap.put(i + 1, pizzaNames[i]);
        }

        return idPizzasMap;
    }
}
