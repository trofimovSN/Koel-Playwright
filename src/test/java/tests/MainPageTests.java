package tests;

import models.User;
import models.UserFactory;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import java.sql.DriverManager;
import java.util.List;

public class MainPageTests extends BaseTest {


//    @Test
//    public void checkSmartPlayList() {
//        String playListName = "SmartPlayListToDelete";
//        String sortCriteria = "Album";
//        String sortEquals = "contains";
//        String sortBy = "Unknown";
//
//        HomePage homePage = new LoginPage(DriverManager.getDriver())
//                .openPage()
//                .loginAsValidUser()
//                .createSmartPlaylist(playListName, sortCriteria, sortEquals, sortBy);
//        Assert.assertTrue(homePage.isPlayListDisplayed(playListName));
//        homePage.deleteSmartPL(playListName);
//    }
//
//    @Test
//    //(dataProvider = "playListNames", dataProviderClass = TestDataProviders.class,
////            description = "Koel | Create New Playlist | Boundary Testing")
//    public void checkPlayListNameParameters(String name, boolean valid) {
//        User user = UserFactory.mainUser();
//        HomePage homePage = new LoginPage(DriverManager.getDriver())
//                .openPage()
//                .loginAs(user);
//        try {
//            homePage.createPlaylist(name);
//            if (valid) {
//                Assert.assertTrue(homePage.isSuccessToastPresent());
//                String toast = homePage.getSuccessToastText();
//                Assert.assertTrue(toast.contains("Created playlist"));
//            } else {
//                Assert.assertFalse(homePage.isSuccessToastPresent(),
//                        "Playlist should NOT be created for name: " + name);
//                Assert
//                        .assertTrue(homePage.isRedFramePresent(),
//                                "Validation border expected");
//            }
//        } finally {
//            try {
//                if (homePage.isPlayListDisplayed(name)) {
//                    homePage.deletePlaylist(name);
//                }
//            } catch (Exception ignored) {
//            }
//        }
//    }
//
//
}
