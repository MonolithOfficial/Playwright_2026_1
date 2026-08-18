package ge.tbc.testautomation.tests;

import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AssertionTests extends BaseTest {
    @Test
    public void testHomePageTitle() {
        assertThat(page).hasTitle("Practice Software Testing | Home");
    }

    @Test
    public void testHeaderLogoIsVisible() {
        Locator logo = page.locator("img[alt='Practice Software Testing']");
        assertThat(logo).isVisible();
    }

    @Test(description = "check if list of checkboxes contains Hammer and Wrench entries")
    public void testListAssertion() {
        Locator allCheckBoxDivs = page.locator("//div[@class='checkbox']//ul//div");
        assertThat(allCheckBoxDivs).containsText(new String[]{"Hammer", "Wrench"});
    }
}
