package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class ActionsClass3 extends TestBase {
    //Create a class: ActionClass3
    //Create test method : keysUpDown()
    //Go to amazon
    //Send iPhone X prices => convert small letter capital vice versa.
    //Highlight the search box by double clicking

    @Test
    public void keysUpDown1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions
                .keyDown(searchBox, Keys.SHIFT)//Pressing shift on the search box element
                .sendKeys("iPhone X prices")//Typing in box
                .keyUp(searchBox,Keys.SHIFT)//We have to un press fromm the shift button
                .sendKeys("in germany" + Keys.ENTER)//Kendim denedim
                .perform();//performing the actions
        Thread.sleep(3000);
    }
}
