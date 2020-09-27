package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PublicContactListTest extends ApiConfig {

    @Test
    public void register_single_user(){

        String payload = "{" +
                "   \"email\": \"nijat9987@example.com\"," +
                "   \"password\": \"SuperSecretPassword123\"" +
                "}";
        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "Application/json");
        spec.body(payload);

        Response response = spec.post("/pcl/auth/register");

        System.out.println( response.getStatusLine());

    }

    @Test
    public void register_single_user_file_payload(){

        String path = System.getProperty("user.dir")+ "/src/test/resources/payloads/newUser.txt";
        String payload = read(path).trim();
        payload.trim();

        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "Application/json");
        spec.body(payload);

        System.out.println("PAYLOAD: >" + payload);

        Response response = spec.post("/pcl/auth/register");

        System.out.println( response.getStatusLine());

    }

    @Test
    public void login_registered_user(){

        String payload = "{" +
                "   \"email\": \"user@example.com\"," +
                "   \"password\": \"SuperSecretPassword123\"" +
                "}";


        RestAssured.baseURI = "https://craftplacer.trexion.com";
        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "Application/json");
        spec.body(payload);

        Response response = spec.post("/pcl/auth/login");

        System.out.println( response.getStatusLine());
        String sessionToken = response.getBody().asString();
        System.out.println(sessionToken);

    }

    @Test
    public void logout_single_user() {
        // 1. Login a user

        String path = System.getProperty("user.dir")+ "/src/test/resources/payloads/newUser.txt";
        String payload = read(path).trim();

        RestAssured.baseURI = base_uri;
        Response response = RestAssured.given().contentType("Application/json").body(payload).post("/pcl/auth/login");
        String sessionToken = response.getBody().asString();

        // logout a user <---- Text Steps
        RestAssured.given()
                .header("Authorization", sessionToken)
                .get("/pcl/auth/logout");
    }




}
