package Patterns.Adapter;

public class BoatToAutoAdapter implements ITransport{
    ISeaTransport seaTransport;
    public BoatToAutoAdapter(ISeaTransport seaTransport){
        this.seaTransport = seaTransport;
    }

    @Override
    public void drive() {
        seaTransport.swim();
    }
}
