package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1 extends TestBase {
    //Go to http://zero.webappsecurity.com/
    // 2. Click Sign in button
    // 3. Enter login ( “username”)
    // 4. Enter wrong password (“password”)
    // 5. Click Sign in button
    //6. Go to Pay Bills page
    //7. Click Purchase Foreign Currency
    //8. Select Eurozone from currency drop dawn menu
    //9. Verify the Euro zone is selected
    //10. Verify the List Options is following
    // {Select One, Australia (dollar), Canada (dollar),Switzerland (franc),China (yuan),
    // Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),
    // Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}
    @Test
    public void testCase(){
        driver.get("http://zero.webappsecurity.com/");
        // 2. Click Sign in button
        WebElement signInButton = driver.findElement(By.xpath("//button"));
        signInButton.click();
        // 3. Enter login ( “username”)
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'user_login']"));
        loginButton.sendKeys("username");
        // 4. Enter wrong password (“password”)
        WebElement passwordButton = driver.findElement(By.xpath("//input[@id = 'user_password']"));
        passwordButton.sendKeys("password");
        // 5. Click Sign in button
        WebElement signInButton2 = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton2.click();
        //6. Go to Pay Bills page

        WebElement payBillsButton = driver.findElement(By.xpath("//li[@id='pay_bills_tab']"));
        payBillsButton.click();
        //7. Click Purchase Foreign Currency
        WebElement foreignButton = driver.findElement(By.xpath("//a[@href ='#ui-tabs-3']"));
        foreignButton.click();
        //8. Select Eurozone from currency drop dawn menu
        WebElement currencyButton = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currencyButton);
        select.selectByIndex(6);

        //9. Verify the Euro zone is selected
        String selectedOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        Assert.assertEquals(selectedOption,expectedOption);

        //10. Verify the List Options is following
        // {Select One, Australia (dollar), Canada (dollar),Switzerland (franc),China (yuan),
        // Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),
        // Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}
        List<String> expectedListOptions = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                 "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                 "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        List<WebElement> listOptions = select.getOptions();

        List<String > actualListOptions = new ArrayList<>();
        for (WebElement element : listOptions) {
            actualListOptions.add(element.getText());
        }
        Assert.assertEquals(actualListOptions,expectedListOptions);


    }
}
