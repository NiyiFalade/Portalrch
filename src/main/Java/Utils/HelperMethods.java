package Utils;

import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;


public class HelperMethods {

    public static void checkStatusCode(Response response){
        assertEquals("status is ", 200, response.getStatusCode());
    }

    public static ArrayList getNumberOfCountries (JsonPath jsonpath){

        ArrayList countries  = jsonpath.get("name");

        return countries;

    }





}
