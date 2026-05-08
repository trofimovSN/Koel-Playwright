package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import models.User;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    private String url = ConfigReader.get("base.url");

    //locators:
    private final Locator emailField = page.getByPlaceholder("Email Address");
    private final Locator passwordField = page.getByPlaceholder("Password");
    private final Locator submitButton = page.getByText("Log In");

    public LoginPage(Page page) {
        super(page);
    }

    public LoginPage openPage() {
        page.navigate(url);
        return this;
    }


    public LoginPage provideEmail(String email) {
        emailField.fill(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.fill(password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public MainPage login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        return new MainPage(page);
    }

    public MainPage loginAs(User user) {
        return login(user.getEmail(), user.getPassword());
    }

}
