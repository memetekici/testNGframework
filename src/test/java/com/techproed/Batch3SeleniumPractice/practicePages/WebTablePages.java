package com.techproed.Batch3SeleniumPractice.practicePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePages {
    WebDriver driver;

    public WebTablePages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='rt-thead -header']//div[6]")
    public WebElement departmentHeader;

    @FindBy(xpath = "//div[@class='rt-tbody']/div[2]//div[6]")
    public WebElement depertmanName;

    public  String DepName(String name){
        WebElement depName1 = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='" + name + "']/../div[6]"));
        return depName1.getText();
    }

}
