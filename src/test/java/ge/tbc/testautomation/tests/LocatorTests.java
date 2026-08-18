package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

public class LocatorTests {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;

//    Playwright launches the automation engine.
//    Browser represents the browser instance (e.g., Chrome, Firefox).
//    BrowserContext represents an isolated session in the browser.
//    Page represents a single tab within the context.

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
        launchOptions.setHeadless(false);
        launchOptions.setSlowMo(1000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext();
    }

    @Test
    public void testGetByRole() {
        Page page = browserContext.newPage();
        page.navigate("https://practicesoftwaretesting.com/");
        // TRY FIND HAMMER CHECKBOX BY ITS ROLE
        Locator hammerCheckBox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Hammer"));
        PlaywrightAssertions.assertThat(hammerCheckBox).isVisible();

        // TRY FIND SEARCH BUTTON BY ITS ROLE
        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        PlaywrightAssertions.assertThat(searchButton).isVisible();
    }

    @Test
    public void testLocatorMethod() {
        Page page = browserContext.newPage();
        page.navigate("https://practicesoftwaretesting.com/");
//        Locator hammerCheckBox = page.locator("//label[contains(text(), 'Hammer')]")
//                .locator("input");
//        PlaywrightAssertions.assertThat(hammerCheckBox).isVisible();
//
//        Locator searchButton = page.locator("button[type='submit']"); // CSS SELECTOR;
//        PlaywrightAssertions.assertThat(searchButton).isVisible();

        Locator wrenchCheckBox = page
                .locator("fieldset")
                .locator("div.checkbox")
                .getByLabel("Wrench");
        PlaywrightAssertions.assertThat(wrenchCheckBox).isVisible();
    }

    @Test
    public void testLists() {
        Page page = browserContext.newPage();
        page.navigate("https://practicesoftwaretesting.com/");
        // Get all checkboxes in div.checkboxes which have labels contain 'er' sequence
        Locator allCheckBoxDivs = page.locator("//div[@class='checkbox']//ul//div")
                .filter(new Locator
                        .FilterOptions()
                        .setHas(page
                                .getByText(Pattern.compile("er"))));
        System.out.println(allCheckBoxDivs.count());
        for (Locator checkBox :
                allCheckBoxDivs.all()) {
            // click each checkbox
            checkBox.scrollIntoViewIfNeeded();
            checkBox.locator("input").check(); // note usage of check() method, not click()
        }
    }

    @Test(description = "Get all cards on dashboard and check if each has a dollar sign in the pricing section")
    public void cardPricesShouldContainDollarSignsTest() {
        Page page = browserContext.newPage();
        page.navigate("https://practicesoftwaretesting.com/");
        Locator allCards = page.locator(".card");
        for (Locator card :
                allCards.all()) {
            PlaywrightAssertions.assertThat(card.locator(".card-footer")).containsText("$");
        }
    }

    @AfterClass
    public void tearDown(){
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
