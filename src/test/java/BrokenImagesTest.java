import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BrokenImagesTest extends BaseTest{
    @Test
    void brokenImagesTest() throws IOException {
        driver.findElement(By.linkText("Broken Images")).click();
        driver.findElement(By.cssSelector(".example h3")).getText().equals("Broken Images");
        int count = 0;

        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));
        for(WebElement image : images) {
            String linkAddr = image.getAttribute("currentSrc");
            System.out.println(linkAddr);
            if (linkAddr != null) {
                CloseableHttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(linkAddr);
                HttpResponse response = client.execute(request);
                if (response.getStatusLine().getStatusCode() != 200) {
                    System.out.println("Link: " + linkAddr + "is found broken!");
                    count ++;
                }
            }
        }
        System.out.println("number of links found broken: " + count);
    }
}
