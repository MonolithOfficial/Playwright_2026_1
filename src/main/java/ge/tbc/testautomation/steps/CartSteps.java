package ge.tbc.testautomation.steps;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.CartPage;

public class CartSteps {
    Page page;
    CartPage cartPage;

    public CartSteps(Page page) {
        this.page = page;
        cartPage = new CartPage(page);
    }

    public CartSteps validateCartSize(int expectedSize){
        PlaywrightAssertions.assertThat(cartPage.cartItems).hasCount(expectedSize);

        return this;
    }

    public CartSteps goToCheckout(){
        cartPage.checkoutBtn.click();

        return this;
    }
}
