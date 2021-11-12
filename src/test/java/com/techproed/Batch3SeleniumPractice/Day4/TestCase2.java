package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {
    //1.Go to http://webdriveruniversity.com/File-Upload/
    //2.Click the Choose file button
    //3.Create a text document in your desktop
    //4.Upload this document from your desktop
    //5.Click the Submit button
    //6.Verify the “Your file has now been uploaded!” is displayed
    //7.Accept the popup.
    @Test
    public void testCase2() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/File-Upload/");
        WebElement chooseButton = driver.findElement(By.id("myFile"));
        String pathTheFile = "C:\\Users\\lenovo\\Desktop\\FLOWER. IMG.jpg";
        Thread.sleep(3000);
        chooseButton.sendKeys(pathTheFile);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        submitButton.click();

        String actualText = driver.switchTo().alert().getText();
        System.out.println(actualText);
        String expectedText = "Your file has now been uploaded!";
        Assert.assertEquals(actualText,expectedText);
        driver.switchTo().alert().accept();

    }
}
