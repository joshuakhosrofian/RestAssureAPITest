package testcases;

import commons.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class VideoGameDBTest extends ApiConfig {

    @Test
    public void get_all_video_games() {
        RestAssured.baseURI= gameDb_base_uri;
        Response response = RestAssured.given()
                .contentType("Application/json")
                .get("/videogames");

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();
    }

    @Test
    public void register_single_game() {

        String path = System.getProperty("user.dir") + "src/test/resources/payloads/newGame.json";
        String payload = read(path).trim();

        RestAssured.baseURI = gameDb_base_uri;
        Response response = RestAssured.given()
                .contentType("Application/json")
                .accept("Application/json")
                .body(payload)
                .post("/videogames");

        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusCode());
        response.getBody().prettyPrint();
    }

    @Test
    public void delete_single_videogame() {
        RestAssured.baseURI = gameDb_base_uri;
        Response response = RestAssured.given()
                .accept("Application/json")
                .delete("/videogames/10");

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

    }

    @Test
    public void get_single_game() {
        RestAssured.baseURI = gameDb_base_uri;
        Response response = RestAssured.given()
                .header("Accept", "Application/json")
                .get("/videogames/5");

        System.out.println(response.getStatusLine());
        response.getBody().prettyPrint();

    }

//    @Test
//    public void update_single_game() {
//        RestAssured baseURI = gameDb_base_uri;
//        Res
//    }
}
