package pages;

import org.openqa.selenium.By;

public class CheckOutPage {

    private final static By billingFirstName = By.id("billing_first_name");
    private final static By billingLastName = By.id("billing_last_name");
    private final static By billingPostCode = By.id("billing_postcode");
    private final static By billingCity = By.cssSelector("[id='billing_city']");
    private final static By billingAddress = By.id("billing_address_1");
    private final static By billingPhone = By.id("billing_phone");
    private final static By billingEmail = By.id("billing_email");
    private final static By billingCountrySelection = By.id("billing_country");
    private final static By companyName = By.cssSelector("input[id='billing_company']");
    private final static By buttonPlaceOrder = By.cssSelector("button[id='place_order']");
    private final static By errorMessage = By.cssSelector("ul[class='woocommerce-error'] li");

    public static By getCompanyName() {
        return companyName;
    }

    public static By getBillingFirstName() {
        return billingFirstName;
    }

    public static By getBillingLastName() {
        return billingLastName;
    }

    public static By getBillingPostCode() {
        return billingPostCode;
    }

    public static By getBillingCity() {
        return billingCity;
    }

    public static By getBillingAddress() {
        return billingAddress;
    }

    public static By getBillingPhone() {
        return billingPhone;
    }

    public static By getBillingEmail() {
        return billingEmail;
    }

    public static By getBillingCountrySelection() {
        return billingCountrySelection;
    }

    public static By getButtonPlaceOrder() {
        return buttonPlaceOrder;
    }

    public static By getErrorMessage() {
        return errorMessage;
    }


}
