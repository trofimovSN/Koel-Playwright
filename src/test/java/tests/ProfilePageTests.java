package tests;

import models.User;
import models.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProfilePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


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

//    @Test
////    dataProvider = "EmailChangeNegativeScenarios", dataProviderClass = TestDataProviders.class,
////            description = "Koel | Update email | Change email validation scenarios")
//    public void changeEmailValidation(String email, String scenarioDescription) {
//        SoftAssert soft = new SoftAssert();
//        User user = UserFactory.mainUser();
//        String password = user.getPassword();
//        String oldEmail = user.getEmail();
//        String invalidEmail = email;
//        ProfilePage profilePage = new LoginPage(DriverManager.getDriver())
//                .openPage()
//                .loginAs(user)
//                .getProfile()
//                .currentPass(password)
//                .disableHtml5Validation();
//        profilePage.setNewEmail(invalidEmail);
//        soft.assertFalse(profilePage.qucickSuccessCheck()
//                .contains("update"), "Invalid Email "
//                + scenarioDescription + " has been accepted");
//        soft.assertTrue(profilePage
//                        .isErrorMessageDisplayed(),
//                "Error message not displayed for" + scenarioDescription);
//        profilePage.currentPass(password)
//                .setNewEmail(oldEmail);
//        Assert.assertTrue(profilePage.getSuccessMessage().contains("updated"));
//        soft.assertAll();
//    }
}
