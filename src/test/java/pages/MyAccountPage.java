package pages;

import org.openqa.selenium.By;

public class MyAccountPage {


    private final static By username = By.id("username");
    private final static By password = By.id("password");
    private final static By rememberMe = By.id("rememberme");
    private final static By registerMail = By.id("reg_email");
    private final static By loginButton = By.name("login");
    private final static By registerButton = By.name("register");
    private final static By registerErrorSection = By.xpath("//*[@id='post-92']//ul/li");
    private final static By logoutButton = By.cssSelector("li[class*='customer-logout']>a");
    private final static By displayName = By.id("account_display_name");
    public static By getDisplayName() {
        return displayName;
    }





    public static By getUsername() {
        return username;
    }

    public static By getPassword() {
        return password;
    }

    public static By getRememberMe() {
        return rememberMe;
    }

    public static By getRegisterMail() {
        return registerMail;
    }

    public static By getLoginButton() {
        return loginButton;
    }

    public static By getRegisterButton() {
        return registerButton;
    }

    public static By getRegisterErrorSection() {
        return registerErrorSection;
    }

    public static By getLogoutButton() {
        return logoutButton;
    }


}
