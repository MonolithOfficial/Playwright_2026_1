package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ReviewPage extends CommonPage {
    public Locator itemToBeValidated;
    public Locator finishBtn;

    public ReviewPage(Page page) {
        super(page);
        itemToBeValidated = page.getByText("Sauce Labs Backpack");
        finishBtn = page.locator("#finish");
    }
}
