package com.techproed.Batch3SeleniumPractice.day6;

import com.techproed.Batch3SeleniumPractice.practicePages.WebTablePages;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {
    //1.Go to ” https://demoqa.com/webtables”
    //2.Print Department from the headers
    //3.Print the all the department name of Alden

    @Test
    public void test2(){
        driver.get(ConfigReader.getProperty("demogaLink"));
        WebTablePages webTables = new WebTablePages(driver);

        String department = webTables.departmentHeader.getText();
        System.out.println("department = " + department);

        String departmantName = webTables.depertmanName.getText();
        System.out.println("depertman name = " + departmantName);

        System.out.println(webTables.DepName("Kierra"));
    }
}
