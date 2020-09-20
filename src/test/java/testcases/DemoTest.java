package testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    public void practice_test1() {
        String url = "https://reqres.in/api/users/2";

        RestAssured.given()
                .get(url)
                .andReturn()
                .getBody()
                .prettyPrint();
    }

    @Test
    public void practice_test2() {
        String url = "https://swapi.dev/api/people/1";

        Response response = RestAssured.given().
                get(url).
                andReturn();

        response.getBody().prettyPrint();
    }

}
