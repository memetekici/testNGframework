package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Create a class:FileDownload
    //downloadTest()
    //In the downloadTest() method, do the following test:
    //Go to https://the-internet.herokuapp.com/download
    //Download FLOWER.JPG file
    //Then verify if the file downloaded successfully
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement flower = driver.findElement(By.xpath("(//a)[10]"));
        flower.click();

        //Then verify if the file downloaded successfully
        Thread.sleep(3000);

        //We can find the user folder user System.getProperty;
        String userFolder = System.getProperty("user.home");//Bize C:\\Users\\lenovo verir
        System.out.println(userFolder);
       // String pathOfTheFile = userFolder + "Downloads\\FLOWER.JPG";//Şuan dinamik oldu kodumuz
        String pathOfTheFile = "C:\\Users\\lenovo\\Downloads\\FLOWER.JPG";
        boolean isExist = Files.exists(Paths.get(pathOfTheFile));
        Assert.assertTrue(isExist);
    }
}
