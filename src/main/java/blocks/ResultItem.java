package blocks;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.HtmlElement;

public interface ResultItem extends ExtendedWebElement<ResultItem> {

    @FindBy(".//span[@class='a-size-base-plus a-color-base a-text-normal']")
    HtmlElement itemName();

    @FindBy(".//span[@class='a-price']")
    HtmlElement itemPrice();
}
