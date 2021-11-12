package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {
    //1.Go to http://webdriveruniversity.com/IFrame
    //2.Click the Our Products button
    //3.Click Cameras product
    //4.Print the message from popup
    //5.Click the close button
    @Test(groups = "smk")
    public  void testCase3() throws InterruptedException {
        driver = Driver.getDriver();//Bunu rungroup.xml için yazdık


        driver.get("http://webdriveruniversity.com/IFrame");

        driver.switchTo().frame("frame");
        WebElement ourProductButton = driver.findElement(By.xpath("//a[@href='products.html']"));
        ourProductButton.click();

        WebElement camerasButton = driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]"));
        camerasButton.click();

        Thread.sleep(3000);
        WebElement text = driver.findElement(By.className("modal-title"));
        System.out.println(text.getText());

        WebElement close = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        close.click();

    }
}
