package Patterns.Adapter;

public class Driver {
    public void travel(ITransport transport){
        transport.drive();
    }
}
