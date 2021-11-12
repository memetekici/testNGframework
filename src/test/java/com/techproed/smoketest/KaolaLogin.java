package com.techproed.smoketest;

import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KaolaLogin extends TestBase {
    //Inside the smoke test, create a new class: KaolaLogin
    //And verify the user is able to log in using the correct credentials.
    //Note: use page object model
    @Test
    public void kaolaLogin() throws InterruptedException {
       // driver.get("http://www.kaolapalace-qa-environment2.com/");
        driver.get(ConfigReader.getProperty("url"));
        KaolaMainPage kaolaMainPage = new KaolaMainPage(driver);
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage = new KaolaLoginPage(driver);
      //  kaolaLoginPage.kaolaUsername.sendKeys("manager2");
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
        Thread.sleep(10000);

    }
}
