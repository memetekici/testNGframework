package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {
    @Test
    public  void iframeTest(){
        //Go to https://the-internet.herokuapp.com/iframe
        //Verify the Bolded text contains “Editor”
        //Note that this Bolded text is Not inside the İframe,so we Don't switch to iframe
        //Locate the text box
        //Delete the text in the text box
        //Type “This text box is inside the iframe”
        //Verify the text Elemental Selenium text is displayed on the page
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement boldedText = driver.findElement(By.xpath("//h3"));
        String boldedTextText = boldedText.getText();
        Assert.assertTrue(boldedTextText.contains("Editor"));

        //Locate the text box
        //WE HAVE TO SWİTCH TO OFRAME FİRST BECAUSE THE TEXTBOX İS İN THE IFRAME
        //Method1
       // driver.switchTo().frame(0);//It s the first İframe = indexof(0)
        //Method2
        //WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframeElement);
        //Method3
        driver.switchTo().frame("mce_0_ifr");//iframe in id sin, yazdık sadece

        WebElement textBoxElement = driver.findElement(By.xpath("//p"));
        //Delete the text in the text box
        textBoxElement.clear();
        //Type “This text box is inside the iframe”
        textBoxElement.sendKeys("This text box is inside the iframe");

        //Verify the text Elemental Selenium text is displayed on the page

        //Elemental Selenium is outside of the iframe.But currently our driver is inside the iframe
        //So we need to get out of the iframe:driver.switchTo().parentFrame();
        //                                    driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
        String elementText = driver.findElement(By.xpath("//a[@target='_blank']")).getText();
        Assert.assertTrue(elementText.equals("Elemental Selenium"));

    }
}
