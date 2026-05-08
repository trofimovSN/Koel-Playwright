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
}
