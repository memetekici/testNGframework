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

import java.util.concurrent.TimeUnit;

public class AllertTest {
    //Go to https://the-internet.herokuapp.com/javascript_alerts
    //Create setUp method
    //Create 3 test methods:
    //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
    //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAllert() throws InterruptedException {
        //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert"
        WebElement firstButton = driver.findElement(By.xpath("(//button)[1]"));
        //click on the first alert,
        firstButton.click();
        //Getting the text on the alert
        String firstAlertText = driver.switchTo().alert().getText();
        //verify the text “I am a JS Alert”
        Assert.assertEquals(firstAlertText,"I am a JS Alert");
        Thread.sleep(3000);
        //clicking Ok by using alert accept() method
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
        //Getting the text of element
        String resultText =resultElement.getText();
        //Asserting if the result text is a expected
        Assert.assertEquals(resultText,"You successfuly clicked an alert");
    }
    @Test
    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
    public  void dismissAlert(){
        WebElement secondButton = driver.findElement(By.xpath("(//button)[2]"));
        secondButton.click();
        String secondAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(secondAlertText,"I am a JS Confirm");
        //Clicking on Cancel button on the alert
        driver.switchTo().alert().dismiss();
        WebElement resultElement = driver.findElement(By.xpath("//p[@style='color:green']"));
        String resultText = resultElement.getText();
        Assert.assertEquals(resultText,"You clicked: Cancel");
    }
    @Test
    public void sendKeysAlert(){
        //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
        WebElement thirdButton = driver.findElement(By.xpath("(//button)[3]"));
        thirdButton.click();
        //Switching the third alert
        String thirdAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(thirdAlertText,"I am a JS prompt");
        driver.switchTo().alert().sendKeys("Hello Word");
        //Clicking Ok button
        driver.switchTo().alert().accept();
        //Asserting the actual result and expected result
        WebElement resultElement = driver.findElement(By.xpath("//p[@style='color:green']"));
        String resultText = resultElement.getText();
        Assert.assertEquals(resultText,"You entered: Hello Word");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
