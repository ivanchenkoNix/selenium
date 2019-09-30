import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.BasePageSteps;

public class BaseTest {

    WebDriver driver;
    BasePageSteps basePageSteps;

    @BeforeClass
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePageSteps = new BasePageSteps(driver);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) driver.quit();
    }
}
