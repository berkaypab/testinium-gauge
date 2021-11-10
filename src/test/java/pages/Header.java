package pages;

import org.openqa.selenium.By;

public class Header {


    private static By shopMenuBar = By.id("menu-item-834");
    private final static By myAccount = By.id("menu-item-844");

    public static By getMyAccount() {
        return myAccount;
    }

    public static By getShopMenuBar() {
        return shopMenuBar;
    }
}
