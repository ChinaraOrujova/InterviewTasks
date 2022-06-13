package com.tasks.step_definitions;

import com.tasks.pages.AmazonSearch;
import com.tasks.utilities.ConfigurationReader;
import com.tasks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearch_StepDefinitions {

    AmazonSearch amazonSearch=new AmazonSearch();

    @Given("user is on the homepage of Amazon")
    public void user_is_on_the_homepage_of_Amazon() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }

    @And("user enter {string} on search box")
    public void user_enter_on_search_box(String string) {
        amazonSearch.searchBox.sendKeys(string);

    }

    @When("user click on the search button")
    public void user_click_on_the_search_button() {
        amazonSearch.searchButton.click();

    }

    @Then("user sees {string} on the homepage")
    public void user_sees_on_the_homepage(String string) {

            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //BrowserUtils.verifyURLContains(string);

         String expectedTitle = "Amazon.com : " +string;
         String actualTitle = Driver.getDriver().getTitle();
         Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);

    }

    @Then("user sees list of  {string} on the homepage")
    public void user_sees_list_of_on_the_homepage(String string) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


       for(WebElement eachItemPrice: amazonSearch.allListedItemsPrice){
           System.out.println(eachItemPrice.getText());
       }











    }

    @Then("user get the average price of all listed {string}")
    public void user_get_the_average_price_of_all_listed(String string) {

    }


}
