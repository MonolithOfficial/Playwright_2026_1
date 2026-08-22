package ge.tbc.testautomation.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadUploadTests {
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
    public void downloadTest() {
        page.navigate("https://the-internet.herokuapp.com/download");
        Locator link = page.locator("//a[text()='testFile.jpg']");

        Download download = page.waitForDownload(link::click);
        download.saveAs(Paths.get(System.getProperty("user.dir"), "/build/downloads/", download.suggestedFilename()));
        File downloadedFile = download.path().toFile();
    }

    @Test
    public void testUpload() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        Locator uploadInput = page.locator("#file-upload");

        FileChooser fileChooser = page.waitForFileChooser(uploadInput::click);

        if (fileChooser.isMultiple()){
            fileChooser.setFiles(new Path[]{
                    Paths.get(System.getProperty("user.dir"), "/src/main/resources/ronaldokneeslide.jpg"),
                    Paths.get(System.getProperty("user.dir"), "/src/main/resources/ronaldokneeslide.jpg")
            });
        }
        else {
            fileChooser.setFiles(Paths.get(System.getProperty("user.dir"), "/src/main/resources/ronaldokneeslide.jpg"));
        }
    }
}
