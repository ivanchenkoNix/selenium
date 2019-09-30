import entities.Item;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest {

    @DataProvider(name = "items")
    public static Object[][] itemsToSearch() {
        return new Object[][]{
                {"puzzle"},
                {"sock"},
                {"robe"}
        };
    }

    @Test(dataProvider = "items")
    public void addItemsToCart(String name) {
        Item item = new Item();

        basePageSteps.openHomePage()
                .selectSearchOption("Baby")
                .fillSearchInput(name)
                .clickSearchButton()
                .verifyTitle(name)
                .verifyResultItemsNameRequestedEntry(name)
                .getFirstItemDetails(item)
                .navigateToFirstItemDetailsViaItemName()
                .addItemToCart()
                .navigateToCart()
                .compareItemName(item)
                .compareSubtotalToItemPrice(item);
    }

}
