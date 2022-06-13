package com.tasks.step_definitions;


import com.tasks.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;


public class AmazonAPISearch {
    Response response;

    @When("I send GET request")
    public void i_send_GET_request() {
        response = given().accept(ContentType.JSON)
                .and()
                .when().get(ConfigurationReader.getProperty("base_url"));

        response.prettyPrint();
    }


    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
        System.out.println(response.statusCode());
        Assert.assertEquals(statusCode, response.statusCode());
    }



}
