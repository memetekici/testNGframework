package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadFileTest extends TestBase {
    @Test
    public void UploadFileMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //Locate the elementh of choosefile
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //We need to send the path of the image
        //Each of your path will be different
        String pathPfTheFile = "C:\\Users\\lenovo\\Desktop\\20180629_164227.jpg";
        //We will this pathOfTheFile to the chooseFile button
        chooseFile.sendKeys(pathPfTheFile);
        Thread.sleep(3000);

        //Click on upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(3000);

        //Verify "File Uploaded!" message
        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        String actualText = fileUploadedText.getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText,expectedText);
    }
}
