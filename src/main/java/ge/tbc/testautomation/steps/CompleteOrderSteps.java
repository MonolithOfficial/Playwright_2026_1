package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.CompleteOrderPage;

public class CompleteOrderSteps {
    Page page;
    CompleteOrderPage completeOrderPage;

    public CompleteOrderSteps(Page page) {
        this.page = page;
        completeOrderPage = new CompleteOrderPage(page);
    }

    public CompleteOrderSteps validateOrderCompletion(String successMessage){
        PlaywrightAssertions.assertThat(completeOrderPage.successMessage).hasText(successMessage);

        return this;
    }
}
