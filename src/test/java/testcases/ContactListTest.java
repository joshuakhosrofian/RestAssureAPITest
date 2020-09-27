package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ContactListTest extends ApiConfig {

    @Test
    public void get_contact_list() {
        RestAssured.baseURI = "http://3.13.86.142:3000";

        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/contacts/");

        System.out.println(response.statusLine());
        System.out.println(response.statusCode());

        response.getBody().prettyPrint();


    }

    @Test
    public void add_contact(){
        String path = System.getProperty("user.dir")+ "/src/test/resources/payloads/newContact.json";
        String payload = read(path).trim();

        RestAssured.baseURI = "http://3.13.86.142:3000";
        Response response = RestAssured.given()
                .contentType("Application/json; charset=utf-8")
                .body(payload)
                .post("/contacts/");

        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());

        response.getBody().prettyPrint();
    }

    @Test
    public void get_single_contact() {
        RestAssured.baseURI = "http://3.13.86.142:3000";

        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/contacts/5f44bbe71707340476577fbb");

        System.out.println(response.statusLine());
        System.out.println(response.statusCode());

        response.getBody().prettyPrint();
    }

    @Test
    public void update_existing_contact() {
        String path = System.getProperty("user.dir")+ "/src/test/resources/payloads/updatedContact.json";
        String payload = read(path).trim();

        RestAssured.baseURI = "http://3.13.86.142:3000";
        Response response = RestAssured.given()
                .contentType("Application/json; charset=utf-8")
                .body(payload)
                .put("/contacts/5f44b5981707340476577f9e");

        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());

        response.getBody().prettyPrint();
    }

    @Test
    public void delete_a_contact(){
        RestAssured.baseURI = "http://3.13.86.142:3000";

        Response response= RestAssured.given()
                .delete("/contacts/5f6e94da170734047657d3f8");

        System.out.println(response.statusLine());
        System.out.println(response.statusLine());

        response.getBody().prettyPrint();

    }
}

