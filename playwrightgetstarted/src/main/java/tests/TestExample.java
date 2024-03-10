package tests;

import com.microsoft.playwright.*;
import models.GetStartedPage;
import org.junit.jupiter.api.*;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class TestExample {
static Playwright playwright;
static Browser browser;
BrowserContext context;
static Page page;
static GetStartedPage getStartedPage;
@BeforeAll
static void launchBrowser(){
    playwright = Playwright.create();
    browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
}
@AfterAll
static void closeBrowser(){
    playwright.close();
}
@BeforeEach
void createContextAndPage(){
    context = browser.newContext();
    page = context.newPage();
    getStartedPage = new GetStartedPage(page);
}
@AfterEach
void  closeContext(){
    context.close();
}
@Test
void shouldValidateIntroductionPage(){
    getStartedPage.navigate();
    getStartedPage.clickGetStarted();
    assertThat(page).hasTitle(Pattern.compile("Installation | Playwright Java"));
}
}
