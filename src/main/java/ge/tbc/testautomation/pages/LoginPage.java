package ge.tbc.testautomation.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    public Locator usernameInput;
    public Locator passwordInput;
    public Locator loginBtn;

    public LoginPage(Page page) {
        usernameInput = page.locator("#user-name");
        passwordInput = page.locator("#password");
        loginBtn = page.locator("#login-button");
    }
}
