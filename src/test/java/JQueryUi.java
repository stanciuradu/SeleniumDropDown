import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JQueryUi extends SeleniumHelper {
    // clasa unde se implementeaza o metoda de test pentru funtionalitatea de hover effect

    @Test
    public void hoverEffectOne() throws InterruptedException {
        driver.get(url + "jqueryui/menu");
        // 1. identific butonul din meniu pentru efectul de hover
        // 1. Hover Effect
        WebElement enableButton = driver.findElement(By.xpath("//li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(enableButton).build().perform();
        // in momentul cand s-a facut hover pe acel buton, exista o fractiunde secunda cand se asteapta pentru a se afisa urmatoarele elemente
        // testarea acestui timp de aspteptare se face prin Thread.sleep
        Thread.sleep(3000);

        // 2. Hover Effect
        WebElement downloadsButton = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/a"));
        action.moveToElement(downloadsButton).build().perform();

    }
}
