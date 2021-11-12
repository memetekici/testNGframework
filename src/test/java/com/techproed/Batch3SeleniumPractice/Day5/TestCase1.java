package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCase1 extends TestBase {
    //1.Go to http://webdriveruniversity.com/
    //2.Go down to Login Portal
    //3.Click the Login Portal
    //4.Go to second windows
    //5.Fill the username and password
    //6.Click the login button
    //7.Print the popup text
    //8.Accept the popup

    @Test(groups = "smk")
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");

        //2.Go down to Login Portal
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        //3.Click the Login Portal
        WebElement loginPortal = driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        loginPortal.click();

        //4.Go to second windows
        String windowFirst = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for(String w : allWindow){
            if(!w.equals(windowFirst)){
                driver.switchTo().window(w);
            }
        }
        //5.Fill the username and password
        WebElement username = driver.findElement(By.xpath("(//input)[1]"));
        username.click();
        username.sendKeys("Memet");

        WebElement password = driver.findElement(By.xpath("(//input)[2]"));
        password.click();
        password.sendKeys("2222");

        //6.Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();

        //7.Print the popup text
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        //8.Accept the popup
        driver.switchTo().alert().accept();

    }


}
