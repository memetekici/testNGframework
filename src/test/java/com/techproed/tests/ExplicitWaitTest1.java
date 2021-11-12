package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {

    @Test
    public void isEnable(){
        //Create a class:ExplicitWaitTest1. Create a method: isEnabled
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        //Click enable Button
        //And verify the message is equal to “It's enabled!”
        //And verify the textbox is enabled (I can type in the box)
        //And click on Disable button
        //And verify the message is equal to “It's disabled!”
        //And verify the textbox is disabled (I cannot type in the box)
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        WebElement enableButton = driver.findElement(By.xpath("(//button)[2]"));
        enableButton.click();

        //And verify the message is equal to “It's enabled!”
        //WebElement message = driver.findElement(By.xpath("(//p)[2]"));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p)[2]")));
        String messageText = message.getText();
        Assert.assertEquals(messageText,"It's enabled!");

        //And verify the textbox is enabled (I can type in the box)
        WebElement textBoxEnable = driver.findElement(By.xpath("(//input)[2]"));
        Assert.assertTrue(textBoxEnable.isEnabled());

        //And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("(//button)[2]"));
        disableButton.click();

        //And verify the message is equal to “It's disabled!”
        WebElement messageText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p)[2]")));
        String disableButtonText = messageText2.getText();
        Assert.assertEquals(disableButtonText,"It's disabled!");

        //And verify the textbox is disabled (I cannot type in the box)
        WebElement disableText = driver.findElement(By.xpath("(//input)[2]"));
        Assert.assertTrue(!disableText.isEnabled());
    }
}
