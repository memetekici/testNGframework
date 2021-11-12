package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {
    //1.Go to ” https://demoqa.com/dynamic-properties”
    //2.Verify the Visible After 5 Seconds button is displayed
    @Test
    public void test() throws InterruptedException {
        driver = Driver.getDriver();

        driver.get("https://demoqa.com/dynamic-properties");
       // Thread.sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver,20);
       WebElement visibleAfter5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button)[4]")));

        //WebElement visibleAfter5 = driver.findElement(By.xpath("(//button)[4]"));
        String visibleAfter5Text = visibleAfter5.getText();
        //Assert.assertEquals(visibleAfter5Text,"Visible After 5 Seconds");
        Assert.assertTrue(visibleAfter5.isDisplayed());
    }

}
