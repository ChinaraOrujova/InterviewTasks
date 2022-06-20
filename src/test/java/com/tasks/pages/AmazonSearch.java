package com.tasks.pages;

import com.tasks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearch {

    public AmazonSearch(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id ='nav-search-submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-price']//span[@class='a-offscreen']")
    public List<WebElement> allElements;






}
