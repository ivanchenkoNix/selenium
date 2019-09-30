package steps;

import entities.Item;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CartPageSteps extends BasePageSteps {

    public CartPageSteps(WebDriver driver) {
        super(driver);
    }

    public CartPageSteps compareSubtotalToItemPrice(Item item) {
        assertThat(item.getItemPrice(),equalTo(onPage().subtotalAmountPrice().getText()));
        return this;
    }

    public CartPageSteps compareItemName(Item item) {
        String itemName = onPage().cartItem().get(0).itemName().getText();
        assertThat(item.getItemName(),equalTo(itemName));
        return this;
    }

    private CartPage onPage() {
        return on(CartPage.class);
    }
}
