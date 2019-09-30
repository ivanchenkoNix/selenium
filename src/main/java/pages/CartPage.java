package pages;

import blocks.CartItem;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import io.qameta.htmlelements.element.HtmlElement;

public interface CartPage extends BasePage{

    @FindBy("//div[@class='a-row sc-list-item sc-list-item-border sc-java-remote-feature']")
    ExtendedList<CartItem> cartItem();

    @FindBy("//span[@id='sc-subtotal-amount-activecart']/span")
    HtmlElement subtotalAmountPrice();
}
