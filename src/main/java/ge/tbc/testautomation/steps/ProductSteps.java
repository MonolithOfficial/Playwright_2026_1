package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductPage;

public class ProductSteps {
    Page page;
    ProductPage productPage;

    public ProductSteps(Page page) {
        this.page = page;
        productPage = new ProductPage(page);
    }

    public ProductSteps addItemToCart(){
        productPage.addToCart.click();

        return this;
    }

    public ProductSteps goToCart(){
        productPage.goToCartBtn.click();

        return this;
    }
}
