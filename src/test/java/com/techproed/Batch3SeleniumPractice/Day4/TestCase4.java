package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase {
    //1.Go to http://webdriveruniversity.com/Actions
    //2.Hover over the Me First
    //3.Click Link 1
    //4.Print the popup message
    //5.Accept the popup
    //6.Click and hold
    //7.Get the text click and hold
    //Double click to the double click me
    @Test
    public void testCase4(){
        driver.get("http://webdriveruniversity.com/Actions");
        WebElement hoverOverElement = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverElement).perform();

        WebElement linkButton = driver.findElement(By.xpath("//a[@href ='#']"));
        linkButton.click();
        String popupMessage = driver.switchTo().alert().getText();
        System.out.println(popupMessage);
        driver.switchTo().alert().accept();

        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        System.out.println(clickAndHold.getText());

        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

    }
}
