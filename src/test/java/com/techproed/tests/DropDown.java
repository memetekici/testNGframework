package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver driver;
    //Create a class name : DropDown
    //Go to https://the-internet.herokuapp.com/dropdown
    //1.Select and Print Option 1 using index
    //2.Select and Print Option 2 by value
    //3.Select and Print default value by visible text
    //4.Print all dropdown values
    //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void dropdownTest1(){
        WebElement dropdownElement1 = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement1);
        //1.Select and Print Option 1 using index
        options.selectByIndex(1);
        System.out.println(driver.findElement(By.id("dropdown")).getText());
    }
    //2.Select and Print Option 2 by value
    @Test(priority = 2)
    public void dropdownTest2(){
        WebElement dropdownElement2 = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement2);
        options.selectByValue("2");
        System.out.println(driver.findElement(By.id("dropdown")).getText());
    }
    //3.Select and Print default value by visible text
    //4.Print all dropdown values
    @Test(priority = 3)
    public void dropdownTest3(){
        WebElement dropdownElement3 = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement3);
        options.selectByVisibleText("Please select an option");
        String defaultvalue = driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        String options1 = driver.findElement(By.xpath("//option[@value='1']")).getText();
        String options2 = driver.findElement(By.xpath("//option[@value='2']")).getText();
        //System.out.println(defaultvalue);
        //System.out.println(options1);
        //System.out.println(options2);
        List<WebElement> optionsList = options.getOptions();
        for(WebElement w:optionsList){
            System.out.println(w.getText());
        }
    }
    @Test(priority = 4)
    public void dropdownElement4(){
        WebElement sizeOfDropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(sizeOfDropdown);
        List<WebElement> optionsList = options.getOptions();//Bütün optionsları bu şekilde alırız..
       /* if (optionsList.size() == 4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        */
        int actualSizeDropdown = options.getOptions().size();
        Assert.assertEquals(actualSizeDropdown,3,"EXPECTED İS NOT EQUAL TO ACTUAL");
        //eĞER TEST CASE FAİL İSE MESSAGE VEREBİLİRİZ YUKARDAKİ GİBİ..
    }
    @Test
    public void getFirstSelectedOptionsTest() throws InterruptedException {
        WebElement sizeOfDropdown = driver.findElement(By.id("dropdown"));
        Select options = new Select(sizeOfDropdown);
        Thread.sleep(3000);
        String firstSelectedOption = options.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);

    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
