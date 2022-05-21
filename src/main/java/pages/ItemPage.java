package pages;

import constants.locators.ItemPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {
    final WebDriver driver;

    private final By addToCart = By.xpath(ItemPageConstants.ADD_TO_BAG);

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public BagPage addToBag() {
        WebElement addToCartElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(addToCart));
        addToCartElement.click();
        return new BagPage(driver);
    }
}
