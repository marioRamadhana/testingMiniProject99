package test.java.Login;

import main.pageEvents.LoginPageEvents;
import main.utils.AddOns;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class P_Login extends BaseTest {

    AddOns add = new AddOns();

    @Test
    public void Login(){
        LoginPageEvents login = new LoginPageEvents();
        login.inputUsername("mngr335812");
        login.inputPassword("ApagAbY");
        login.clickLogin();

        //ASSERTION
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

//    @Test
    public void Login2(){
        LoginPageEvents login = new LoginPageEvents();
        String email = add.randomestring(2)+ "@spam4.me";

        login.inputUsername(email);
        login.inputPassword(add.randomeNum(2));
        login.clickLogin();
        System.out.println(email);

        //ASSERTION

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

//        String expect = "Guru99 Bank Manager HomePage";
//        String actual = driver.getTitle();
//        Assert.assertEquals(actual,expect);
    }
}
