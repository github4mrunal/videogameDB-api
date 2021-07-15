package com.videogame;

import com.videogame.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class VideoGameDBTest extends TestBase {
    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);


    @Test

    public void getAllVideoGameInfo() {
        Response response =
                given()
                        .accept("application/json")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getVideoGameById(){
        Response response =
                given()
                        .accept("application/json")
                        .when()
                        .get("/10");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void postNewVideoGameProduct(){
         VideoGamePojo videoGamePojo = new VideoGamePojo();

        //double price = 49.99;
        videoGamePojo.setId(randomInt);
        videoGamePojo.setName("Super Mario III");
        videoGamePojo.setReleaseDate("2021-07-14T19:24:01.924Z");
        videoGamePojo.setReviewScore(99);
        videoGamePojo.setCategory("Jump");
        videoGamePojo.setRating("U");
       // videoGamePojo.setPrice(price);

        Response response =
                given()

       .header("Content-Type", "application/json")
                .body(videoGamePojo).accept("application/json")
                .when()
                .post();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void putNewInfoInVideoGame(){
        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId(2);
        videoGamePojo.setName("Super Mario VII");
        videoGamePojo.setReleaseDate("2021-07-14T19:24:01.924Z");
        videoGamePojo.setReviewScore(7);
        videoGamePojo.setCategory("kids");
        videoGamePojo.setRating("5");

        Response response =
                given()
                        .accept("application/json")
                        .header("Content-Type", "application/json")
                        .body(videoGamePojo)
                        .when()
                        .put("/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteInfoFromVideoGame(){
        VideoGamePojo videoGamePojo = new VideoGamePojo();
        Response response =
                given()
                        .pathParam("id", 1)
                        .when()
                        .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
