package tests;

import base.BaseTest;
import org.testng.annotations.*;
import constants.messages.*;
import pages.HomePage;
import pages.StorePage;
import pages.SupportPage;

import static org.testng.Assert.assertEquals;

public class TestsFromHomework extends BaseTest {
    @Test
    public void allPages() {
        HomePage homePage = basePage.getHomePage();
        assertEquals(homePage.getShopTitle(), HomePageMessages.SHOP_MESSAGE);
        StorePage storePage = basePage.getStorePage();

        assertEquals(storePage.getMainTitle(), StoreMessages.MAIN_MESSAGE);
        SupportPage supportPage = basePage.getSupportPage();

        assertEquals(supportPage.getMainTitle(), SupportMessages.MAIN_MESSAGE);
    }

    @Test
    public void homeAndSupport() {
        HomePage homePage = basePage.getHomePage();
        assertEquals(homePage.getServicesTitle(), HomePageMessages.SERVICES_MESSAGE);
        SupportPage supportPage = basePage.getSupportPage();

        assertEquals(supportPage.getAppleWorkoutTitle(), SupportMessages.APPLE_WATCH_MESSAGE);
    }

    @Test
    public void homeAndStore() {
        HomePage homePage = basePage.getHomePage();
        assertEquals(homePage.getAccountTitle(), HomePageMessages.ACCOUNT_MESSAGE);
        StorePage storePage = basePage.getStorePage();

        assertEquals(storePage.getLatestTitle(), StoreMessages.THE_LATEST_MESSAGE);
    }

    @Test
    public void storeAndSupport() {
        StorePage storePage = basePage.getStorePage();
        assertEquals(storePage.getDifferenceNumber(), StoreMessages.THE_APPLE_DIFFERENCE_MESSAGE);
        assertEquals(storePage.getHelpTitle(), StoreMessages.HELP_IS_HERE_MESSAGE);


        SupportPage supportPage = basePage.getSupportPage();
        assertEquals(supportPage.getVirtualSessionsTitle(), SupportMessages.VIRTUAL_SESSIONS_MESSAGE);
        assertEquals(supportPage.getFaceTimeTitle(), SupportMessages.FACE_TIME_MESSAGE);
    }
}
