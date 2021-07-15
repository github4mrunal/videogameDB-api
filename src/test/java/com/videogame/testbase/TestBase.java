package com.videogame.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/*
 *  Created by Jay
 */
public class TestBase {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/app/videogames";
    }

}
