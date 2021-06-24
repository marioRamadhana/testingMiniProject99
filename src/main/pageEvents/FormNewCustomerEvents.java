package main.pageEvents;

import main.pageObjects.FormAddNewCustObjects;
import main.utils.AddOns;
import main.utils.ElementFetch;

public class FormNewCustomerEvents {
    ElementFetch el = new ElementFetch();
    AddOns add = new AddOns();

    public void inputCustName(String key){
//        el.getWebElement("NAME", FormAddNewCustObjects.customerName).click();
        el.getWebElement("NAME", FormAddNewCustObjects.customerName).sendKeys(key);
    }
    public void genderMale(){
        el.getWebElement("XPATH", FormAddNewCustObjects.radioMale).click();
    }
    public void inputAddress(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.address).sendKeys(key);
    }
    public void inputCity(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.city).sendKeys(key);
    }
    public void inputState(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.state).sendKeys(key);
    }
    public void inputPin(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.pin).sendKeys(key);
    }
    public void inputPhone(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.phone).sendKeys(key);
    }
    public void inputEmail(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.email).sendKeys(key);
    }
    public void inputPassword(String key){
        el.getWebElement("NAME", FormAddNewCustObjects.password).sendKeys(key);
    }
    public void date(String ddmmyyyy){
        el.getWebElement("NAME",FormAddNewCustObjects.date).sendKeys(ddmmyyyy);
    }
    public void clickReset(){
        el.getWebElement("NAME", FormAddNewCustObjects.btnReset).click();
    }
    public void clickSubmit(){
        el.getWebElement("NAME",FormAddNewCustObjects.btnSubmit).click();
    }

    public void newCust(){

        el.getWebElement("NAME", FormAddNewCustObjects.customerName).sendKeys(add.randomestring(8));
        el.getWebElement("XPATH", FormAddNewCustObjects.radioMale).click();
        el.getWebElement("NAME", FormAddNewCustObjects.address).sendKeys(add.randomestring(10));
        el.getWebElement("NAME", FormAddNewCustObjects.city).sendKeys(add.randomestring(5));
        el.getWebElement("NAME", FormAddNewCustObjects.state).sendKeys(add.randomestring(5));
        el.getWebElement("NAME", FormAddNewCustObjects.pin).sendKeys(add.randomeNum(6));
        el.getWebElement("NAME", FormAddNewCustObjects.phone).sendKeys(add.randomeNum(11));
        el.getWebElement("NAME", FormAddNewCustObjects.email).sendKeys(add.randomestring(5)+"test@spam4.me");
        el.getWebElement("NAME", FormAddNewCustObjects.password).sendKeys(add.randomeNum(6));
        el.getWebElement("NAME",FormAddNewCustObjects.date).sendKeys("01012020");

    }



}
