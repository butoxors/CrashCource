package Patterns.Adapter;

import org.testng.annotations.Test;

public class AdapterTest {
    @Test
    public void AdapterTesting(){
        Driver driver = new Driver();
        ITransport auto = new Auto();
        driver.travel(auto);

        ISeaTransport boat = new Boat();
        ITransport boatTransport = new BoatToAutoAdapter(boat);
        driver.travel(boatTransport);
    }
}
