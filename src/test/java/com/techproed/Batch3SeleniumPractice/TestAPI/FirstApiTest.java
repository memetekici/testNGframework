package com.techproed.Batch3SeleniumPractice.TestAPI;
import static org.testng.Assert.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class FirstApiTest {
    //Verify sorting hat
    //1.Send a get request to /sortingHat. Request includes :
    //2.Verify status code 200,
    //3.Verify the content type is application/json; charset=utf-8
    //4. Verify that response body contains one of the following houses:
    //        "Gryﬃndor", "Ravenclaw", "Slytherin", "Huﬄepuﬀ"

    String URI = "https://www.potterapi.com/v1/";

    @Test
    public void sortingHat() {
        Response response = given().when().get(URI + "sortingHat");
        System.out.println(response.prettyPrint());
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        List<String> allHouse = Arrays.asList("\"Gryffindor\"", "\"Ravenclaw\"", "\"Slytherin\"", "\"Hufflepuff\"");
        System.out.println(allHouse);
        assertTrue(allHouse.contains(response.body().asString()));

    }
    //Verify no key
    //1.Send a get request to /characters. Request includes :
    //      • Header Accept with value application/json
    //2. Verify status code 409, content type application/json; charset=utf-8
    //3. Verify response status line include message Conﬂict
    //4. Verify that response body says "error": "Must pass API key for request"
    @Test
    public void noKey(){
        Response response = given().accept(ContentType.JSON).when().get(URI + "characters");
        assertEquals(response.statusCode(),409);
        assertEquals(response.contentType(),"application/json; charset=utf-8");
        assertTrue(response.statusLine().contains("Conflict"));
        assertEquals(response.path("error"),"Must pass API key for request");

    }
}