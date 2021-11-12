package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowHandleExample extends TestBase {
    //Create a new Class Tests package: WindowHandleExample
    //Given user is on the https://the-internet.herokuapp.com/windows
    //Then user verifies the text : “Opening a new window”
    //Then user verifies the title of the page is “The Internet”
    //When user clicks on the “Click Here” button
    //Then user verifies the new window title is “New Window”
    //Then user verifies the text:  “New Window”
    //When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public  void newWindowTest() {
        //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        String newWindowtext = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(newWindowtext, "Opening a new window");

        //Then user verifies the title of the page is “The Internet”
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        //Check if the expectedTitle equal Title.If they are not equal print that message
        Assert.assertEquals(actualTitle, expectedTitle, "Titles is incorrect");

        //When user clicks on the “Click Here” button
        String defaultWindow = driver.getWindowHandle();//İlk açılan window
        System.out.println(defaultWindow);//İLk açılan window
        WebElement click = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        click.click();

        //Then user verifies the new window title is “New Window”
        //We will get all open windows handles an put them in a set
        Set<String> allWindows = driver.getWindowHandles();
        //Using for each loop; we can switch to the new window
        System.out.println(allWindows);
        for (String eachHandle : allWindows) {
            if (!eachHandle.equals(defaultWindow)) {
                driver.switchTo().window(eachHandle);
            }
        }
        String actualNewPageTitle = driver.getTitle();
        String expectedNewPageTitle = "New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New page title is not equal");

        //Then user verifies the text:  “New Window”
        String actualNewWindowText = driver.findElement(By.xpath("//h3")).getText();
        String expectedNewWindowText = "New Window";
        Assert.assertEquals(actualNewWindowText,expectedNewWindowText,"New window text is not");

        //When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(defaultWindow);//İlk sayfayı tekrar handle ettik.
        String actualSecondTitle = driver.getTitle();
        String expectedSecondTitle ="The Internet";
        Assert.assertEquals(actualSecondTitle,expectedSecondTitle,"Title is not assert");



    }
}
