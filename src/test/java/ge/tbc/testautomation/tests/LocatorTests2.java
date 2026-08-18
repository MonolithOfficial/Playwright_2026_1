package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

public class LocatorTests2 {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
//        launchOptions.setSlowMo(2000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
    }

    @Test
    public void testGetByLabel() {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator hammerCheckbox = page.getByLabel("Hammer");
        hammerCheckbox.click();
        page.pause();
    }

    @Test
    public void testRole() {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator searchBar = page.getByLabel("Search");
        searchBar.fill("Cutters");

        Locator searchButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Search"));
        searchButton.click();
    }

    @Test
    public void testLists() {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator allCheckBoxes = page.locator("//div[@class='checkbox']//label");
        Locator filteredCheckboxes = allCheckBoxes
                .filter(new Locator.FilterOptions()
                        .setHas(page.getByText(Pattern.compile("er"))));

        System.out.println(filteredCheckboxes.count());
        for (Locator checkBox : filteredCheckboxes.all()){
            checkBox.scrollIntoViewIfNeeded();
            checkBox.locator("//input").check();
        }
    }

    @Test
    public void testAutoWait() {
//        page.setDefaultTimeout(3000);
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator enableButton = page.locator("button").getByText("Enable");
        enableButton.click();

        Locator disableButton = page.locator("button").getByText("Disable");
        disableButton.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        String disableText = disableButton.textContent();
        System.out.println(disableText);
    }

    @Test
    public void testExplicitWaits() {
        page.navigate("https://practicesoftwaretesting.com/");
//        page.waitForSelector("[data-test='product-name']");
        PlaywrightAssertions.assertThat(page.locator("[data-test='product-name']"))
                .hasCount(9);
        List<String> productNames = page.locator("[data-test='product-name']")
                .allInnerTexts();
        System.out.println(productNames.size());

    }

    //    @AfterClass
//    public void tearDown() {
//        page.close();
//        browser.close();
//        playwright.close();
//    }
}
