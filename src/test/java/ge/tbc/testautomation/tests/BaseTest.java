package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Map;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;


    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
//        launchOptions.setSlowMo(3000); ONLY FOR DEBUGGING
        browser = playwright.webkit().launch(launchOptions);
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.navigate("https://saucedemo.com");
//        browserContext = browser.newContext(new Browser.NewContextOptions()
//                .setViewportSize(1920, 1080)
//                .setIgnoreHTTPSErrors(true));
    }

    @AfterClass
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
