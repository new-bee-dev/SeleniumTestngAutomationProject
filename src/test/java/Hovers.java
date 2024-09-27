import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Hovers extends BaseTest{
    @Test
    void testHover() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.cssSelector(".figure"));
        Actions actions = new Actions(driver);

        for (WebElement element : elements) {
            actions.moveToElement(element.findElement(By.tagName("img"))).perform();
            Thread.sleep(2000);
            Assert.assertTrue(element.findElement(By.cssSelector(".figcaption h5")).isDisplayed());
        }
    }
}
