package methods;

import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Methods {
    private Logger logger = LoggerFactory.getLogger(Methods.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor executor;
    private WebElement tempElement;
    private Actions action;

    public Methods() {
        this.driver = Driver.driver;
        wait = new WebDriverWait(driver, 15);
        executor = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void navigateToHomePage() {
        driver.navigate().to(System.getenv("APP_URL"));
        logger.info("Navigated to homepage ");
    }

    public void click(By by) {
        waitUntilPresence(by);
        tempElement = findElement(by);
        if (!tempElement.isDisplayed()) {
            scrollTo(tempElement.getLocation().getX(), tempElement.getLocation().getY());
        }
        try {
            waitUntilElementClickable(by);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            Assert.fail("Element not clickable! ");
        }
        tempElement.click();
        tempElement = null;
    }

    public void waitUntilElementClickable(By by) {
        logger.info("Waiting to element clickable ");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickIfExist(By by) {
        try {
            if (isExist(by)) {
                click(by);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void sendKeys(By by, String text) {
        clearTextArea(by);
        waitUntilPresence(by);
        tempElement = findElement(by);
        if (!tempElement.isDisplayed()) {
            scrollTo(tempElement.getLocation().getX(), tempElement.getLocation().getY());
        }
        tempElement.sendKeys(text);
        logger.info("Keys sent to text area ");
    }

    private void clearTextArea(By by) {
        waitUntilPresence(by);
        findElement(by).clear();
        logger.info("Text area cleared ");
    }

    public String getText(By by) {
        waitUntilPresence(by);
        logger.info("Getting text from given locator ");
        return findElement(by).getText();
    }

    /**
     * scrollTo WebElement location
     *
     * @param x
     * @param y
     */
    protected void scrollTo(int x, int y) {
        executor.executeScript(String.format("window.scrollTo(%d, %d);", x, y), true);
    }

    public Boolean isEnabled(By by) {
        logger.info("Checking is element enable on the page ");
        return findElement(by).isEnabled();
    }

    public Boolean isDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public void jsClick(By by) {

        executor.executeScript("arguments[0].click();", findElement(by));
        logger.info("Clicked element by jsClick");
    }

    public void selectByValue(By by, String text) {
        Select select = new Select(findElement(by));
        select.selectByValue(text);
        logger.info("Selected from dropdown");
    }

    public void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            logger.info("Waited " + seconds + " seconds ");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        }
    }

    public void findTextAndClick(By by, String text) {
        logger.info("Elementin var olması bekleniyor... ");
        waitUntilPresence(by);
        List<WebElement> searchText = driver.findElements(by);
        for (int i = 0; i < searchText.size(); i++) {
            if (searchText.get(i).getText().trim().contains(text)) {
                searchText.get(i).click();
                logger.info("Bulunan elemente tıklandı.");
                break;
            }
        }
    }

    public void hoverElement(By by) {
        waitUntilPresence(by);
        logger.info("Hovered element : " + by);
        action.moveToElement(findElement(by)).build().perform();
    }

    public void chooseRandomProduct(By by) {
        List<WebElement> productElements = findElements(by);
        int maxProducts = productElements.size();

        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        productElements.get(randomProduct).click();
        logger.info("Clicked random element ");
    }


    public boolean isExist(By by) {
        boolean isExist = false;
        waitUntilPresence(by);
        if (findElements(by).size() != 0) {
            isExist = true;
            logger.info(by + " Element exist");
        } else {
            isExist = false;
            logger.info(by + " Element doesn't exist");
        }
        return isExist;
    }

    public void waitUntilPresence(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        logger.info("Waited until element presence ");
    }

}
