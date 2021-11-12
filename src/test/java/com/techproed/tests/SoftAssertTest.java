package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void hardAssertTest(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        //Assert if the gmail link text  equals "gmail"
        String expectedGmailText = "Gmail";
        String actualGmailLink = gmailLink.getText();
        Assert.assertEquals(actualGmailLink,expectedGmailText);//Pass

        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        //If the images link text is equal to "Images"
        String expectetImageText = "Images";
        String actualImageText = imagesLink.getText();
        Assert.assertEquals(expectetImageText,actualImageText);//Pass


        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        //Assert if the sign in link text "sign in"
        String expectedSignInText = "Sign in";
        String actualSignİnText = signInLink.getText();
        Assert.assertEquals(actualSignİnText,expectedSignInText);//Fail

    }
    @Test
    public void softAssertTest(){
        //Assert if the gmail link text  equals "gmail"
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        String expectedGmailText = "gmail";
        String actualGmailText = gmailLink.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualGmailText,expectedGmailText);//Faill


        //If the images link text is equal to "Images"
        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        String expectedImagelinkTest = "Images";
        String actualImageLinkTest = imagesLink.getText();
        softAssert.assertEquals(actualImageLinkTest,expectedImagelinkTest);//pass


        //Assert if the sign in link text "sign in"
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        String actualSignInLinkTest = "sign in";
        String expectedSignInLinkTest = signInLink.getText();
        softAssert.assertEquals(actualSignInLinkTest,expectedSignInLinkTest);

        //When we use soft assert,we have to use AssertAll() to get the actual reports.
        //Without assertAll, this is not correct test case.
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(){

    }
}
