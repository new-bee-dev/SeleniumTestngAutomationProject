import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{
    @Test
    void dragDropTest() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement start = driver.findElement(By.id("column-a"));
        WebElement drop = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(start, drop).build().perform();
        driver.findElement(By.cssSelector("#column-a header")).getText().equals("B");
        driver.findElement(By.cssSelector("#column-b header")).getText().equals("A");
    }
}
