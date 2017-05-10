package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 * Created by Ng2 on 09/05/2017.
 */
public class RestUtil {

    public static void setBaseURI(String baseURI){
        RestAssured.baseURI = baseURI;
    }

    public static void setContentType(ContentType Type){
        given().contentType(Type);
    }

    public static Response getResponse(){
        return given().relaxedHTTPSValidation().when().get("/all");
    }

    public static Response getCountry(String country){
      return   given().relaxedHTTPSValidation().pathParam("name", country).when().get("/name/{name}");

    }


    public static JsonPath getJsonPath(Response response){
        String json = response.asString();
        return  new JsonPath(json);
    }
}
