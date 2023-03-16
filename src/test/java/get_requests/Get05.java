package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
            https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
     */

    @Test
    public void get05() {
        spec.pathParam("parametre", "booking").
                queryParams("firstname", "Sally",
                        "lastname", "Brown");
        //set the expected data


        //send the request and get the response
        Response response
                = given().spec(spec).when().get("/{parametre}");
        response.prettyPrint();

        //Do Assertion
        response.then().statusCode(200);//Status code is 200

        // Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        assertTrue(response.asString().contains("bookingid"));
    }

}
