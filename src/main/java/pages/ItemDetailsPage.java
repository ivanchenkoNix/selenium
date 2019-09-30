package pages;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;

public interface ItemDetailsPage extends BasePage {

    @FindBy("//input[@id='add-to-cart-button']")
    HtmlElement addToCartButton();

}
