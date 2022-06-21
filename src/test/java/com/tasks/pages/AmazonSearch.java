package com.tasks.pages;

import com.tasks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearch {

    public AmazonSearch(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id ='nav-search-submit-button']")
    public WebElement searchButton;

    //@FindBy(xpath = "//span[@class='a-price']//span[@class='a-offscreen']")
    @FindBy(className = "a-price-whole")
    public List<WebElement> listOfPrices;

    @FindBy(className = "a-price-fraction")
    public List<WebElement> listOfFractions;

    @FindBy(xpath = "(//a[@class = 'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[4]")
    public WebElement selectItem;


    public void returnAvgPrice(List<WebElement> listOfPrices,List<WebElement> listOfFraction) {
        double sum = 0;
        int size = listOfPrices.size();
        List<Integer> whole = new ArrayList<>();
        List<Double> fraction = new ArrayList<>();
        for (WebElement eachPrice : listOfPrices) {
            String temp = eachPrice.getText();
            if (temp.length() == 0) {
                --size;
                continue;
            }
            temp = temp.replaceAll(",", "");
            sum+=Integer.parseInt(temp);

        }

        for (WebElement eachfraction : listOfFraction) {
            String temp = eachfraction.getText();
            temp = temp.replaceAll(",", "");
            if (temp.length() == 0) {
                continue;
            }
            sum+=(Double.parseDouble(temp)/100);

        }

        System.out.println("sum = " + String.format("%.2f",sum));

        System.out.println("average = " + String.format("%.2f",sum / listOfPrices.size()));
    }







}
