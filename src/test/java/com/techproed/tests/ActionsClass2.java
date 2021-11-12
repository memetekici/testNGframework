package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass2  {
    //Create a class: ActionClass2
    //Create test method : hoverOver() and test the following scenario:
    //Given user is on the https://www.amazon.com/
    //When use click on “Your Account” link
    //Then verify the page title contains “Your Account”
    //HOMEWORK
    //Create another method: imageTest()
    //Hover over the Try Prime
    //And Verify the image displays.


//Create ReusableMethod object to access its methods
    ReusableMethods rm = new ReusableMethods();
    @Test
    public  void hoverOver() throws InterruptedException {
        Driver.getDriver().get("https://www.amazon.com/");

        //When use click on “Your Account” link
        //We have to hover over to see Your account
        WebElement hoverOverElement = Driver.getDriver().findElement(By.id("nav-link-accountList"));
 //       Actions actions = new Actions(driver);
        //We use moveToElement to hover over on an element
 //       actions.moveToElement(hoverOverElement).perform();

        rm.hover(hoverOverElement);//1. yol
        //ReusableMethods.hover(hoverOverElement);2.yol

        Thread.sleep(3000);

        //Then verify the page title contains “Your Account”
        WebElement account= Driver.getDriver().findElement(By.linkText("Your Account"));
        account.click();
        String actualPageTitle = Driver.getDriver().getTitle();
        String expectedPAgeTitle = "Your Account";
        Assert.assertTrue(actualPageTitle.contains(expectedPAgeTitle));

    }
}
