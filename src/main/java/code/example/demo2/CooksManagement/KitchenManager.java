package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.*;

import java.util.ArrayList;

public class KitchenManager {
    static ArrayList<SpecificCook> cooks;


    public KitchenManager(int cooksAmount, int minCookingTime){
        Cook.COOKING_TIME = minCookingTime;
        cooks = new ArrayList<>();
        createCooks(cooksAmount);
    }
    public void createCooks(int amount){
        for(int i = 0; i < amount; i++){
             cooks.add(new SpecificCook(new FullCook()));
        }
    }
    public void startCooks(){
        for (SpecificCook cook :
                cooks) {
            cook.executeStrategy();
        }
    }


    public void morphCook(int id, CookType type){
        switch (type){
            case Full -> {
                for (SpecificCook cook :
                        cooks) {
                    if (cook.Id() == id) {
                        cook.setStrategy(new FullCook());
                    }
                }
            }
            case Baking -> {
                for (SpecificCook cook :
                        cooks) {
                    if (cook.Id() == id) {
                        cook.setStrategy(new BakingCook());
                    }
                }
            }
            case Creating -> {
                for (SpecificCook cook :
                        cooks) {
                    if (cook.Id() == id) {
                        cook.setStrategy(new CreatingCook());
                    }
                }
            }
        }
    }
    public void pauseCook(int id){
        for (SpecificCook cook :
                cooks) {
            if (cook.Id() == id) {
                cook.pause();
            }
        }
    }

    static public CookStatus getCookStatus(int id) {
        for (SpecificCook cook :
                cooks) {
            if (cook.Id() == id) {
                return cook.getCookStatus();
            }
        }

        return null;
    }

    public ArrayList<SpecificCook> getCooks() {return cooks;}
}
