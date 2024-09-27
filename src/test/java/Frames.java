import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames extends BaseTest{
    @Test
    void testNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.getPageSource().contains("LEFT"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.getPageSource().contains("MIDDLE"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
        Assert.assertTrue(driver.getPageSource().contains("RIGHT"));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.getPageSource().contains("BOTTOM"));
    }
}
