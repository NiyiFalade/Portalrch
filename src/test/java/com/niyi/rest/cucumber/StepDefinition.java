package com.niyi.rest.cucumber;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import Utils.Country;
import Utils.HelperMethods;
import Utils.RestUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;

import java.util.List;

public class StepDefinition {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private JsonPath jsonpath;


    @Given("^the countries services is running$")
    public void the_countries_services_is_running() {

        RestUtil.setBaseURI("https://restcountries.eu/rest/v2");
        RestUtil.setContentType(ContentType.JSON);

    }

    @When("^users want to get information on the all the countries$")
    public void users_want_to_get_information_on_the_all_the_countries() {

        response = RestUtil.getResponse();
    }

    @Then("^the status code is OK$")
    public void the_status_code_is() {

        HelperMethods.checkStatusCode(response);

    }

    @Then("^requested data is returned with (\\d+) countries$")
    public void requested_data_is_returned_with_countries(int arg1) {
        jsonpath = RestUtil.getJsonPath(response);
        assertEquals("no of countries is ", arg1, HelperMethods.getNumberOfCountries(jsonpath).size());

    }

    @When("^user wants to get information about \"([^\"]*)\"$")
    public void user_wants_to_get_information_about(String countryname) {
        response = RestUtil.getCountry(countryname);

    }


    @Then("^the response contains the following attributes:$")
    public void the_reponse_contains_the_following_attributes(DataTable attributes)  {

        List<List<String>> data = attributes.raw();

        List<String> name = response.path("name");
        List<String> capital = response.path("capital");
        List<String> region = response.path("region");
        List<String> numericCode = response.path("numericCode");

        assertThat(data.get(1).get(1), CoreMatchers.containsString(name.get(0)));
        assertThat(data.get(2).get(1), CoreMatchers.containsString(capital.get(0)));
        assertThat(data.get(3).get(1), CoreMatchers.containsString(region.get(0)));
        assertThat(data.get(4).get(1), CoreMatchers.containsString(numericCode.get(0)));

        //   System.out.println(response.prettyPrint());


    }

}