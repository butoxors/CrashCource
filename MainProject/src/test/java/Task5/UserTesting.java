package Task5;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTesting {
    private final String URL = "https://petstore.swagger.io/v2/user/";

    private User user;

    private RequestSpecification httpRequest;

    @BeforeClass(groups = "userTesting")
    public void setUp(){
        RestAssured.baseURI = URL;
        httpRequest = RestAssured.given();
        httpRequest.accept(ContentType.JSON.getAcceptHeader());

        user = new User();
        user.randomInitialize();
    }
    @Test(groups = "userTesting")
    public void createUser(){
        httpRequest.header("Content-Type", ContentType.JSON);

        httpRequest.body(user.convertToJsonObject().toString());

        Response response = httpRequest
                .post();

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("User was succesfully created!");
    }
    @Test(groups = "userTesting",
            priority = 1,
            dependsOnMethods = "createUser")
    public void getUser(){
        Response response = httpRequest
                .get(user.username);

        JsonPath userRequest = response.jsonPath();

        System.out.println(userRequest.getString("$"));

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(userRequest.getString("username"), user.username);
        Assert.assertEquals(userRequest.getString("password"), user.password);
    }

    @Test(groups = "userTesting",
            priority = 1,
            dependsOnMethods = "createUser")
    public void logInUser(){
        Response response = httpRequest
                .queryParam("username", user.username)
                .queryParam("password", user.password)
                .get("login");

        System.out.println(response.getBody().asString());
    }

    @Test(groups = "userTesting",
            priority = 2,
            dependsOnMethods = "createUser")
    public void deleteUser(){
        Response response = httpRequest
                .delete(user.username);
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("User was succesfully deleted!");
    }

}
