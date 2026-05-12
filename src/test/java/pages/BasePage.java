package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void disableHtml5Validation(String formSelector) {
        page.locator(formSelector).evaluate("form => form.setAttribute('novalidate', '')");
    }

    public Locator getSuccessToast() {
        return page.locator(".success.show");
    }

    public Locator getErrorToast() {
        return page.locator(".error.show");
    }
}




