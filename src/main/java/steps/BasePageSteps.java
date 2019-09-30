package steps;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BasePageSteps {

    private WebDriver webDriver;
    private static final String PROJECT_URL = "https://www.amazon.com";

    public BasePageSteps(WebDriver driver) {
        this.webDriver = driver;
    }

    WebDriver getWebDriver() {
        return webDriver;
    }

    public BasePageSteps openHomePage() {
        getWebDriver().get(PROJECT_URL);
        return this;
    }

    public BasePageSteps selectSearchOption(String option) {
        onPage().searchOption().click();
        onPage().selectSearchOption(option).click();
        return this;
    }

    public BasePageSteps fillSearchInput(String text) {
        onPage().searchInput().sendKeys(text);
        return this;
    }

    public ResultPageSteps clickSearchButton(){
        onPage().searchButton().click();
        return new ResultPageSteps(getWebDriver());
    }

    protected <T extends WebPage> T on(Class<T> pageClass) {
        return new WebPageFactory().get(getWebDriver(), pageClass);
    }

    private BasePage onPage() {
        return on(BasePage.class);
    }
}
