package heima.exercises.test.doubles;

import heima.exercises.IFridge;
import heima.exercises.exception.FridgeFullException;

public class MockFridge implements IFridge {
    @Override
    public void put(String name, Object item) throws FridgeFullException {
        if(name.equals("Cabbage") && item.toString().equals("A big cabbage")) {
            items.put(name, item);
        }
    }

    @Override
    public Object get(String name) {
        return null;
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}
