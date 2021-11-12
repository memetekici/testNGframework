package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {
    //Create a class: WebTables
    //Create a method: login()
    //Log in  http://www.kaolapalace-qa-environment2.com/
    //Click on Hotel Management
    //Click on Hotel Rooms

    //Pre condition.This is not a test case.So we didn't use @Test
    public void login() {
        //Log in  http://www.kaolapalace-qa-environment2.com/
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.xpath("(//a[@class = 'nav-link'])[7]"));
        mainPageLoginButton.click();

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();

        //Click on Hotel Management
        WebElement hotelManagement = driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();

        //Click on Hotel Rooms
        WebElement hotelRooms = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
    }

    //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
    //Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
    //Create a test method: printCells() and Find the total number of cells in the table body and print all of the cells
    //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
    //Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column

    @Test
    public void entireTable() throws InterruptedException {
        login();
        //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
        //Print Entire table body
        Thread.sleep(5000);
        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());//Bİze Bodynin tableini verdi.
                                            //Bunun için //tbody i kullandık

        //Find the size of the entire table body
        List<WebElement> tableData = driver.findElements(By.xpath("//td"));
        System.out.println("There are " + tableData.size() + " data.");

       //Another way to print
       // for (WebElement w : tableData){//2.yol print etmek için
       //     System.out.println(w.getText());
        //}

        //and Print all of the headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//th"));
        for (WebElement w : allHeaders){
            System.out.print(w.getText() + ",");
        }
        System.out.println();
    }
    //Create a test method: printRows() and Print all of the rows in the table body and print the element s on the 4th row
    @Test
    public void printRows(){
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement w : allRows){
            System.out.println(w.getText());
        }
        //and print the element s on the 4th row
        WebElement forthRow = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forthRow.getText());

    }

    //Create a test method: printCells() and Find the total number of cells in the table body and print all of the cells
    @Test
    public void printCells(){
        login();
        //and Find the total number of cells in the table body(Her küçük kutu cell)

        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());
        for (WebElement w : allCells){
            System.out.println(w.getText());
        }
    }
    //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
    @Test
    public void printColums() throws InterruptedException {
        login();
        //print Find the total number of columns
        List<WebElement> allColums = driver.findElements(By.xpath("//th"));
        System.out.println(allColums.size());
        //Print the elements of the 5th column
        Thread.sleep(5000);
        List<WebElement> fifthColum = driver.findElements(By.xpath("//tr//td[5]"));
        //  //tr//td[5] ==> give me 5th element on each row
        for (WebElement w : fifthColum){
            System.out.println(w.getText());
        }
    }
    //printData(3,6)==> PRİNT TH DATA İN ROW 3 COLUMN 6
    //Create a test method: printData(int row, int column);
    // This method should print the given cell.
    // Example: printData(2,3); should print 2nd row,3rd column

    //This custom method will take a row,and a column number
    //and ptint the data on that row and column
    //This is a not Test method
    public void printData(int row, int column){

    //    String xPath ="//tbody//tr[9]//td[5]";//NJ
    //    String xPath2 = "//tbody//tr[2]//td[3]";//12746376

        //Only the index number keep changing in teh webtable xpath
        String xPath = "//tbody//tr["+row+"]//td["+column+"]";
        WebElement data = driver.findElement(By.xpath(xPath));
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
        login();
        printData(2,3);
        printData(5,4);
    }




    //HOMEWORK
    /*
    Create a test method:webTableHW
    test if the 6th column includes price of 1000
    test if the first table row has Orlando
    Test if there 4th column has  Hotel name called Hilton
     */
    @Test
    public void webTableHW() throws InterruptedException {
        login();
        //test if the 6th column includes price of 1000
        Thread.sleep(5000);

        List<WebElement> allPrice = driver.findElements(By.xpath("//tr//td[6]"));
        List<String> list = new ArrayList<>();
        for (WebElement w : allPrice){
            System.out.println(w.getText());
            list.add(w.getText());
        }

        System.out.println(list);
        Assert.assertTrue(list.contains("1,000.00"));


        //test if the first table row has Orlando
        Thread.sleep(3000);
        List<WebElement> firstRow = driver.findElements(By.xpath("//tbody//tr[1]"));
        List<String> listRow = new ArrayList<>();
        for (WebElement w : firstRow){
            System.out.println(w.getText());
            Assert.assertTrue(w.getText().contains("Orlando"));
            listRow.add(w.getText());
        }
        System.out.println(listRow);

        //Test if there 4th column has  Hotel name called Hilton
        List<WebElement> column4 = driver.findElements(By.xpath("//tbody//tr[4]"));
        for (WebElement w : column4){
            System.out.print(w.getText() + ",");
            Assert.assertTrue(w.getText().contains("Hilton"));
        }


    }
}