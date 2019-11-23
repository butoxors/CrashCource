package OOP;

public class WildCat extends ACat {
    @Override
    public void play() {
        System.out.println("Play with other wild cat");
    }

    public WildCat(){
        this("wild cat", "unknown breed");
    }

    public WildCat(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public void hatePeople(){
        System.out.println("I hate you!");
    }
}
