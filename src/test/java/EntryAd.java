import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

public class EntryAd extends BaseTest{
    @Test
    void testEntryAd() throws AWTException, InterruptedException {
        driver.findElement(By.linkText("Entry Ad")).click();
        WebElement btnClose = driver.findElement(By.cssSelector(".modal div:nth-of-type(3)"));
        Point btnLocation = btnClose.getLocation();
        Robot robot = new Robot();
        robot.mouseMove(btnLocation.x, btnLocation.y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);

    }
}
