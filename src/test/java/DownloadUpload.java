import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DownloadUpload extends BaseTest{
    @Test
    void testDownload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        String fileToDownload = "file.png";
        String dir_download = "/Users/agrkriti/Downloads";
        File dir = new File(dir_download);
        List<WebElement> links = driver.findElements(By.cssSelector(".example a"));
        for(WebElement link : links) {
            System.out.println(link.getText());
            if (link.getText().equals(fileToDownload)) {
                link.click();
                Thread.sleep(3000);
                break;
            }
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.getName().equals(fileToDownload)) {
                System.out.println("File downloaded successfully!");
                Assert.assertTrue(true, "File downloaded successfully!");
                break;
            }
        }
    }

    @Test
    void testUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("/Users/agrkriti/Downloads/test.txt");
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "test.txt");
    }
}
