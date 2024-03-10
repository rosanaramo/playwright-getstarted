import com.microsoft.playwright.*;
import models.GetStartedPage;

import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page page = browser.newPage();
            GetStartedPage getStartedPage = new GetStartedPage(page);
            getStartedPage.navigate();
            getStartedPage.clickGetStarted();
        }
    }
}
