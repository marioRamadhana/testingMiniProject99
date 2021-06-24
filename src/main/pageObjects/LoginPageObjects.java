package main.pageObjects;

public interface LoginPageObjects {
    String username = "//tbody/tr[1]/td[2]/input[1]";
    String password = "//tbody/tr[2]/td[2]/input[1]";
    String btnLogin = "//tbody/tr[3]/td[2]/input[1]";
    String btnReset = "//tbody/tr[3]/td[2]/input[2]";
}
