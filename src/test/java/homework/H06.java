package homework;

import base_urls.RegresinBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class H06 extends RegresinBaseUrl {

    //1)

    /*
         Given
                https://reqres.in/api/unknown/
         When
              I send GET Request to the URL
         Then

              1)Status code is 200
              2)Print all pantone_values
                (Tüm pantone_value değerlerini yazdırınız)
              3)Print all ids greater than 3 on the console
                (3'ten büyük id'leri yazdırınız)
                Assert that there are 3 ids greater than 3
                (3'ten büyük 3 adet id olduğunu doğrulayınız)
              4)Print all names whose ids are less than 3 on the console
                (id'si 3'ten küçük isimleri yazdırınız)
                Assert that the number of names whose ids are less than 3 is 2
                (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
      */
    @Test
    public void get06() {
        spec.pathParam("first", "unknown");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data", hasSize(6));


//        1)Status code is 200
        response.then().assertThat().statusCode(200);

//        2)Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> pantone_values = json.getList("data.pantone_value");
        System.out.println("pantone_values = " + pantone_values);


//        3)Print all ids greater than 3 on the console
        List<Integer> ids = json.getList("data.findAll{it.id>3}.id");//Groovy
        System.out.println("ids = " + ids);//[4, 5, 6]

//        Assert that there are 3 ids greater than 3
        Assert.assertEquals(3, ids.size());

//        4)Print all names whose ids are less than 3 on the console
        List<String> names = json.getList("data.findAll{it.id<3}.name");
        System.out.println("names whose ids are less than 3 = " + names);

//        Assert that the number of names whose ids are less than 3 is 2
        Assert.assertEquals(2, names.size());

    }
}