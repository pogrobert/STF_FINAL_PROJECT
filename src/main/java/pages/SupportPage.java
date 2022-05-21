package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import constants.locators.SupportConstants;

public class SupportPage {
    private final WebDriver driver;

    private final By mainTitle = By.className(SupportConstants.MAIN_TITLE);
    private final By appleWorkoutsTitle = By.xpath(SupportConstants.APPLE_WATCH_WORKOUT);
    private final By faceTimeTitle = By.xpath(SupportConstants.FACE_TIME_CONNECTED);
    private final By virtualSessionsTitle = By.xpath(SupportConstants.VIRTUAL_SESSIONS);

    public SupportPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainTitle() {
        return driver.findElement(mainTitle).getText();
    }

    public String getAppleWorkoutTitle() {
        return driver.findElement(appleWorkoutsTitle).getText();
    }

    public String getFaceTimeTitle() {
        return driver.findElement(faceTimeTitle).getText();
    }

    public String getVirtualSessionsTitle() {
        return driver.findElement(virtualSessionsTitle).getText();
    }
}
