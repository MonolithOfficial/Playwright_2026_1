package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.DashboardPage;

public class DashboardSteps {
    Page page;
    DashboardPage dashboardPage;

    public DashboardSteps(Page page) {
        this.page = page;
        dashboardPage = new DashboardPage(page);
    }

    public DashboardSteps chooseItem(){
        dashboardPage.item.dispatchEvent("click");

        return this;
    }
}
