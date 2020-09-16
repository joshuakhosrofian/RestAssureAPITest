package testcases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReqresGetTest {

    @Test
    public void client_can_get_all_user() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";
        int expectedStatusCode = 200;
        String expectedProtocolVersion = "HTTP/1.1";

        // Test Steps
        // 1. form a request
        // 2. send the request
        // 3. capture the response
        // 4. extract the data and store them as actual
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);
        int actualStatusCode = response.getStatusCode();
        boolean actualProtocol = response.getStatusLine().contains(expectedProtocolVersion);
        String allHeaderInfo = response.getHeaders().toString();

        // Test Assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(actualStatusCode, expectedStatusCode);
        sAssert.assertTrue(actualProtocol);
    }

    @Test
    public void client_can_get_all_user_headers() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";
        String expectedContentType = "application/xml";
        String expectedServer = "cloudflare";


        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);


        // Test Assertion
        SoftAssert sAssert = new SoftAssert();

        sAssert.assertAll();

    }

    @Test
    public void client_can_get_all_user_body() {
        // Test Data
        String baseURI = "https://reqres.in/";
        String endpoint = "/api/users?page=2";


        // Test Steps
        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.request(Method.GET, endpoint);


        // Test Assertion
        SoftAssert sAssert = new SoftAssert();

        sAssert.assertAll();
    }

    @Test
    public void test4() {

        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification spec = RestAssured.given();
        Response response = spec.request(Method.GET, "/users/id/2");
        Response response1 = spec.get("/users/id/2");
        String statusLine = response.headers().toString();
        String headers = response.headers().toString();
        System.out.println(statusLine);
        System.out.println(headers);
    }


}

// Given() -> prep, form a request
// When() -> actions
// Then() -> ready for validation

// Request Type
// GET, PUT, POST, DELETE <--- method, req type