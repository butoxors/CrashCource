package Task5;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class User {

    public String firstName;
    public String lastName;
    public String password;
    public int userStatus;
    public String phone;
    public int id;
    public String email;
    public String username;


    public User(){}

    public void initialize(){
        this.id = 1996;
        this.username = "butoxors";
        this.firstName = "Ivan";
        this.lastName = "Khoroshevskiy";
        this.email = "email@student.csn.khai.edu";
        this.password = "qwerty123";
        this.phone = "911";
        this.userStatus = 1;
    }

    public JsonObject convertToJsonObject(){
        JsonObject userProperties = new JsonObject();

        userProperties.addProperty("id", id);
        userProperties.addProperty("username", username);
        userProperties.addProperty("firstName", firstName);
        userProperties.addProperty("lastName", lastName);
        userProperties.addProperty("email", email);
        userProperties.addProperty("password", password);
        userProperties.addProperty("phone", phone);
        userProperties.addProperty("userStatus", userStatus);

        return userProperties;
    }

    public void randomInitialize(){

        this.id = new Random().nextInt(9999);
        this.username = RandomStringUtils.random(10, true, true);
        this.firstName = RandomStringUtils.random(15, true, false);
        this.lastName = RandomStringUtils.random(15, true, false);
        this.email = RandomStringUtils.random(10, true, true) + "@mail.ru";
        this.password = RandomStringUtils.random(15, true, true);
        this.phone = RandomStringUtils.random(14, false, true);
        this.userStatus = 1;
    }
}
