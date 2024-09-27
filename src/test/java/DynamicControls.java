import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControls extends BaseTest{

    @Test
    void testDynamicControl() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        WebElement btnRemoveAdd = driver.findElement(By.xpath("//form[1]/button"));
        WebElement checkbox = driver.findElement(By.xpath("//form[1]//input"));
        WebElement message;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (btnRemoveAdd.getText().equals("Add")) {
            btnRemoveAdd.click();
            wait.until(ExpectedConditions.visibilityOf(checkbox));
            message = driver.findElement(By.cssSelector("#checkbox-example:nth-of-type(1) #message"));
            Assert.assertEquals(message.getText(), "It's back!");
            Assert.assertEquals(btnRemoveAdd.getText(), "Remove");
        } else {
            btnRemoveAdd.click();
            wait.until(ExpectedConditions.invisibilityOf(checkbox));
            message = driver.findElement(By.cssSelector("#checkbox-example:nth-of-type(1) #message"));
            Assert.assertEquals(message.getText(), "It's gone!");
            Assert.assertEquals(btnRemoveAdd.getText(), "Add");
        }
    }
}
