package ge.tbc.testautomation.steps;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.ReviewPage;
import io.qameta.allure.Step;

public class ReviewSteps {
    Page page;
    ReviewPage reviewPage;

    public ReviewSteps(Page page) {
        this.page = page;
        reviewPage = new ReviewPage(page);
    }

    @Step("Validate items size. Expected size: {}")
    public ReviewSteps validateItems(int expectedSize){
        PlaywrightAssertions.assertThat(reviewPage.itemToBeValidated).hasCount(expectedSize);

        return this;
    }

    @Step("Finish order")
    public ReviewSteps finishOrder(){
        reviewPage.finishBtn.click();

        return this;
    }
}
