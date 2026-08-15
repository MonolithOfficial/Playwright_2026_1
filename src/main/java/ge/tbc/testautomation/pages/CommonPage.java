package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonPage {
    public Locator goToCartBtn;
    public CommonPage(Page page){
        goToCartBtn = page.locator("//*[@data-test='shopping-cart-link']");
    }
//     = $(byAttribute("data-test", "shopping-cart-link"));
}
