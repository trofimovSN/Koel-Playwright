package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfilePage extends BasePage{

    private final Locator profilePageWrapper = page.locator("#profileWrapper .heading-wrapper");

    public ProfilePage (Page page) {
        super(page);
    }

    public Locator getWrapper () {
        return profilePageWrapper;
    }

    public ProfilePage enterCurrentPassword(String password) {
        page.locator("#inputProfileCurrentPassword").fill(password);
        return this;
    }

    public ProfilePage setNewEmail(String email) {
        page.locator("#inputProfileEmail").fill(email);
        return this;
    }

    public ProfilePage clickSaveButton() {
        page.locator(".btn-submit").click();
        return this;
    }
}
