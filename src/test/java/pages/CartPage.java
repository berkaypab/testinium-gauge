package pages;

import org.openqa.selenium.By;

public class CartPage {

    private final static By proceedButton = By.cssSelector("div[class='wc-proceed-to-checkout'] a");
    private final static By priceProductPage = By.xpath("(//p[@class='price']//ins//bdi | //p[@class='price']//bdi)[1]");

    public static By getProceedButton() {
        return proceedButton;
    }

    public static By getPriceProductPage() {
        return priceProductPage;
    }


}
