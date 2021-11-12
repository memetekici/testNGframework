package com.techproed.tests;

import org.testng.Assert;
import org.testng.DependencyMap;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void logIn(){
        System.out.println("Log in Test");
    }
    @Test
    public void homePage(){
        System.out.println("Home page test");
        Assert.assertEquals(3,4);

    }
    @Test(dependsOnMethods = "homePage")
    public void searchTest(){//I want searchTest to be dependent on homePage.I want searctTest skipped if homePage failed
        System.out.println("Seach test");

    }
    @Test
    public void verifyTheResult(){
        System.out.println("Result test");

    }
}
