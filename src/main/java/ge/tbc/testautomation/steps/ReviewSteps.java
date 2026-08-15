package ge.tbc.testautomation.steps;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.ReviewPage;

public class ReviewSteps {
    Page page;
    ReviewPage reviewPage;

    public ReviewSteps(Page page) {
        this.page = page;
        reviewPage = new ReviewPage(page);
    }

    public ReviewSteps validateItems(int expectedSize){
        PlaywrightAssertions.assertThat(reviewPage.itemToBeValidated).hasCount(expectedSize);

        return this;
    }

    public ReviewSteps finishOrder(){
        reviewPage.finishBtn.click();

        return this;
    }
}
