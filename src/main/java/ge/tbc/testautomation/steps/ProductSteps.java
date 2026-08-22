package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ProductPage;
import io.qameta.allure.Step;

public class ProductSteps {
    Page page;
    ProductPage productPage;

    public ProductSteps(Page page) {
        this.page = page;
        productPage = new ProductPage(page);
    }

    @Step("Add item to cart")
    public ProductSteps addItemToCart(){
        productPage.addToCart.click();

        return this;
    }

    @Step("Go to cart")
    public ProductSteps goToCart(){
        productPage.goToCartBtn.click();

        return this;
    }
}
