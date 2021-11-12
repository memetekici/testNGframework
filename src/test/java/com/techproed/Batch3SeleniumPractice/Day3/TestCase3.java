package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase3 {
    //1. Go to http://zero.webappsecurity.com/
    // 2. Click Sign in button
    // 3. Enter login ( “username”)
    // 4. Enter wrong password (“password.”)
    // 5. Click Sign in button
    //6. Go to Account Activity page
    //7.Select Brokerage from account drop down menu
    //8.Verify in the account dropdown menu Brokerage is selected
    //9.Verify the drop down menu is following { Savings, Checking, Savings, Loan, Credit Card, Brokerage}
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test1(){
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();

        WebElement accountActivityPage = driver.findElement(By.xpath("//li[@id='account_activity_tab']"));
        accountActivityPage.click();

        WebElement accountButton = driver.findElement(By.id("aa_accountId"));
        Select options = new Select(accountButton);
        options.selectByVisibleText("Brokerage");

        Assert.assertTrue(options.getFirstSelectedOption().isDisplayed());
        System.out.println(options.getFirstSelectedOption().getText());

        List<String> expectedList = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");

        List<WebElement> webList = options.getOptions();
        List<String> actualList = new ArrayList<String>();

        for (WebElement list : webList){
            actualList.add(list.getText());
        }
        System.out.println("actual list = " + actualList);
    }
}

