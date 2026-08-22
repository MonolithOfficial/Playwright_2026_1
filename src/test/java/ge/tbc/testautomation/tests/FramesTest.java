package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest {
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
    public void testFrames() {
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        Locator middleFrameText = page
                .frameLocator("frame[name='frame-top']")
                .frameLocator("frame[name='frame-middle']")
                .locator("#content");
        System.out.println(middleFrameText);
    }

    @Test
    public void testTabs(){
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        Page page2 = browserContext.newPage();
        page2.navigate("https://swoop.ge");

        Page page3 = browserContext.newPage();
        page3.navigate("https://projectmonolith.net");

        page3.bringToFront();
        page2.bringToFront();
        page2.close();

//        List<BrowserContext> contexts = browser.contexts();
        List<Page> allTabs = browserContext.pages();
        allTabs.forEach(tab -> System.out.println(tab.title()));
    }

    @Test
    public void testAlerts() {
        page.navigate("https://demoqa.com/alerts");
        Locator alertBtn = page.locator("#alertButton");
        alertBtn.click();

//        page.onDialog(Dialog::accept);
//        page.onDialog(Dialog::dismiss);
//        page.onDialog(Dialog::message);
//        page.onDialog(dialog -> dialog.accept("something"));
    }
}
