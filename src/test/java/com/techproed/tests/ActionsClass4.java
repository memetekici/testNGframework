package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass4 extends TestBase {
    //Create a class: ActionClass4
    //Create test method : scrollUpDown()
    //Go to amazon
    //Scroll the page down
    //Scroll the page up
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();//Arrow_down moved the page down,but ıt moves less than page_down
        //Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.ARROW_UP);
    }
}
