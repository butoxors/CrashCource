package Patterns.Builder;

public class DefaultUserBuilder implements IBuilder<User>{
    private User defaultUser;

    public DefaultUserBuilder(){
        defaultUser = new User();
    }

    @Override
    public void buildName(){
        defaultUser.username = "username";
    }

    @Override
    public void buildEmail() {
        defaultUser.email = "google@gmail.com";
    }

    public User getResult(){
        return defaultUser;
    }
}
