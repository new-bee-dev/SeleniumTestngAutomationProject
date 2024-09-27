import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.annotations.Test;

import java.awt.*;

public class HorizontalSlider extends BaseTest{
    @Test
    void testSlider() throws InterruptedException, AWTException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement inputSlider = driver.findElement(By.cssSelector(".sliderContainer input"));
        double i = 0.0;
        double max = 5.0;
        double step = 0.5;
        while(i <= max) {
            inputSlider.sendKeys(Keys.RIGHT);
            i += step;
            Thread.sleep(1000);
        }
    }
}
