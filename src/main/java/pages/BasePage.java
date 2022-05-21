package pages;

import constants.locators.BaseConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;

    private final By homeButton = By.id(BaseConstants.HOME_BUTTON);
    private final By storeButton = By.xpath(BaseConstants.STORE_BUTTON);
    private final By supportButton = By.xpath(BaseConstants.SUPPORT_BUTTON);
    private final By searchButtonHeader = By.xpath(BaseConstants.SEARCH_BUTTON_BASE);
    private final By searchInput = By.xpath(BaseConstants.SEARCH_INPUT);
    private final By searchSubmit = By.xpath(BaseConstants.SEARCH_BUTTON_SUBMIT);
    private final By bagIcon = By.xpath(BaseConstants.BAG_ICON);
    private final By bagButton = By.xpath(BaseConstants.BAG_BUTTON);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }

    public StorePage getStorePage() {
        driver.findElement(storeButton).click();
        return new StorePage(driver);
    }

    public SupportPage getSupportPage() {
        driver.findElement(supportButton).click();
        return new SupportPage(driver);
    }

    public SearchPage performSearch(String searchWord) {
        driver.findElement(searchButtonHeader).click();
        driver.findElement(searchInput).sendKeys(searchWord);
        driver.findElement(searchSubmit).click();
        return new SearchPage(driver);
    }

    public BagPage getBagPage() {
        driver.findElement(bagIcon).click();
        driver.findElement(bagButton).click();
        return new BagPage(driver);
    }
}
