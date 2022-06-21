package com.tasks.step_definitions;

import com.tasks.pages.AmazonSearch;
import com.tasks.utilities.BrowserUtils;
import com.tasks.utilities.ConfigurationReader;
import com.tasks.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearch_StepDefinitions {

    AmazonSearch amazonSearch = new AmazonSearch();



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


        String expectedTitle = "Amazon.com : " + string;
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);

    }

    @When("user click on the search button and see all the listed guitar")
    public void user_click_on_the_search_button_and_see_all_the_listed_guitar() {
        amazonSearch.searchButton.click();

    }

    @Then("user get the average price of all listed guitars")
    public void user_get_the_average_price_of_all_listed_guitars() {
        amazonSearch.returnAvgPrice(amazonSearch.listOfPrices,amazonSearch.listOfFractions);


    }

    @Then("user choose one item from the list")
    public void user_choose_one_item_from_the_list() {
        amazonSearch.selectItem.click();


        String expectedTitleContains = "Guitar";
        Assert.assertTrue("Title is as expected", Driver.getDriver().getTitle().contains(expectedTitleContains));


    }
}





