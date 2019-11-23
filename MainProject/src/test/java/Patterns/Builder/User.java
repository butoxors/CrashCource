package Patterns.Builder;

public class User {
    public String username;
    public String email;

    public String getInfo(){
        return "Username: " + username
                + "\r\nEmail: " + email;
    }
}
