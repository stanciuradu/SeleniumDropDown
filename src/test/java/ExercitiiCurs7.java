import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExercitiiCurs7 extends SeleniumHelper {
    /*
        Access : http://kevinlamping.com/webdriverio-course-content/index.html#
        Select "See our vast robot selection"
        Choose robot model "HAL"
        Buy 14 pieces
        Verify the correct amount of robots have been bought
    */

    @Test
    public void checkRobot() throws InterruptedException {
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        WebElement productPageLink = driver.findElement(By.xpath("//div[3]/a"));
        productPageLink.click();
        //avem un input de tip select => selectam informatia dupa valoare
        Select select = new Select(driver.findElement(By.id("robotType"))); // deci am selectat inputul de tip select
        select.selectByValue("hotdog");
        WebElement quantityInput = driver.findElement(By.id("qty"));
        String numerOfRobots = "14";
        quantityInput.sendKeys(numerOfRobots);
        WebElement buttonBuyNow = driver.findElement(By.id("buyNowButton"));
        buttonBuyNow.click();
        Thread.sleep(3000);
        // trebuie sa verific daca numarul de roboti cumparati este corect
        // trebuie sa identific paragraful cu randarea mesajului
        String paragraf = driver.findElement(By.xpath("//div[3]/div[2]/div[2]")).getText();
        //cand trebuie sa selectez un paragraf intreg - il definesc prin String
        System.out.println(paragraf); // afisam in consola paragraful
        System.out.println(paragraf.contains(numerOfRobots));// afisam in consola paragraful care contine numarul de roboti
        Assert.assertEquals(paragraf.contains(numerOfRobots),true);
    }
}
