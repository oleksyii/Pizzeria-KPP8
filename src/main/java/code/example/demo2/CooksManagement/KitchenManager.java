package code.example.demo2.CooksManagement;

import code.example.demo2.CooksManagement.strategies.*;
import code.example.demo2.CooksManagement.strategies.ThreadStopper.Stopper;
import code.example.demo2.CooksManagement.strategies.ThreadStopper.Terminator;
import code.example.demo2.UIManagement.controllers.PizzeriaController;

import java.util.ArrayList;
import java.util.HashMap;

public class KitchenManager {
    static ArrayList<SpecificCook> cooks;
    static HashMap<Integer, Stopper> stoppers;
    static HashMap<Integer, Terminator> terminators;

    public KitchenManager(int cooksAmount, int minCookingTime){
        Cook.COOKING_TIME = minCookingTime;
        cooks = new ArrayList<>();
        stoppers = new HashMap<>();
        terminators = new HashMap<>();
        createCooks(cooksAmount);
    }
    public void createCooks(int amount){
        for(int i = 0; i < amount; i++){
            Stopper stp = new Stopper();
            Terminator ter = new Terminator();
             cooks.add(new SpecificCook(new FullCook(stp, ter), ter));
             stoppers.put(cooks.get(i).Id(), stp);
             terminators.put(cooks.get(i).Id(), ter);
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
                        cook.setStrategy(new FullCook(stoppers.get(cook.Id()), terminators.get(cook.Id())));
                    }
                }
            }
            case Baking -> {
                for (SpecificCook cook :
                        cooks) {
                    if (cook.Id() == id) {
                        cook.setStrategy(new BakingCook(stoppers.get(cook.Id()), terminators.get(cook.Id())));
//                        PizzeriaController.changeCookState(cook.Id(), CookType.Baking);
                    }
                }
            }
            case Creating -> {
                for (SpecificCook cook :
                        cooks) {
                    if (cook.Id() == id) {
                        cook.setStrategy(new CreatingCook(stoppers.get(cook.Id()), terminators.get(cook.Id())));
//                        PizzeriaController.changeCookState(cook.Id(), CookType.Creating);
                    }
                }
            }
        }
    }
    public void pauseCook(int id){
        for (SpecificCook cook :
                cooks) {
            if (cook.Id() == id) {
                stoppers.get(cook.Id()).putCookToSleep();
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

    public void stopCooks(){
        for (SpecificCook cook :
                cooks) {
            cook.terminate();
            cook.clearId();
            terminators.get(cook.Id()).putCookToStop();
        }
    }
}
