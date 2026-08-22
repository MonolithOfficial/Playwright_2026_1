package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.DashboardPage;
import io.qameta.allure.Step;

public class DashboardSteps {
    Page page;
    DashboardPage dashboardPage;

    public DashboardSteps(Page page) {
        this.page = page;
        dashboardPage = new DashboardPage(page);
    }

    @Step("Choose product item")
    public DashboardSteps chooseItem(){
        dashboardPage.item.dispatchEvent("click");

        return this;
    }
}
