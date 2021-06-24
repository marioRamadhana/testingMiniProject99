package test.java.Dashboard;

import main.pageEvents.DashbordPageEvents;
import main.pageEvents.FormNewCustomerEvents;
import main.pageEvents.LoginPageEvents;
import main.utils.AddOns;
import main.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.BaseTest;

public class NewCustomer extends BaseTest {

    AddOns add = new AddOns();

    @Test
    public void openFormNewCustomer(){
        LoginPageEvents login = new LoginPageEvents();
        DashbordPageEvents dash = new DashbordPageEvents();
        login.login(Constants.username,Constants.password);
        dash.clickMenuNewCustomer();
        String expect = "Guru99 Bank New Customer Entry Page";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expect);
    }

    @Test
    public void inputFormNewCustomer(){
        LoginPageEvents login = new LoginPageEvents();
        DashbordPageEvents dash = new DashbordPageEvents();
        FormNewCustomerEvents cust = new FormNewCustomerEvents();
        login.login(Constants.username,Constants.password);
        dash.clickMenuNewCustomer();
        cust.date("01012019");
        cust.inputCustName("testing name");
        cust.inputAddress("cccc");
        cust.inputCity("cicici");
        cust.inputState("state");
        cust.inputPin("1231231");
        cust.inputPhone("1234567890");
        cust.inputEmail("merdeka@spam4.me");
        cust.inputPassword("123123123");
        cust.clickSubmit();
        if (driver.getTitle().equals("Guru99 Bank Customer Registration Page")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void bulkInput(){
        LoginPageEvents login = new LoginPageEvents();
        DashbordPageEvents dash = new DashbordPageEvents();
        FormNewCustomerEvents cust = new FormNewCustomerEvents();
        login.login(Constants.username,Constants.password);
        dash.clickMenuNewCustomer();
//        input new customer all field input
        cust.newCust();
        cust.clickSubmit();

        //ASSERTION===============================================
        if (driver.getTitle().equals("Guru99 Bank Customer Registration Page")){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void inputFormNewCustomerReset() throws InterruptedException {
        LoginPageEvents login = new LoginPageEvents();
        DashbordPageEvents dash = new DashbordPageEvents();
        FormNewCustomerEvents cust = new FormNewCustomerEvents();
        login.login(Constants.username,Constants.password);
        Thread.sleep(2000);
        dash.clickMenuNewCustomer();
        cust.date("01012021");
        cust.inputCustName("aaaaa");
        cust.inputPassword("bbbbb");
        cust.inputAddress("cccc");
        cust.inputCity("cicici");
        cust.inputState("state");
        cust.inputPin("1231231");
        cust.inputPhone("1234567890");
        cust.inputEmail("email@email.com");
        cust.inputPassword("123123123");
        cust.clickReset();
    }

}
