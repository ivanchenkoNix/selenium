package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import props.Properties;

public class BasePageSteps extends WebDriverSteps {


    public BasePageSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public BasePageSteps openHomePage() {
        getWebDriver().get(Properties.props.serviceUrl());
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

    public ResultPageSteps clickSearchButton() {
        onPage().searchButton().click();
        return new ResultPageSteps(getWebDriver());
    }

    private BasePage onPage() {
        return on(BasePage.class);
    }
}
