package heima.exercises.test;

import heima.exercises.Chef;
import heima.exercises.IFridge;
import heima.exercises.Vegetable;
import heima.exercises.exception.FridgeFullException;
import heima.exercises.test.doubles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ChefTest {
    @Test
    public void should_store_vegetable_to_fridge_given_not_full_stub_fridge() throws FridgeFullException {
        // Stub Double
        IFridge stubFridge = new StubFridge();
        Chef chef = new Chef(stubFridge);
        Vegetable dummyCabbage = VegetableBuilder.DummyCabbage();

        boolean isStored = chef.storeVegetables(dummyCabbage.getName(), dummyCabbage);

        assertTrue(isStored);
    }

    @Test
    public void should_not_store_vegetable_to_fridge_given_a_full_stub_fridge() throws FridgeFullException {
        // Stub Double
        IFridge stubFullFridge = new StubFullFridge();
        Chef chef = new Chef(stubFullFridge);
        Vegetable dummyCabbage = VegetableBuilder.DummyCabbage();

        boolean isStored = chef.storeVegetables(dummyCabbage.getName(), dummyCabbage);

        assertFalse(isStored);
    }

    @Test
    public void should_remaining_amount_reduce_when_store_vegetable_to_fridge() {
        // Syp Double 验证状态
        SpyFridge spyFridge = new SpyFridge();
        int amountBefore = spyFridge.remainingAmount();
        Chef chef = new Chef(spyFridge);
        Vegetable dummyCabbage = VegetableBuilder.DummyCabbage();

        chef.storeVegetables(dummyCabbage.getName(), dummyCabbage);

        assertEquals(amountBefore -1, spyFridge.remainingAmount());
    }

    @Test
    public void should_close_door_when_store_vegetable_to_fridge() throws FridgeFullException {
        // Syp Double 验证行为
        IFridge spyFridge = mock(IFridge.class);
        Chef chef = new Chef(spyFridge);
        Vegetable dummyCabbage = VegetableBuilder.DummyCabbage();

        chef.storeVegetables("Cabbage", dummyCabbage);

        verify(spyFridge).close();
    }

    @Test
    public void should_call_fridge_put_with_cabbage_when_store_vegetable_to_fridge_given_cabbage() throws FridgeFullException {
        // Mock Double 验证行为
        IFridge stubFridge = mock(MockFridge.class);
        Chef chef = new Chef(stubFridge);
        Vegetable dummyCabbage = VegetableBuilder.DummyCabbage();

        chef.storeVegetables(dummyCabbage.getName(), dummyCabbage);

        verify(stubFridge).put(dummyCabbage.getName(), dummyCabbage);
    }
}
