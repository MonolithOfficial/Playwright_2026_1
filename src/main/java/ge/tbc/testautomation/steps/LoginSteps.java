package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LoginPage;

public class LoginSteps {
    Page page;
    LoginPage loginPage;

    public LoginSteps(Page page) {
        this.page = page;
        loginPage = new LoginPage(page);
    }

    public LoginSteps fillLoginCredentials(String username, String password){
        loginPage.usernameInput.fill(username);
        loginPage.passwordInput.fill(password);

        return this;
    }

    public LoginSteps logIn(){
        loginPage.loginBtn.click();

        return this;
    }
}
