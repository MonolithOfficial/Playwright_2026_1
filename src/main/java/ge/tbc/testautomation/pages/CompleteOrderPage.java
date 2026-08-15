package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CompleteOrderPage extends CommonPage {
    public Locator successMessage;
    public CompleteOrderPage(Page page){
        super(page);
        successMessage = page.locator("//*[@data-test='complete-header']");
    }
//     = $(byAttribute("data-test", "complete-header"));
}
