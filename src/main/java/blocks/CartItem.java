package blocks;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface CartItem extends ExtendedWebElement<CartItem> {

    @FindBy(".//span[@class='a-size-medium sc-product-title a-text-bold']")
    HtmlElement itemName();

}
