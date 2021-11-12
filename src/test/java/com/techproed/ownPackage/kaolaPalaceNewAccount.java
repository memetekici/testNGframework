package com.techproed.ownPackage;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class kaolaPalaceNewAccount extends TestBase {
    //A new account should be created by entering the required and valid information.
    //uUserName = manager2
    //uPassword = Man1ager2!
    @Test
    //1_ go to https://www.kaolapalace.com/
    //2_click on Create a new account textbox
    //3_click on username textbox
    //4_Type a user name with at least 4 characters
    //5_click on password textbox
    //6_TYpe a password with at least 5 characters
    //7_click on email textbox
    //8_Type a valid email address
    //9_click on full name textbox
    //10_Type a valid name
    //11_click on the phone textbox
    //12_Type a phone number
    //13_click SSN textbox
    //14_type SSN number
    //15_click driving license textbox
    //16_type yes or no
    //17_click country textbox
    //18_select country
    //19_click addree textbox
    //20_type address
    //21_click on working textbox
    //22_type job
    //23_click on birth day textbox
    //24_type birth day
    //25_click on save button
    public void positivTest() throws InterruptedException {
        driver.get("https://www.kaolapalace.com/");
        driver.findElement(By.xpath("//li[@id='navLogon']")).click();
        driver.findElement(By.xpath("//a[@class='btn-custom']")).click();

        Faker faker = new Faker();


        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(faker.name().firstName() +"eee");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(faker.internet().password() + "23/*Dy");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@id='NameSurname']")).sendKeys("Aişe Çelik");
        driver.findElement(By.xpath("//input[@id='PhoneNo']")).sendKeys("0777543215");
        driver.findElement(By.xpath("//input[@id='SSN']")).sendKeys("111222333");
        driver.findElement(By.xpath("//input[@id='DrivingLicense']")).sendKeys("Yes");

        WebElement country = driver.findElement(By.xpath("//select[@id='IDCountry']"));
        Select select = new Select(country);
        select.selectByVisibleText("Turkey");

        driver.findElement(By.xpath("//input[@id='Address']")).sendKeys("Deutschland Berlin");
        driver.findElement(By.xpath("//input[@id='WorkingSector']")).sendKeys("IT");
        driver.findElement(By.xpath("//input[@id='BirthDate']")).sendKeys("6/17/2010");
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();


        Thread.sleep(3000);

        String textText = driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
        Assert.assertTrue(textText.contains("User Data was inserted successfully"));


    }
}
