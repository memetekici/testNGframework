package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelReservationTest extends TestBase {
     @Test
    public void reservationTest() throws InterruptedException {
         driver.get("http://www.kaolapalace-qa-environment2.com/");
         WebElement loginButton = driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));
         loginButton.click();

         WebElement userName = driver.findElement(By.xpath("(//input)[1]"));
         userName.sendKeys("manager2");
         WebElement password = driver.findElement(By.xpath("(//input)[3]"));
         password.sendKeys("Man1ager2!");
         WebElement clickOnLogin = driver.findElement(By.xpath("(//input)[4]"));
         clickOnLogin.click();

         WebElement hotelManagement = driver.findElement(By.xpath("(//span[@class='title'])[3]"));
         hotelManagement.click();

         WebElement roomReservation = driver.findElement(By.xpath("//a[@href='/admin/RoomReservationAdmin']"));
         roomReservation.click();

         WebElement addRoomReservation = driver.findElement(By.xpath("//span[@class ='hidden-480']"));
         addRoomReservation.click();

         WebElement selectUser = driver.findElement(By.xpath("(//select)[1]"));
         Select selectSelectUser = new Select(selectUser);
         selectSelectUser.selectByIndex(1);

         WebElement selectRoom = driver.findElement(By.xpath("(//select)[2]"));
         Select selectSelectRoom = new Select(selectRoom);
         selectSelectRoom.selectByVisibleText("King Room");

         WebElement price = driver.findElement(By.xpath("(//input)[1]"));
         price.sendKeys("600");

         driver.findElement(By.xpath("//input[@name='DateStart']")).sendKeys("10/26/2020");
         driver.findElement(By.xpath("//input[@id = 'DateEnd']")).sendKeys("10/30/2020");
         driver.findElement(By.xpath("//input[@id = 'AdultAmount']")).sendKeys("2");
         driver.findElement(By.xpath("//input[@id = 'ChildrenAmount']")).sendKeys("2");
         driver.findElement(By.xpath("//input[@id = 'ContactPhone']")).sendKeys("0491255544");
         driver.findElement(By.xpath("//input[@id='ContactNameSurname']")).sendKeys("Memet ekici");
         driver.findElement(By.xpath("//input[@id='ContactEmail']")).sendKeys("ggg@gmail.com");
         driver.findElement(By.xpath("//input[@id='Notes']")).sendKeys("Herşey ok");
         driver.findElement(By.xpath("//input[@id='IsPaid']")).click();

         driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();

          WebDriverWait wait = new WebDriverWait(driver, 10);
          WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
         Thread.sleep(3000);
         String message = driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
         System.out.println(message);
         Assert.assertEquals(message,"RoomReservation was inserted successfully");


          driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();



     }
}
