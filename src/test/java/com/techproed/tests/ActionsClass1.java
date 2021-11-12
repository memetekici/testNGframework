package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass1 extends TestBase {
    //Create a class: ActionsClass1
    //Create a test method : contextClickMethod() and test the following scenario:
    //Given user is on the https://the-internet.herokuapp.com/context_menu
    //When use Right clicks on the box
    //Then verify the alert message is “You selected a context menu”
    //Then accept the alert
    @Test
    public  void contextClickMethod() throws InterruptedException {
        //contextClick = right click
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //When use Right clicks on the box
        //Creating actions object so actions control the driver and do mouse actions
        Actions actions = new Actions(driver);
        // Locate the box
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();//Mause sağ tıkladık.
        Thread.sleep(3000);

        //Then verify the alert message is “You selected a context menu”
        String actualAlertMessage = driver.switchTo().alert().getText();
        String expectedAlertMessage = "You selected a context menu";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);

        //Then accept the alert
        driver.switchTo().alert().accept();


    }
}
