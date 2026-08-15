package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.FIRSTNAME;
import static ge.tbc.testautomation.data.Constants.LASTNAME;
import static ge.tbc.testautomation.data.Constants.SUCCESS_MESSAGE;
import static ge.tbc.testautomation.data.Constants.ZIPCODE;

public class SuccessfulPurchaseScenarioTest extends BaseTest{
    LoginSteps loginSteps;
    DashboardSteps dashboardSteps;
    ProductSteps productSteps;
    CartSteps cartSteps;
    CheckoutSteps checkoutSteps;
    ReviewSteps reviewSteps;
    CompleteOrderSteps completeOrderSteps;

    @BeforeClass
    public void innerSetup(){
        loginSteps = new LoginSteps(page);
        dashboardSteps = new DashboardSteps(page);
        productSteps = new ProductSteps(page);
        cartSteps = new CartSteps(page);
        checkoutSteps = new CheckoutSteps(page);
        reviewSteps = new ReviewSteps(page);
        completeOrderSteps = new CompleteOrderSteps(page);
    }

    @Test(priority = 1, description = "Login as standard user")
    public void loginAsStandardUser(){
        loginSteps
                .fillLoginCredentials(Constants.STANDARD_USERNAME, Constants.PASSWORD)
                .logIn();
    }

    @Test(priority = 2, description = "Add item to cart")
    public void addToCart() {
        dashboardSteps.chooseItem();
        productSteps.addItemToCart();
    }

    @Test(priority = 3, description = "Go to cart and validate that item was added")
    public void goToCartAndValidateItem() {
        productSteps.goToCart();
        cartSteps.validateCartSize(1);
    }

    @Test(priority = 4, description = "Proceed to checkout")
    public void checkout() {
        cartSteps.goToCheckout();
    }

    @Test(priority = 5, description = "Fill personal information")
    public void fillPersonalInformation(){
        checkoutSteps
                .fillInformation(FIRSTNAME, LASTNAME, ZIPCODE)
                .goToReviewPage();
    }

    @Test(priority = 6, description = "Validate review page")
    public void validateReviewPageAndFinishOrder(){
        reviewSteps
                .validateItems(1)
                .finishOrder();
    }

    @Test(priority = 7, description = "Validate success of the purchase")
    public void validatePurchaseSuccess() {
        completeOrderSteps.validateOrderCompletion(SUCCESS_MESSAGE);
//        successMessage.shouldHave(Condition.match("Should have certain text",
//                element -> element.getText().equals("Should have certain text")));
    }

}
