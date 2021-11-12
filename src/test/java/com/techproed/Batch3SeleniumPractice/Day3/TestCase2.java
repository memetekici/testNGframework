package com.techproed.Batch3SeleniumPractice.Day3;

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

public class TestCase2 {
    //Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
    // 2. Click CLICK ME of JavaScript Alert
    // 3. Get the pop up text
    // 4. Verify the Message is “I am an alert box!“
    // 5. Accept the pop up

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

    }

    @Test
    public void alert1(){
        // 2. Click CLICK ME of JavaScript Alert
        WebElement javaScriptSelect = driver.findElement(By.xpath("//span[@id='button1']"));
        javaScriptSelect.click();

        // 3. Get the pop up text
        String javaScript = driver.switchTo().alert().getText();
        System.out.println(javaScript);

        // 4. Verify the Message is “I am an alert box!“
        Assert.assertEquals(javaScript,"I am an alert box!");

        // 5. Accept the pop up
        driver.switchTo().alert().accept();
    }

    @Test(dependsOnMethods = "alert1")
    //Write these code in test case 2 class
    //1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
    // 2. Click CLICK ME of JavaScript Confirm Box
    //3. Get the pop up text
    // 4. Verify the Message is “Press a button“ (the message is worng but I
    //     want to complete my test case)
    // 5. Dismiss the pop up
    //6. Verify the “You pressed Cancel!” is displayed
    //7. Use the dependsOnMethods accorting to alert1
    public  void alert2() throws InterruptedException {
        WebElement comfirmBoxButton = driver.findElement(By.xpath("//span[@id='button4']"));
        comfirmBoxButton.click();
        String text = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        System.out.println(text);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text, "Press a button");
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        WebElement text2 = driver.findElement(By.xpath("//p[@id ='confirm-alert-text']"));
        softAssert.assertTrue(text2.isDisplayed());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
