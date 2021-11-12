package com.techproed.tests;

import com.techproed.smoketest.PositiveTest;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTest extends TestBase {
    //Create a clickLogin method
    //PositiveTest pt = new PositiveTest();Bu şekilde positive Test sınıfında object oluşturup
                                          // bu object üzerinden clickOnLogin() metodunu çağırdık.
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.xpath("(//a[@class = 'nav-link'])[7]"));
        mainPageLoginButton.click();
    }


    @Test
    public void createHotelRoom() throws InterruptedException {
        //pt.clickOnLogin();==> metodu çağırdık
        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(10000);
        //Click on Hotel Management
        WebElement hotelManagement=driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        //Click on Hotel Rooms
        WebElement hotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
        //Click on Add Hotel Room
        WebElement addHotelRoomButton=driver.findElement(By.partialLinkText("ADD HOTELROOM"));
        addHotelRoomButton.click();
        Thread.sleep(10000);
        //Enter All required fields
        WebElement idHotelDropdown = driver.findElement(By.xpath("(//select)[1]"));
        Select select = new Select(idHotelDropdown);
        select.selectByIndex(1);

        WebElement code = driver.findElement(By.xpath("(//input)[1]"));
        code.sendKeys("12345");

        WebElement name = driver.findElement(By.id("Name"));
        name.sendKeys("Best Hotel");

        WebElement location = driver.findElement(By.id("Location"));
        location.sendKeys("Houston");

        WebElement description = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        description.sendKeys("This is Royal Class Hotel");
        //To enter a price,we can send keys;or we can use action class
        WebElement source = driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement target = driver.findElement(By.id("Price"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

        WebElement roomTypeDropdown = driver.findElement(By.xpath("(//select)[2]"));
        Select select1 = new Select(roomTypeDropdown);
        select1.selectByVisibleText("Studio");

        WebElement maxAdultCount = driver.findElement(By.id("MaxAdultCount"));
        maxAdultCount.sendKeys("5");

        WebElement maxChildrenCount = driver.findElement(By.id("MaxChildCount"));
        maxChildrenCount.sendKeys("6");

        WebElement approvedCheckbox = driver.findElement(By.id("IsAvailable"));
        approvedCheckbox.click();

        //Click Save
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();
        Thread.sleep(3000);

        //Verify the message: HotelRoom was inserted successfully
        WebElement text = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        String textText = text.getText();
        System.out.println(textText);
        Assert.assertEquals(textText,"HotelRoom was inserted successfully");

        //Click OK
        WebElement clickButton = driver.findElement(By.xpath("(//button[@type ='button'])[6]"));
        clickButton.click();

    }

}
