package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JSEvaluateTests {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;


    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        launchOptions.setSlowMo(2000);
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
    }

    @Test
    public void testJSEvaluate() {
        page.navigate("https://swoop.ge");
        page.waitForFunction("() => document.readyState === 'complete'");
        String loadState = (String) page.evaluate("document.readyState");
        System.out.println(loadState);
    }

    @Test
    public void testJSEvaluateWithLocatorPassed() {
        page.navigate("https://the-internet.herokuapp.com/");
        Locator forgotPasswordLink = page.locator("//a[text()='Forgot Password']");
        Locator framesLink = page.locator("//a[text()='Frames']");

        forgotPasswordLink.evaluate("element => element.click()");

        ElementHandle forgotPasswordLinkHandle = forgotPasswordLink.elementHandle();
        ElementHandle framesHandle = framesLink.elementHandle();
        Map<String, ElementHandle> links = new HashMap<>();
        links.put("link1", forgotPasswordLinkHandle);
        links.put("link2", framesHandle);

        page.evaluate("({ link1, link2 }) => {link1.scrollIntoView(); link2.scrollIntoView();}", links);
    }
}
