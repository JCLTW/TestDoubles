package heima.exercises;

import heima.exercises.exception.FridgeFullException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface IFridge {
    Map<String, Object> items = new ConcurrentHashMap<>();
    final int MAX_CAPACITY = 5;
    public void put(String name, Object item) throws FridgeFullException;

    public Object get(String name);
    public void open();
    public void close();
    public boolean isFull();
}