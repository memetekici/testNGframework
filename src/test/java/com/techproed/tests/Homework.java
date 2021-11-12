package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework {
    //Use Different Test Method for each Test Case
    //• Go to https://www.amazon.com/
    //• Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    //• Print the first selected option and assert if it equals “All Departments”
    //• Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method)
    //• Print all of the dropdown options
    //• Print the the total number of options in the dropdown
    //• Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
    //• BONUS: Check if the dropdown is in Alphabetical Order
    WebDriver driver;
    @BeforeMethod
    public void test(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

    }
    @Test
    public void test1(){
        //• Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        //• Print the first selected option and assert if it equals “All Departments”
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox']"));
        Select options = new Select(dropdownElement);
        String actualFirstOption = options.getFirstSelectedOption().getText();
        System.out.println(actualFirstOption);
        Assert.assertEquals(actualFirstOption, "All Departments");
    }

    @Test
    public void test2(){
        //• Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        // (after you select you need to use get first selected option method)
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox']"));
        Select options = new Select(dropdownElement);
        options.selectByIndex(3);
        String optionIndex3Text = options.getFirstSelectedOption().getText();
        System.out.println(optionIndex3Text);
        Assert.assertEquals(optionIndex3Text,"Amazon Devices");//Expected :Amazon Devices
                                                                       //Actual   :Baby
    }

    @Test
    public  void test3(){
        //• Print all of the dropdown options
        //• Print the the total number of options in the dropdown
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox']"));
        Select options = new Select(dropdownElement);

        List<WebElement> allDropdownOptionsList = new ArrayList<WebElement>();
        for (WebElement w : options.getOptions()){
            System.out.println(w.getText());
        }
        System.out.println("Total number = " + options.getOptions().size());
    }

    @Test
    public void test4(){
        //• Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox']"));
        Select options = new Select(dropdownElement);
        List<WebElement> allDropdownList = options.getOptions();
        List<String> list = new ArrayList<>();
        for (WebElement w : options.getOptions()) {
            list.add(w.getText());
        }
        System.out.println(list);
        if (list.contains("Appliances")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
