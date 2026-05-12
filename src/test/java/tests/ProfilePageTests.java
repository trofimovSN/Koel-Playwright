package tests;

import models.User;
import models.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.ProfilePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ProfilePageTests extends BaseTest {

    @Test
    public void profilePageShouldOpen() {
        User user = UserFactory.mainUser();
        ProfilePage profilePage = new LoginPage(page)
                .openPage()
                .loginAs(user)
                .clickUserLink();

        assertThat(profilePage.getWrapper()).containsText("Profile & Preferences");
    }

    @ParameterizedTest
    @MethodSource("utils.TestDataProvider#provideIncorrectEmails")
    void changeEmailValidation(String email, String scenarioDescription) {

        User user = UserFactory.testUser();
        String password = user.getPassword();
        String oldEmail = user.getEmail();
        String invalidEmail = email;
        ProfilePage profilePage = new LoginPage(page)
                .openPage()
                .loginAs(user)
                .clickUserLink();
        try {
            profilePage.disableHtml5Validation("form[data-testid='update-profile-form']");
            profilePage.enterCurrentPassword(password)
                    .setNewEmail(invalidEmail)
                    .clickSaveButton();

            assertAll("Cheking email" + scenarioDescription,
                    () -> assertThat(profilePage.getErrorToast()).isVisible(),
                    () -> assertThat(profilePage.getSuccessToast()).not().isVisible()
            );
        } finally {
            profilePage.enterCurrentPassword(password)
                    .setNewEmail(oldEmail)
                    .clickSaveButton();
            assertThat(profilePage.getSuccessToast()).isVisible();
        }
    }
}
