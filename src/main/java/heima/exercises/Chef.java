package heima.exercises;

import heima.exercises.exception.FridgeFullException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chef {
    private final IFridge fridge;

    public boolean storeVegetables ( String name, Object vegetable) {
        fridge.open();
        try {
            fridge.put(name, vegetable );
            return true;
        } catch (FridgeFullException e) {
            return false;
        } finally {
            fridge.close();
        }
    }
}
