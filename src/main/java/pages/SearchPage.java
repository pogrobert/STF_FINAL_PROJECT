package pages;

import constants.locators.SearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private final WebDriver driver;

    private final By searchInput = By.id(SearchPageConstants.SEARCH_INPUT);
    private final By sortButton = By.xpath(SearchPageConstants.SORT_BUTTON);
    private final By lowToHigh = By.xpath(SearchPageConstants.LOW_TO_HIGH);
    private final By highToLow = By.xpath(SearchPageConstants.HIGH_TO_LOW);
    private final By tileTitle = By.className(SearchPageConstants.RESULT_TILE_TITLE);
    private final By noMatches = By.className(SearchPageConstants.NO_MATCHES_FOUND);
    private final By headphoneCasesFilter = By.className(SearchPageConstants.CASES_FILTER);
    private final By price = By.className(SearchPageConstants.PRICE);
    private final By listItem = By.className(SearchPageConstants.LIST_ITEM);

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchInput() {
        return driver.findElement(searchInput);
    }

    public void setSortFromLow() {
        driver.findElement(sortButton).click();
        driver.findElement(lowToHigh).click();
    }

    public void setSortFromHigh() {
        driver.findElement(sortButton).click();
        driver.findElement(highToLow).click();
    }

    public ArrayList<String> getAllResults() {
        List<WebElement> elements = driver.findElements(tileTitle);
        ArrayList<String> strings = new ArrayList<>();
        elements.forEach(webElement -> strings.add(webElement.getText()));
        return strings;
    }

    public ArrayList<String> getAllPrices() {
        List<WebElement> elements = driver.findElements(price);
        ArrayList<String> strings = new ArrayList<>();
        elements.forEach(webElement -> strings.add(webElement.getText()));
        return strings;
    }

    public WebElement getNoMatches() {
        return driver.findElement(noMatches);
    }

    public void applyHeadphoneCasesFilter() {
        driver.findElements(headphoneCasesFilter).get(1).click();
    }

    public ItemPage getFirstItem() {
        driver.findElement(listItem).click();
        return new ItemPage(driver);
    }
}
