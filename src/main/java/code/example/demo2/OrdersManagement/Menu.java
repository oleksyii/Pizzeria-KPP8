package code.example.demo2.OrdersManagement;

import java.lang.reflect.GenericArrayType;
import java.util.*;

public class Menu {

    private Map<Integer, String> pizzas;
    private int counter;
    Menu(){
        pizzas = new HashMap<>();
        counter = 1;
    }

    Menu(Collection<String> pizzas){
        pizzas.forEach(this::addPizza);
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
    public static void main(String[] args) {

    }

}
