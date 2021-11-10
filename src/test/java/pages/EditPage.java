package pages;

import org.openqa.selenium.By;

public class EditPage {
    private final static By edtAccDetails = By.cssSelector("div[class='woocommerce-MyAccount-content'] a[href*='my-account/edit-account']");
    private final static By edtId = By.id("account_first_name");
    private final static By edtLastName = By.id("account_last_name");
    private final static By edtPwd1 = By.id("password_1");

    public static By getEdtAccDetails() {
        return edtAccDetails;
    }

    public static By getEdtId() {
        return edtId;
    }

    public static By getEdtLastName() {
        return edtLastName;
    }

    public static By getEdtPwd1() {
        return edtPwd1;
    }

    public static By getEdtPwd2() {
        return edtPwd2;
    }

    public static By getSaveButton() {
        return saveButton;
    }

    private final static By edtPwd2 = By.id("password_2");
    private final static By saveButton = By.name("save_account_details");
}
