import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DisappearingElements extends BaseTest{

    @Test
    void checkElementVisibility() throws InterruptedException {
        driver.findElement(By.linkText("Disappearing Elements")).click();
        WebElement btnGallery = driver.findElement(By.xpath("//a[contains(text(),'Gallery')]"));
        Thread.sleep(3000);
        Assert.assertTrue(btnGallery.isDisplayed());
    }
}
