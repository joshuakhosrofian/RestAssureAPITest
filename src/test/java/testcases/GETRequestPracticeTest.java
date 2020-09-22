package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import org.testng.annotations.Test;
import utility.Steps;

public class GETRequestPracticeTest {

    @Test
    public void get_request_practice1() {
        // 1. Register a baser URI where the request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify the request that will be sent
        Steps.log("Preparing GET request");
        RequestSpecification spec = RestAssured.given();
        Steps.log("Sending a GET request to endpoint to /api/users/2");
        Response response = spec.get("/api/users/2");
        Steps.log("We received the response from the server");

        // 3. Using the response object, let's extract each part of the response
        // (status line, headers, body)
        Steps.log(response.statusLine());
//        System.out.println( response.statusCode() );

        // Headers
        Headers headers = response.headers();
        String entireHeaders = headers.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        Steps.logJson(payload);
        // to extract a specific dta from payload
        String emailVal = JsonPath.read(payload, "$.data.email");
        String firstNameVal = JsonPath.read(payload, "$.data.first_name");
        String lastNameVal = JsonPath.read(payload, "$.data.last_name");
        String adCompVal = JsonPath.read(payload, "$.ad.company");

        System.out.println("Email: " + emailVal);
        System.out.println("First Name: " + firstNameVal);
        System.out.println("Last Name : " + lastNameVal);
        System.out.println("Ad computer" + adCompVal);

    }

    @Test
    public void get_list_of_users_test1(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users?page=2");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

        // CHANGE to extract a specific data from payload
        String emailVal = JsonPath.read(payload, "$.data.email");
        String firstNameVal = JsonPath.read(payload, "$.data.first_name");
        String lastNameVal = JsonPath.read(payload, "$.data.last_name");
        String adCompVal = JsonPath.read(payload, "$.ad.company");

        System.out.println("Email: " + emailVal);
        System.out.println("First Name: " + firstNameVal);
        System.out.println("Last Name : " + lastNameVal);
        System.out.println("Ad computer" + adCompVal);



    }

    @Test
    public void get_single_user_not_found_test2(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/23");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body: Do I need this since it will be error 404?
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_list_resource_test3(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/unknown");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_single_resource_test4(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/unknown/2");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_single_resource_not_found_test5(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/unknown/23");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body: Do I need this since it will be error 404?
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_delayed_response_test6(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://reqres.in/";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users?delay=3");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_all_countries_test7(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://restcountries.eu";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/rest/v2/all");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_estonia_Info_test8(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://restcountries.eu";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/rest/v2/name/eesti");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_pokemon_berries_test9(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://pokeapi.co";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/v2/berries/{id or name}/");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }

    @Test
    public void get_pokemon_contest_types_test10(){
        // 1. Register base URI where request will be sent
        RestAssured.baseURI = "https://pokeapi.co";

        // 2. Specify that the request will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/v2/contest-type/{id or name}/");
        // 3. Using the response object, extract each part of the response
        // (status line, header, body)
        System.out.println( response.statusLine());
        System.out.println( response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeaders = response.toString();
        System.out.println(entireHeaders);
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");
        System.out.println(contentType);
        System.out.println(server);
        System.out.println(date);

        // Body
        String payload = response.getBody().asString();
        // to extract a specific data from payload
        System.out.println(payload);
        response.body().prettyPrint();

    }



}
