package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps {
    Page page;
    LoginPage loginPage;

    public LoginSteps(Page page) {
        this.page = page;
        loginPage = new LoginPage(page);
    }

    @Step("Fill login credentials with username: {} and password {}")
    public LoginSteps fillLoginCredentials(String username, String password){
        loginPage.usernameInput.fill(username);
        loginPage.passwordInput.fill(password);

        return this;
    }

    @Step("Log in")
    public LoginSteps logIn(){
        loginPage.loginBtn.click();

        return this;
    }
}
