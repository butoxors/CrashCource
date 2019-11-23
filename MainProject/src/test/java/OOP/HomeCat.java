package OOP;

public class HomeCat extends ACat {
    @Override
    public void play() {
        System.out.println("Play with human");
    }

    public HomeCat(){
        this("home cat", "unknown breed");
    }

    public HomeCat(String name, String breed){
        this.name = name;
        this.breed = breed;
    }

    public void layOnSofa(){
        System.out.println("Cat is laying on sofa");
    }

    public void spoilShoes(){
        System.out.println("Cat has spoiled your shoes");
    }
}
