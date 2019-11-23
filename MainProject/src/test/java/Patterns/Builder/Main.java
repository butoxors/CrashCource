package Patterns.Builder;

import org.testng.annotations.Test;

public class Main {

    @Test
    public void testUserBuilder(){
        IBuilder<User> builder = new DefaultUserBuilder();
        Creator<User> creator = new Creator<>(builder);

        creator.build();

        User user = creator.getResult() ;

        System.out.println(user.getInfo());

        //System.out.println("Username: " + user.username + "; Email: " + user.email);
    }
}
