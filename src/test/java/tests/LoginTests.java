package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class LoginTests extends BaseTest {
    @Test
    void shouldShowLoginPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.openPage();

        assertThat(page.locator(".logo")).isVisible();
    }

    @Test
    void shouldLogin() {
        var profileLink = page.getByTestId("view-profile-link");
        LoginPage loginPage = new LoginPage(page);
        loginPage.openPage()
                .provideEmail(ConfigReader.get("user.email"))
                .providePassword(ConfigReader.get("user.password"))
                .clickSubmit();

        assertThat(profileLink).isVisible();
    }



}
