import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckboxTest extends  BaseTest{
    @Test
    void testCheckbox() throws InterruptedException {
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//form/input[1]")).click();
        Thread.sleep(2000);
    }
}
