package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends CommonPage {
    public Locator cartItems;
    public Locator checkoutBtn;
    public CartPage(Page page) {
        super(page);
        cartItems = page.locator(".cart_item");
        checkoutBtn = page.locator("#checkout");
    }
}
