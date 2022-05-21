package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import constants.urls.Urls;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        driver = new ChromeDriver();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), caps);

        driver.manage().window().maximize();

        driver.get(Urls.HOME_URL);

        basePage = new BasePage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void afterTest(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(Paths.get(screenshot.getPath()), Paths.get("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
