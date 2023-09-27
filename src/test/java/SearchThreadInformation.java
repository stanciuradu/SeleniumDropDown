import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Scanner;

public class SearchThreadInformation extends SeleniumHelper {
    // clasa care cauta automat pe google informatii despre Thread in Java

    // metoda de test
    @Test
    public void threadInformation() throws InterruptedException {
        /*
            1. deschizi broserul
            2. introduci in search stringul "Thread in Java"
            3. apasare enter
        */
        driver.get("http://www.google.com/"); //deschidem browserul
        WebElement cookiesButton = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        cookiesButton.click();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        String message = "Thread in Java";
        searchInput.sendKeys(message);
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement secondGoogleLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3"));
        secondGoogleLink.click();
        WebElement acceptAllButton = driver.findElement(By.id("accept-choices"));
        acceptAllButton.click();
    }
}
