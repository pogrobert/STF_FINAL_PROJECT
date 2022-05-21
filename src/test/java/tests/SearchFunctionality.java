package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchFunctionality extends BaseTest {
    @Test
    public void checkResults() {
        SearchPage searchPage = basePage.performSearch("airpods");
        ArrayList<String> results = searchPage.getAllResults();
        results.removeIf(String::isEmpty); // remove empty strings, if there are any.
        int totalMatches = 0;
        for (String title : results) {
            if (title.contains("AirPods")) totalMatches++;
        }
        // Not all results might contain the searched word, but they are still valid.
        // For instance, in case if we are searching AirPods, there are some wireless Beats headphones.
        // That is why instead of checking for all results to contain the searched word,
        // I am checking whether the 90% of the results contain it.
        double ninetyPercent = results.size() * 0.9;
        assertTrue(totalMatches >= ninetyPercent);
    }

    @Test
    public void checkInvalidSearch() {
        SearchPage searchPage = basePage.performSearch("asdasdasd");
        assertTrue(searchPage.getNoMatches().isDisplayed());
    }

    @Test
    public void checkCasesFilter() throws InterruptedException {
        SearchPage searchPage = basePage.performSearch("airpods");
        int initialResult = searchPage.getAllResults().size();
        searchPage.applyHeadphoneCasesFilter();
        Thread.sleep(3000); // in order to be sure that the old results are replaced.
        ArrayList<String> results = searchPage.getAllResults();

        results.removeIf(String::isEmpty); // remove empty strings, if there are any.

        int filterApplied = results.size();

        int totalMatches = 0;
        for (String title : results) {
            System.out.println(title);
            if (title.contains("Case")) totalMatches++;
        }

        assertTrue(initialResult > filterApplied);
        assertEquals(filterApplied, totalMatches);
    }

    @Test
    public void checkLowToHighFilter() throws InterruptedException {
        SearchPage searchPage = basePage.performSearch("watch stands");
        searchPage.setSortFromLow();
        Thread.sleep(3000); // in order to be sure that the old results are replaced.
        ArrayList<String> prices = searchPage.getAllPrices();
        prices.removeIf(String::isEmpty); // remove empty strings, if there are any.
        for (int i = 0; i < prices.size() - 2; i++) {
            double first = Double.parseDouble(prices.get(i).substring(1));
            double second = Double.parseDouble(prices.get(i + 1).substring(1));
            assertTrue(first <= second);
        }
    }

    @Test
    public void checkHighToLowFilter() throws InterruptedException {
        SearchPage searchPage = basePage.performSearch("watch stands");
        searchPage.setSortFromHigh();
        Thread.sleep(3000); // in order to be sure that the old results are replaced.
        ArrayList<String> prices = searchPage.getAllPrices();
        prices.removeIf(String::isEmpty); // remove empty strings, if there are any.
        for (int i = 0; i < prices.size() - 2; i++) {
            double first = Double.parseDouble(prices.get(i).substring(1));
            double second = Double.parseDouble(prices.get(i + 1).substring(1));
            System.out.println(first);
            System.out.println(second);
            assertTrue(first >= second);
        }
    }
}
