package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import constants.locators.StoreConstants;

public class StorePage {
    private final WebDriver driver;

    private final By mainTitle = By.xpath(StoreConstants.MAIN_TITLE);
    private final By latestTitle = By.xpath(StoreConstants.THE_LATEST_TITLE);
    private final By helpTitle = By.xpath(StoreConstants.HELP_IS_HERE_TITLE);
    private final By differenceTitle = By.xpath(StoreConstants.THE_APPLE_DIFFERENCE);

    public StorePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainTitle() {
        return driver.findElement(mainTitle).getText();
    }

    public String getLatestTitle() {
        return driver.findElement(latestTitle).getText();
    }

    public String getHelpTitle() {
        return driver.findElement(helpTitle).getText();
    }

    public String getDifferenceNumber() {
        return driver.findElement(differenceTitle).getText();
    }
}
