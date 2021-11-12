package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {

    WebDriver driver;

    //Create the Constructor(
    public FaceLoginPage(WebDriver driver){
        this.driver = driver;
        //initElements initializes the driver in page object model
        PageFactory.initElements(driver,this);
        //we use initElements to initialize the driver in the
    }

    @FindBy(id = "email")
    public WebElement username;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement login;

    //Create the errorMessage element
    //Call it in the assertion in test class
    //REFACTOR

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement errorMessage;
}
