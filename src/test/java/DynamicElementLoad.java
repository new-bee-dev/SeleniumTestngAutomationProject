import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicElementLoad extends BaseTest{
    @Test
    void testHiddenElement() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnStart = driver.findElement(By.cssSelector("#start:nth-of-type(1) button"));
        WebElement message = driver.findElement(By.cssSelector("#finish h4"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertFalse(message.isDisplayed());
        btnStart.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(message.getText(), "Hello World!");
    }

    @Test
    void testElementRenderedAfterClick() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement btnStart = driver.findElement(By.cssSelector("#start:nth-of-type(1) button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        btnStart.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#finish h4"))));
        Assert.assertEquals(driver.findElement(By.cssSelector("#finish h4")).getText(), "Hello World!");
    }
}
