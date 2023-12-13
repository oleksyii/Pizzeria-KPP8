package code.example.demo2.UIManagement.models;

import code.example.demo2.ClientsManagement.GeneratorManager.ClientGenerationStrategies;
import code.example.demo2.CooksManagement.SpecificCook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PizzeriaSimulatorTest {

    @Test
    void getKitchenManager() {
        PizzeriaSimulator.setInstance(
                4,
                3,
                new ArrayList<>(List.of(1)),
                ClientGenerationStrategies.Weekend,
                20000
        );
        PizzeriaSimulator p = PizzeriaSimulator.getInstance();
        ArrayList< SpecificCook > cooks = p.getKitchenManager().getCooks();

        while(true){

        }

    }
}