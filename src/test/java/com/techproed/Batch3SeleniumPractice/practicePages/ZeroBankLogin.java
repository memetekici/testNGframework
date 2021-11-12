package com.techproed.Batch3SeleniumPractice.practicePages;

import com.techproed.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Go to http://zero.webappsecurity.com/
// 2. Write a useful method which is named login under the
//    practicePage
//3. Call the login method from TestCase1 class.

public class ZeroBankLogin {
    WebDriver driver;

    //Create the Constructor(
    public ZeroBankLogin(WebDriver driver) {
        this.driver = driver;
        //initElements initializes the driver in page object model
        PageFactory.initElements(driver, this);
        //we use initElements to initialize the driver in the

    }
    @FindBy(xpath = "//button")
    public WebElement signButton;


    @FindBy(id = "user_login")
    public WebElement userLogin;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(name = "submit")
    public WebElement submitButton;

        public void zeroLogin(){

        signButton.click();

        userLogin.sendKeys(ConfigReader.getProperty("zeroUserName"));

        userPassword.sendKeys(ConfigReader.getProperty("zeroPassword"));
        submitButton.click();

    }
    public static void login(){
        System.out.println("Benim");

    }
}
