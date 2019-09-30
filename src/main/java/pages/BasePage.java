package pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import io.qameta.htmlelements.element.HtmlElement;

public interface BasePage extends WebPage {

    @FindBy("//a[@id='nav-cart']")
    HtmlElement cart();

    @FindBy("//select[@class='nav-search-dropdown searchSelect']")
    HtmlElement searchOption();

    @FindBy("//option[text()='{{ item }}']")
    HtmlElement selectSearchOption(@Param("item") String item);

    @FindBy("//input[@value='Go']")
    HtmlElement searchButton();

    @FindBy("//*[@id='twotabsearchtextbox']")
    HtmlElement searchInput();

    @FindBy("//a[@id='nav-cart']")
    HtmlElement userCart();

}
