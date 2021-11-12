package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FisrtTestBaseExample extends TestBase {
    //Create a test class
    //This test class will call the setUpand tearDown methods in the TestBase
    @Test
    public void test1(){
        driver.get("https://www.google.com/");

    }
}
