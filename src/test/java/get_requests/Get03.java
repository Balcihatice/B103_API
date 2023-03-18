package get_requests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Get03 {
/*
Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
 */


    @Test
    public void get03() {
        //set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        //Send the request and get the response
        Response response = given().
                when().
                get(url);
        response.prettyPrint();

        //Do assertion
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false), "userId", equalTo(2));


        //assertion with json
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals("et itaque necessitatibus maxime molestiae qui quas velit", jsonPath.getString("title"));
        Assert.assertEquals(false, jsonPath.getBoolean("completed"));
        Assert.assertEquals(2, jsonPath.getInt("userId"));

        //Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz.
        // Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
        //Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çaılışmayı durdurur.
    }

}
