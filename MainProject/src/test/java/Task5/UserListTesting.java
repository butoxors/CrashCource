package Task5;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserListTesting {
    private final String URL = "https://petstore.swagger.io/v2/user/";
    private final String ARRAY_REQUEST = "createWithArray";
    private int indexOfUser;
    private List<User> users;

    private RequestSpecification httpRequest;

    @BeforeClass(groups = "userListTesting")
    public void setUp(){
        RestAssured.baseURI = URL;

        indexOfUser = new Random().nextInt(10);

        httpRequest = RestAssured.given();
        httpRequest.accept(ContentType.JSON.getAcceptHeader());

        users = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            users.add(new User());
            users.get(i).randomInitialize();
        }
    }
    @Test(groups = "userListTesting")
    public void createUsers(){
        System.out.println(users.size());

        String json = new Gson().toJson(users);

        httpRequest.header("Content-Type", ContentType.JSON);
        httpRequest.body(json);

        Response response = httpRequest
                .post(ARRAY_REQUEST);

        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(groups = "userListTesting",
            priority = 1,
            dependsOnMethods = "createUsers")
    public void getAllUsers(){
        System.out.println(users.size());
        for (User user:
             users) {
            Response response = httpRequest
                    .get(user.username);

            JsonPath userRequest = response.jsonPath();

            if (response.getStatusCode() == 200) {
                System.out.println("User has founded!");
                System.out.println(userRequest.getString("$"));

                Assert.assertEquals(response.statusCode(), 200);
                Assert.assertEquals(userRequest.getString("username"), user.username);
                Assert.assertEquals(userRequest.getString("password"), user.password);
            }
            else {
                System.out.println("User has deleted!");
                Assert.assertEquals(response.statusCode(), 404);
            }
        }
    }
    @Test(groups = "userListTesting",
            priority = 2,
            dependsOnMethods = "createUsers")
    public void updateUser(){
        User user = users.get(indexOfUser);

        String oldName = user.username;

        user.randomInitialize();

        Response response = httpRequest
                .body(user.convertToJsonObject())
                .put(oldName);

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("User " + oldName + " succesfully created!");
    }
    @Test(groups = "userListTesting",
            priority = 3,
            dependsOnMethods = "createUsers")
    public void getUser(){
        int indexOfUser = 9;
        User user = users.get(indexOfUser);

        Response response = httpRequest
                .get(user.username);

        JsonPath userRequest = response.jsonPath();

        System.out.println(userRequest.getString("$"));

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(userRequest.getString("username"), user.username);
        Assert.assertEquals(userRequest.getString("password"), user.password);
    }

    @Test(groups = "userListTesting",
            priority = 4,
            dependsOnMethods = "createUsers")
    public void deleteAllUsers(){
        for (User user:
             users) {
            Response response = httpRequest
                    .delete(user.username);

            Assert.assertEquals(response.statusCode(), 200);
        }

        getAllUsers();
    }
}
