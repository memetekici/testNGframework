package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IsExistClass extends TestBase {
    @Test
    public void isExist(){
        //Check if the Flower image existing on your desktop

        //Find the path of the image
        String pathOfTheFile = "C:\\Users\\lenovo\\Desktop\\20180629_164227.jpg";

        //We will use Java to check if a file exist or not
        boolean isExist = Files.exists(Paths.get(pathOfTheFile));

        Assert.assertTrue(isExist);
    }
}
