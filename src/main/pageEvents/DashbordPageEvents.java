package main.pageEvents;

import main.pageObjects.DashboardPageObjects;
import main.utils.ElementFetch;

public class DashbordPageEvents {
    ElementFetch el = new ElementFetch();
    public void clickMenuNewCustomer(){
        el.getWebElement("XPATH", DashboardPageObjects.newCustomer).click();
    }
    public void clickMenuManager(){
        el.getWebElement("XPATH", DashboardPageObjects.manager).click();
    }
    public void clickMenuEditCustomer(){
        el.getWebElement("XPATH", DashboardPageObjects.editCustomer).click();
    }
}
