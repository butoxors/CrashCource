package Patterns.Adapter;

public class Boat implements ISeaTransport {
    @Override
    public void swim() {
        System.out.println("You are swimming now!");
    }
}
