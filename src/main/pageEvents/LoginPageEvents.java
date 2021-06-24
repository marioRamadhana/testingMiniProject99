package main.pageEvents;

import main.pageObjects.LoginPageObjects;
import main.utils.ElementFetch;
import org.apache.commons.logging.Log;

public class LoginPageEvents {
    ElementFetch el = new ElementFetch();

    public void inputUsername(String key){
        ElementFetch el = new ElementFetch();
        el.getWebElement("XPATH", LoginPageObjects.username).sendKeys(key);
    }
    public void inputPassword(String key){
        ElementFetch el = new ElementFetch();
        el.getWebElement("XPATH", LoginPageObjects.password).sendKeys(key);
    }
    public void clickLogin(){
        el.getWebElement("XPATH", LoginPageObjects.btnLogin).click();
    }
    public void clickReset(){
        el.getWebElement("XPATH", LoginPageObjects.btnReset).click();
    }
    public void login(String key1, String key2){
        el.getWebElement("XPATH", LoginPageObjects.username).sendKeys(key1);
        el.getWebElement("XPATH", LoginPageObjects.password).sendKeys(key2);
        el.getWebElement("XPATH", LoginPageObjects.btnLogin).click();
    }
}
