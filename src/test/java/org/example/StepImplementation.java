package org.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import methods.Methods;
import org.openqa.selenium.By;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class StepImplementation extends Methods {
    String firstPrice, secondPrice;


    //Shop Menu Page
    private final static By dressesCategory = By.cssSelector("li[class='cat-item cat-item-23'] a");
    private final static By products = By.cssSelector("ul[class='products columns-3'] li");

    public StepImplementation() {

    }

    @Step({"Open the SampleShop homepage", "Sayfayı aç"})
    public void landingPage() {
        String app_url = System.getenv("APP_URL");
        Driver.driver.get(app_url + "/");
        assertThat(Driver.driver.getTitle()).contains("Home - Sample Shop");
    }

    @Step({"User opens My Account page"})
    public void goToMyAccountPage() {
        click(Header.getMyAccount());
        Gauge.writeMessage("These messages are displayed after the steps in the execution reports.");
    }

    @Step("User completes registration scenario successfully by this e-mail")
    public void register() {
        sendKeys(MyAccountPage.getRegisterMail(), System.getenv("userEmailParameter"));
        click(MyAccountPage.getRegisterButton());
        System.out.println("test");
    }

    @Step("Check if user already registered")
    public void isAlreadyRegisteredAlertAppear() {
        if (isExist(MyAccountPage.getRegisterErrorSection())) {
            System.out.println("This user already registered");
        }
    }

    @Step("User checks product description existence")
    public void isExistDescription() {
        isExist(ProductDetailPage.getDescriptionSection());
    }

    @Step("User checks product price existence")
    public void isExistPrice() {
        isExist(CartPage.getPriceProductPage());
    }

    @Step("User checks product photo existence")
    public void isExistPhoto() {
        isExist(ProductDetailPage.getPhotoSection());
    }


    @Step("User adds product to cart")
    public void addToCard() {
        click(ProductDetailPage.getAddToCardButton());
    }

    @Step("User enters <username> and <password> for login")
    public void fillEmailAndPasswordFields(String username, String password) {
        sendKeys(MyAccountPage.getUsername(), username);
        sendKeys(MyAccountPage.getPassword(), password);
        click(MyAccountPage.getRememberMe());
        click(MyAccountPage.getLoginButton());
    }

    @Step("User clicks “edit your password and account details” link.")
    public void clickEditYourPassword() {
        click(EditPage.getEdtAccDetails());

    }

    @Step("User fills account details and changes their password")
    public void fillAccountDetails() {
        sendKeys(EditPage.getEdtId(), System.getenv("FIRSTNAME"));
        sendKeys(EditPage.getEdtLastName(), System.getenv("LASTNAME"));
        sendKeys(EditPage.getEdtPwd1(), "123123123a");
        sendKeys(EditPage.getEdtPwd2(), "123123123a");
        click(EditPage.getSaveButton());

    }

    @Step("User opens Shop page")
    public void openShopPage() {
        click(Header.getShopMenuBar());
    }

    @Step("User opens Dresses category")
    public void openDressesCategory() {
        click(dressesCategory);
    }

    @Step("User selects random product and opens detail")
    public void selectRandomProduct() {
        chooseRandomProduct(products);
    }


    @Step("Wait <key> seconds")
    public void waitBySecond(int x) {
        sleepSeconds(x);
    }


    @Step("User opens cart with View cart button and checks price accuracy")
    public void openCardAndCheckAccuracy() {
        firstPrice = getText(CartPage.getPriceProductPage());
        clickIfExist(ProductDetailPage.getViewCardButton());
        secondPrice = getText(ProductDetailPage.getPriceCartPage());
        System.out.println(firstPrice);
        System.out.println(secondPrice);
        assertEquals("Prices are different !", firstPrice.trim(), secondPrice.trim());
    }

    @Step("User proceeds to checkout")
    public void proceed() {
        click(CartPage.getProceedButton());
    }

    @Step("User fills mandatory fields and click “Place Order” button")
    public void fillBillingForm() {

        sendKeys(CheckOutPage.getBillingFirstName(), System.getenv("FIRSTNAME"));
        sendKeys(CheckOutPage.getBillingLastName(), System.getenv("LASTNAME"));
        sendKeys(CheckOutPage.getCompanyName(), System.getenv("COMPANYNAME"));
        selectByValue(CheckOutPage.getBillingCountrySelection(), System.getenv("COUNTRY"));
        sendKeys(CheckOutPage.getBillingAddress(), System.getenv("BILLINGADDRESS"));
        sendKeys(CheckOutPage.getBillingPostCode(), System.getenv("ZIPCODE"));
        sendKeys(CheckOutPage.getBillingCity(), System.getenv("TOWN"));
        sendKeys(CheckOutPage.getBillingPhone(), System.getenv("PHONENUMBER"));
        sendKeys(CheckOutPage.getBillingEmail(), System.getenv("EMAIL"));
        jsClick(CheckOutPage.getButtonPlaceOrder());
        assertEquals("Invalid payment method.", getText(CheckOutPage.getErrorMessage()));
    }

    @Step("Logout current user")
    public void logout() {
        navigateToHomePage();
        click(Header.getMyAccount());
        click(MyAccountPage.getLogoutButton());
    }
}
