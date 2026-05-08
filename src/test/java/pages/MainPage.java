package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage extends BasePage{

    //Locators:
    private final Locator profileLink = page.getByTestId("view-profile-link");


    public MainPage (Page page) {
        super(page);
    }

    public ProfilePage clickUserLink() {
        profileLink.click();
        return new ProfilePage(page);
    }
}
