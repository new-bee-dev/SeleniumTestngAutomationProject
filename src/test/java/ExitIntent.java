import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ExitIntent extends BaseTest{

    @Test
    void testExitIntent() throws AWTException, InterruptedException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");
        WebElement intent = driver.findElement(By.className("example"));
        Actions actions = new Actions(driver);
        actions.moveToLocation(650, 50).perform();
        Thread.sleep(3000);
        WebElement modalTitle = driver.findElement(By.cssSelector(".modal div:nth-of-type(1)"));
        Assert.assertEquals(modalTitle.getText(), "This is a modal window");
    }
}
