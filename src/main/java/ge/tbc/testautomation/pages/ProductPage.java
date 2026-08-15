package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage extends CommonPage {
    public Locator addToCart;

    public ProductPage(Page page) {
        super(page);
        addToCart = page.locator("#add-to-cart");
    }
}
