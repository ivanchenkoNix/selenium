package steps;

import entities.Item;
import org.openqa.selenium.WebDriver;
import pages.ResultPage;

import static org.hamcrest.MatcherAssert.assertThat;


public class ResultPageSteps extends BasePageSteps {

    ResultPageSteps(WebDriver driver) {
        super(driver);
    }

    public ResultPageSteps verifyTitle(String text) {
        assertThat("It is not a requested entry", onPage().getWrappedDriver().getTitle().contains(text));
        return this;
    }

    public ItemDetailsPageSteps navigateToFirstItemDetailsViaItemName() {
        onPage().resultItem().get(0).itemName().click();
        return new ItemDetailsPageSteps(getWebDriver());
    }

    public ResultPageSteps getFirstItemDetails(Item item) {
        item.setItemName(getItemName(0));
        item.setItemPrice(getPrice(0));
        System.out.println(item.toString());
        return this;
    }

    public ResultPageSteps verifyResultItemsNameRequestedEntry(final String text) {

        onPage().resultItem().forEach(e ->
                assertThat("Requested entry is not present in item name", e.itemName().getText().toLowerCase().contains(text)));

        return this;
    }

    private String getItemName(int index) {
        return onPage().resultItem().get(index).itemName().getText();
    }

    private String getPrice(int index) {
        return onPage().resultItem().get(index).itemPrice().getText();
    }

    private ResultPage onPage() {
        return on(ResultPage.class);
    }
}
