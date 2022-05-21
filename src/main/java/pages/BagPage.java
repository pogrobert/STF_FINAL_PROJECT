package pages;

import constants.locators.BagPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BagPage {
    private final WebDriver driver;

    private final By title = By.xpath(BagPageConstants.TITLE);
    private final By price = By.xpath(BagPageConstants.PRICE);
    private final By checkOut = By.xpath(BagPageConstants.CHECK_OUT);

    public BagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public String getCheckout() {
        return driver.findElement(checkOut).getText();
    }
}
