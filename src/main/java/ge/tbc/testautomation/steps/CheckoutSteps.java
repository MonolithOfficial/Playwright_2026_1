package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.CheckoutPage;
import io.qameta.allure.Step;

public class CheckoutSteps {
    Page page;
    CheckoutPage checkoutPage;

    public CheckoutSteps(Page page) {
        this.page = page;
        checkoutPage = new CheckoutPage(page);
    }

    @Step("Fill personal information. First name: {}, last name: {}, zip code: {}")
    public CheckoutSteps fillInformation(String firstName, String lastName, String zipCode){
        checkoutPage.firstNameInput.fill(firstName);
        checkoutPage.lastNameInput.fill(lastName);
        checkoutPage.zipCodeInput.fill(zipCode);

        return this;
    }

    @Step("Go to review page")
    public CheckoutSteps goToReviewPage(){
        checkoutPage.continueBtn.click();

        return this;
    }
}
