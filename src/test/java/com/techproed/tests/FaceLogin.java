package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public void logInTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        //create FaceLoginPage object
        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);
        //send username
        faceLoginPage.username.sendKeys("lkjlskjlkj");
        faceLoginPage.password.sendKeys("98798asasas");
        faceLoginPage.login.click();

        Thread.sleep(5000);
        String actualErrorMessage = faceLoginPage.errorMessage.getText();
        String expectedErrorMessage = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


    }
}
