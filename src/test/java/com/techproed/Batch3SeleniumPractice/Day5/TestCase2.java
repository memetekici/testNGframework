package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase2 extends TestBase {
    //1.Go to ”https://www.mediawiki.org/wiki/Download”
    //2.Click Download MediaWiki 1.34.2
    //3.Verify the file is downloaded
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.mediawiki.org/wiki/Download");

        //2.Click Download MediaWiki 1.34.2
        WebElement download = driver.findElement(By.xpath("(//a[@class ='extiw'])[1]"));
        download.click();
        Thread.sleep(10000);

        String pathOfTheFile = "C:\\Users\\lenovo\\Downloads\\mediawiki-1.35.0.tar.gz";
        boolean isExist = Files.exists(Paths.get(pathOfTheFile));
        Assert.assertTrue(isExist);
    }
}
