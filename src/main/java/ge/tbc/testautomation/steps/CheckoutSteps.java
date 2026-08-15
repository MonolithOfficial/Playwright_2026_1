package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CheckoutPage;

public class CheckoutSteps {
    Page page;
    CheckoutPage checkoutPage;

    public CheckoutSteps(Page page) {
        this.page = page;
        checkoutPage = new CheckoutPage(page);
    }

    public CheckoutSteps fillInformation(String firstName, String lastName, String zipCode){
        checkoutPage.firstNameInput.fill(firstName);
        checkoutPage.lastNameInput.fill(lastName);
        checkoutPage.zipCodeInput.fill(zipCode);

        return this;
    }

    public CheckoutSteps goToReviewPage(){
        checkoutPage.continueBtn.click();

        return this;
    }
}
