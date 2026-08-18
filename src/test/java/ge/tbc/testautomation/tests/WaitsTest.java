package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WaitsTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
        launchOptions.setHeadless(false);
//        launchOptions.setSlowMo(1000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext();
    }

    // AUTO WAITS EXAMPLE
    @Test
    public void testEnableDisableButton() {
        Page page = browserContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator enableButton = page.locator("button").getByText("Enable");
        enableButton.click();
        Locator disableButton = page.locator("button").getByText("Disable");
        disableButton.click();
    }

    // EXPLICIT WAIT NEEDED
    @Test
    public void testExplicitWait() {
        Page page = browserContext.newPage();
        page.navigate("https://practicesoftwaretesting.com/");
//        page.waitForSelector("[data-test='product-name']");
        List<String> productNames = page.locator("[data-test='product-name']").allInnerTexts();
        System.out.println(productNames.size());
        Assert.assertTrue(productNames.containsAll(List.of("Pliers", "Bolt Cutters", "Hammer")));

        Locator elements = page.locator("css=your-selector");
        elements.all(); // gets all matching elements

        for (Locator element : elements.all()) {
            element.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        }

        assertThat(elements).hasCount(5);
    }


    @Test
    public void testEnableDisableButtonWithExplicitWait() {
        Page page = browserContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator enableButton = page.locator("button").getByText("Enable");
//        enableButton.waitFor();
        enableButton.click();
        Locator disableButton = page.locator("button").getByText("Disable");
        disableButton.click();
        page.waitForSelector("img[src='/img/ajax-loader.gif']", new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.HIDDEN).setTimeout(10000));
    }

    @Test
    public void testEnableDisableButtonWithAssertionWait() {
        Page page = browserContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        Locator enableButton = page.locator("button").getByText("Enable");
        enableButton.click();
        Locator disableButton = page.locator("button").getByText("Disable");
        disableButton.click();
        assertThat(page.locator("img[src='/img/ajax-loader.gif']")
                .first())
                .not()
                .isVisible();
    }
}
