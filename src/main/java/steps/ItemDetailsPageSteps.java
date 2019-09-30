package steps;

import org.openqa.selenium.WebDriver;
import pages.ItemDetailsPage;

public class ItemDetailsPageSteps extends BasePageSteps {

    ItemDetailsPageSteps(WebDriver driver) {
        super(driver);
    }

    public CartPageSteps navigateToCart() {
        onPage().cart().click();
        return new CartPageSteps(getWebDriver());
    }

    public ItemDetailsPageSteps addItemToCart() {
        onPage().addToCartButton().click();
        return this;
    }

    private ItemDetailsPage onPage() {
        return on(ItemDetailsPage.class);
    }
}
