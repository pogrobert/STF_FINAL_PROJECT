package tests;

import base.BaseTest;
import constants.messages.BagPageMessages;
import org.testng.annotations.Test;
import pages.BagPage;
import pages.ItemPage;
import pages.SearchPage;
import static org.testng.Assert.assertEquals;

public class AddToBag extends BaseTest {
    @Test
    public void addToBag() {
        SearchPage searchPage = basePage.performSearch("airpods");
        ItemPage itemPage = searchPage.getFirstItem();
        BagPage bagPage = itemPage.addToBag();
        assertEquals(bagPage.getTitle(), BagPageMessages.TITLE);
        assertEquals(bagPage.getPrice(), BagPageMessages.PRICE);
        assertEquals(bagPage.getCheckout(), BagPageMessages.CHECK_OUT);
    }
}
