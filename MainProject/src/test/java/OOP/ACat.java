package OOP;

public abstract class ACat implements IPlayable {
    protected String name;
    protected String breed;

    public final String getInfo(){
        return "Name: " + name + "; Breed: " + breed;
    }
}
