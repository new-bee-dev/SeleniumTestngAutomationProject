import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class InfiniteScroll extends  BaseTest{
    @Test
    void testInfiniteScroll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        int i = 0;
        while(i < 10) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);
            i ++;
        }
    }
}
