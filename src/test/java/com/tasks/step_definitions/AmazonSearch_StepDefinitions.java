package com.tasks.step_definitions;

import com.tasks.pages.AmazonSearch;
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

    AmazonSearch amazonSearch=new AmazonSearch();
    List<WebElement> allElements;
    List<String> allElementsText1st = new ArrayList<>();
    List<Integer> allPrices =new ArrayList<>();




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



         String expectedTitle = "Amazon.com : " +string;
         String actualTitle = Driver.getDriver().getTitle();
         Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);

    }

    @Then("user sees list of results on the homepage")
    public void user_sees_list_of_results_on_the_homepage() {

        for (WebElement each : allElements) {

            allElementsText1st.add(each.getText());

        }
        while (allElementsText1st.contains("")) {

            allElementsText1st.remove("");
        }

    }


    @Then("user get the average price of all listed guitar")
    public void user_get_the_average_price_of_all_listed_guitar() {
            int total = 0;

            try {

                for (String eachPrice : allElementsText1st) {

                    int sum = Integer.parseInt(eachPrice);

                    total += sum;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("total = " + total);

            int averagePrice = total / allElementsText1st.size();

            System.out.println("averagePrice = " + averagePrice);

        }


    }




