package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardPage extends CommonPage {
    public Locator item;
    public DashboardPage(Page page){
        super(page);
        item = page.locator("//div[text()='Sauce Labs Backpack']");
    }
}
