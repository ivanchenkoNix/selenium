package steps;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverSteps {

    private WebDriver webDriver;

    public WebDriverSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    WebDriver getWebDriver() {
        return webDriver;
    }

    protected <T extends WebPage> T on(Class<T> pageClass) {
        return new WebPageFactory().get(getWebDriver(), pageClass);
    }
}
