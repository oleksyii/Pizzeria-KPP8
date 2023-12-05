package code.example.demo2.UIManagement.models;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.CooksManagement.strategies.CookType;
import code.example.demo2.OrdersManagement.Task;

import java.util.ArrayList;
import java.util.List;

public class PizzeriaSimulatorTestMain {
    public static void main (String[] args){
        PizzeriaSimulator p = new PizzeriaSimulator(
                3,
                2,
                new ArrayList<>(List.of(1, 2, 4, 6)),
                ClientGenerationStrategies.Weekend,
                20000
        );

        // TODO: WARNING DO NOT USE DIFFERENT TYPES OF COOKS, THEY SEEM TO NOT TO WILLING TO FINISH WITH .interrupt(), please, help fix

//        p.getKitchenManager().morphCook(1, CookType.Creating);
//        p.getKitchenManager().morphCook(3, CookType.Baking);
//        p.getKitchenManager().morphCook(2, CookType.Baking);

        System.out.println(p.getKitchenManager().getCooks());

        while(true){
//            List<Task> t = p.getAllTasks();
//            for (Task task:
//                 t) {
//                System.out.println(task);
//            }
        }
    }
}
