package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReusableMethodsDemo {

    @Test
    public void test1(){
        Driver.getDriver().get(ConfigReader.getProperty("url2"));
        Driver.getDriver().findElement(By.xpath("//button")).click();
        WebElement helloWorld = Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals(helloWorld.getText(),"Hello World!");
        //We dont need to use explicit wait
        //Implicit wait solved the issues
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        Driver.getDriver().findElement(By.xpath("//button")).click();
        //Hard Wait work but ıts not a good idea
        //ReusableMethods.waitFor(6);

        //We can wait for that element to be visible on the page.
        //We have that method int reusablemethods class
        ReusableMethods.waitForVisibility(Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']")),6);
        WebElement helloWorld = Driver.getDriver().findElement(By.xpath("//h4[.='Hello World!']"));
        Assert.assertEquals(helloWorld.getText(),"Hello World!");

    }
}
