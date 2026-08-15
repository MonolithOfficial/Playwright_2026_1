package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends CommonPage{
    public Locator firstNameInput;
    public Locator lastNameInput;
    public Locator zipCodeInput;
    public Locator continueBtn;
    public CheckoutPage(Page page){
        super(page);
        firstNameInput = page.locator("#first-name");
        lastNameInput = page.locator("#last-name");
        zipCodeInput = page.locator("#postal-code");
        continueBtn = page.locator("#continue");
    }
}
