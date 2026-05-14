package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

import java.util.regex.Pattern;

public class MainPage extends BasePage {

    //Locators:
    private final Locator profileLink = page.getByTestId("view-profile-link");


    public MainPage(Page page) {
        super(page);
    }

    public ProfilePage clickUserLink() {
        profileLink.click();
        return new ProfilePage(page);
    }

    public MainPage createNewPlaylist(String name) {

        page.getByTestId("sidebar-create-playlist-btn").click();
        page.getByTestId("playlist-context-menu-create-simple").click();
        this.disableHtml5Validation("form[name='create-simple-playlist-form']");
        page.getByPlaceholder("↵ to save").fill(name);
        page.keyboard().press("Enter");
        return this;
    }

    public MainPage createSmartPlaylist(String playListName) {
        Locator createButton = page.getByTestId("sidebar-create-playlist-btn");
        createButton.isVisible();
        createButton.click();
        page.getByTestId("playlist-context-menu-create-smart").click();
        page.locator("input[name='name']").fill(playListName);
        page.locator(".remove-rule").click();
        page.locator("footer button[type='submit']").click();
        return this;
    }

    public void deletePlayList(String name) {
        page.locator("#playlists").getByText(name, new Locator.GetByTextOptions().setExact(true))
                .click(new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT));
        page.getByTestId(Pattern.compile("playlist-context-menu-delete-.*")).click();
    }

}
