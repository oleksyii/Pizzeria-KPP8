package code.example.demo2.UIManagement.models;

import code.example.demo2.UIManagement.controllers.GeneratorManager.ClientGenerator;

public class Settings {
    private static Settings instance;

    private int cooksNumber;
    private int cashierNumber;
    private int minCountPizzas;
    private int minCookingTime;
    private ClientGenerator clientGeneratorStrategy;

    private Settings() {

    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void setCooksNumber(int cooksNumber) {
        this.cooksNumber = cooksNumber;
    }

    public void setCashierNumber(int cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    public void setMinCountPizzas(int minCountPizzas) {
        this.minCountPizzas = minCountPizzas;
    }

    public void setMinCookingTime(int minCookingTime) {
        this.minCookingTime = minCookingTime;
    }

    public void setClientGeneratorStrategy(ClientGenerator clientGeneratorStrategy) {
        this.clientGeneratorStrategy = clientGeneratorStrategy;
    }

}
