package tests;

import models.User;
import models.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.MainPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class MainPageTests extends BaseTest {


    @Test
    void checkSmartPlayList() {
        User user = UserFactory.mainUser();
        String playListName = "SmartPlayListToDelete";

        MainPage mainPage = new LoginPage(page)
                .openPage()
                .loginAs(user);

        mainPage.createSmartPlaylist(playListName);
        assertThat(mainPage.getSuccessToast()).isVisible();

        mainPage.deletePlayList(playListName);
    }

    @ParameterizedTest
    @MethodSource("utils.TestDataProvider#getPlayListNames")
    void checkPlayListNameParameters(String name, boolean valid) {
        User user = UserFactory.mainUser();
        MainPage mainPage = new LoginPage(page)
                .openPage()
                .loginAs(user);
        try {
            mainPage.createNewPlaylist(name);
            if (valid) {
                assertThat(mainPage.getSuccessToast()).isVisible();
            } else {
                assertThat(mainPage.getSuccessToast()).not().isVisible();
            }
        } finally {
            if (valid) {
                mainPage.deletePlayList(name);
            }
        }
    }
}




