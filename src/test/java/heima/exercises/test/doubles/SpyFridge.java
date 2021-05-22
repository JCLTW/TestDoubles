package heima.exercises.test.doubles;

public class SpyFridge extends MockFridge {
    public int remainingAmount() {
        return MAX_CAPACITY - items.size();
    }
}
