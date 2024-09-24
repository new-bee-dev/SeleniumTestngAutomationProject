import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HerokuBasicAuthTest extends BaseTest{
    // Tests to automate login alert pop up in heroku test app

    @Test
    void testBasicAuthUsingUrl() {
        String authUrl = "https://admin:admin@the-internet.herokuapp.com//basic_auth";
        driver.get(authUrl);
        WebElement titleHome = driver.findElement(By.cssSelector(".example h3"));
        titleHome.getText().equals("Basic Auth");
    }

}
