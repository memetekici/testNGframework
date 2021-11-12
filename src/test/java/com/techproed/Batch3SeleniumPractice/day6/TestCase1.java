package com.techproed.Batch3SeleniumPractice.day6;

import com.techproed.Batch3SeleniumPractice.practicePages.ZeroBankLogin;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
//Go to http://zero.webappsecurity.com/
// 2. Write a useful method which is named login under the
//    practicePage
//3. Call the login method from TestCase1 class.

public class TestCase1 extends TestBase {
    @Test
    public void test1(){

        driver.get(ConfigReader.getProperty("zeroLink"));

        ZeroBankLogin login = new ZeroBankLogin(driver);

        login.zeroLogin();

    }
    @Test
    public void test2(){
        ZeroBankLogin.login();//Login methot static olduğu için Object oluşturmamıza gerek kalmadan
                              //login metoduna ulaştık.BU ÇOK ÖNMELİ
    }

}
