package models;
import com.microsoft.playwright.*;
public class GetStartedPage {
    private final Page page;
    private final Locator btnGetStarted;

    public GetStartedPage(Page page) {
        this.page = page;
        this.btnGetStarted = page.getByText("Get started");
    }
    public void navigate(){
        page.navigate("https://playwright.dev/java/");
    }
    public void clickGetStarted(){
        btnGetStarted.click();
    }
}

