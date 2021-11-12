package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    ///*
    //1. Go to "https://facebook.com"
    //2. Click create new account button
    //3. Enter a name firstName input box
    //4. Enter a surname surName input box
    //5. Enter an email into email input box
    //6. Re-enter the same email into email input box
    //7. Enter a new password
    //8. Select a day
    //9. Select a moth
    //10. Select a year
    //11. Select a gender
    //12. Verify the gender is selected and verify the other gender is not selected.
    // */
     WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://facebook.com");
    }
    @Test
    public void test1(){
        WebElement newAccountButton = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
        newAccountButton.click();

        WebElement firsNameButton = driver.findElement(By.xpath("(//input[@type ='text'])[2]"));
        firsNameButton.sendKeys("Memet");
        WebElement surnameButton = driver.findElement(By.xpath("(//input[@type ='text'])[3]"));
        surnameButton.sendKeys("Ekici");
        WebElement emailButton = driver.findElement(By.xpath("(//input[@type ='text'])[4]"));
        emailButton.sendKeys("meeee@gmail.com");
        WebElement reEnterEmailButton = driver.findElement(By.xpath("(//input[@type ='text'])[5]"));
        reEnterEmailButton.sendKeys("meeee@gmail.com");
        WebElement passwordButton = driver.findElement(By.xpath("(//input[@type ='password'])[2]"));
        passwordButton.sendKeys("2302");

        WebElement dropdownElement1 = driver.findElement(By.xpath("//select [@id ='day']"));
        Select options = new Select(dropdownElement1);
        options.selectByValue("17");

        WebElement dropdownElement2 = driver.findElement(By.xpath("//select[@id = 'month']"));
        Select options2 = new Select(dropdownElement2);
        options2.selectByIndex(6);

        WebElement dropdownElement3 = driver.findElement(By.xpath("//select[@id = 'year']"));
        Select options3 = new Select(dropdownElement3);
        options3.selectByValue("1990");

        WebElement genderButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        genderButton.click();

        WebElement female = driver.findElement(By.xpath("//input[@value ='1']"));
        Assert.assertTrue(genderButton.isSelected());
        Assert.assertFalse(female.isSelected());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
