package pages;

import org.openqa.selenium.By;

public class ProductDetailPage {

    private final static By descriptionSection = By.id("tab-description");
    private final static By priceCartPage = By.cssSelector("tr td[class='product-price'] span bdi");
    private final static By photoSection = By.cssSelector("div[id*='product'] img[class='wp-post-image']");
    private final static By addToCardButton = By.name("add-to-cart");
    private final static By viewCardButton = By.cssSelector("a[class='button wc-forward']");

    public static By getDescriptionSection() {
        return descriptionSection;
    }

    public static By getPriceCartPage() {
        return priceCartPage;
    }

    public static By getPhotoSection() {
        return photoSection;
    }

    public static By getAddToCardButton() {
        return addToCardButton;
    }

    public static By getViewCardButton() {
        return viewCardButton;
    }


}
