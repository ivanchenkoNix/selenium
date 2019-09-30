package pages;

import blocks.ResultItem;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;

public interface ResultPage extends BasePage {

    @FindBy("//div[@class='s-result-list s-search-results sg-row']/div")
    ExtendedList<ResultItem> resultItem();
}
