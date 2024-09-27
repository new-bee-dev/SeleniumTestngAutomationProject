import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Geolocation extends BaseTest{
    @Test
    void testGeolocation() {
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.cssSelector(".example button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
            Assert.assertNotNull(driver.findElement(By.id("lat-value")).getText());
            Assert.assertNotNull(driver.findElement(By.id("long-value")).getText());
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
            Assert.assertNotNull(driver.findElement(By.id("lat-value")).getText());
            Assert.assertNotNull(driver.findElement(By.id("long-value")).getText());
        }


    }
}
