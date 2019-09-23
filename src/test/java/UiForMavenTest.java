
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UiForMavenTest extends BaseTest{

    @DataProvider(name = "items")
    public static Object[][] itemsToSearch() {
        return new Object[][]{
                {"puzzle"},
                {"sock"},
                {"robe"}
        };
    }

    @Test(dataProvider = "items")
    public void testAmazonAll(String name) {

        driver.get("https://www.amazon.com");

        WebElement searchOptions = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        searchOptions.click();

        WebElement babyValue = driver.findElement(By.xpath("//option[text()='Baby']"));
        babyValue.click();

        WebElement searchField = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchField.sendKeys(name);

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();

        assert (driver.getTitle().contains(name));

        WebElement itemName = driver.findElement(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div[1]//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        WebElement itemPrice = driver.findElement(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div[1]//span[@class='a-price']"));

        String itemNameText = itemName.getText();
        String itemPriceText = itemPrice.getText();

        itemName.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCartButton.click();

        WebElement userCart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
        userCart.click();

        WebElement cartItemName = driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
        String cartItemNameText = cartItemName.getText();

        WebElement subtotalPrice = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']/span"));
        String subtotalPriceText = subtotalPrice.getText();

        assertThat(itemNameText, equalTo(cartItemNameText));
        assertThat(itemPriceText,equalTo(subtotalPriceText));
    }
}
