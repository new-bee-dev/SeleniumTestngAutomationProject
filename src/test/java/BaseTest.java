import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

//    @BeforeSuite
//    void setUp() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/resources/drivers/chromedriver");
//        driver = new ChromeDriver();
//    }

    @BeforeClass
    void launchHerokuApp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterClass
    void closeBrowser() {
        driver.close();
    }

    @AfterSuite
    void tearDown() {
        driver.quit();
    }
}
