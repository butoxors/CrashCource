package OOP;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CatTesting {
    private List<ACat> cats;

    @Test
    public void main(){
        initialize();
        getInfo();
    }

    private void initialize(){
        cats = new ArrayList<>();
        cats.add(new HomeCat("Vasya", "Abyssinian"));
        cats.add(new WildCat("Warrior", "Bengal"));
        cats.add(new HomeCat("Zippo", "British Shorthair"));
        cats.add(new WildCat("Boomerang", "Highlander"));
    }

    private void getInfo(){
        for (ACat cat:
             cats) {
            System.out.println(cat.getInfo());
        }
    }
}
