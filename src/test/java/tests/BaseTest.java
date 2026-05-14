package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.ConfigReader;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext browserContext;
    protected Page page;


    @BeforeAll
    static void setUpBrowser() {
        playwright = Playwright.create();

        String browserName = ConfigReader.get("browser").toLowerCase();
        switch (browserName) {
            case "firefox" -> browser = playwright.firefox().launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(false));
            case "webkit" -> browser = playwright.webkit().launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(false));
            default -> browser = playwright.chromium().launch(new BrowserType
                    .LaunchOptions()
                    .setHeadless(false));
        }
    }

    @BeforeEach
    void setUpBrowserContext() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterEach
    void tearDownBrowserContext() {
        if (browserContext != null) {
            browserContext.close();
        }
    }

    @AfterAll
    static void tearDownBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
