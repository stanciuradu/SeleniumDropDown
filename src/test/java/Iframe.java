import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Iframe extends SeleniumHelper{
    // metoda de test care testeaza un iFrame

    @Test
    public void iFrame() throws InterruptedException {
        driver.get(url + "iframe");
        // afisam headingul -> String ca variabila, deoarece este doar un string ca si tip de data
        String heading = driver.findElement(By.tagName("h3")).getText();
        System.out.println(heading);
        /*
            un user vrea sa completeze continutul acestui iFrame
            pentru a se completa avem:
            1. driver.switch.frame(mce_0_ifr) -> tagul <iframe></iframe> are id-ul "mce_0_ifr"
            2. selectam cu copy textul deja randat in paragraful din ifram
            3. scriem un nou mesaj in iframe
        */
        driver.switchTo().frame("mce_0_ifr");
        String paragraph = driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
        System.out.println(paragraph);
        // cum scrii peste un text deja randata? selectezi textul cu webelement si ii dai sendKeys(Keys.ctrl+a)
        WebElement container = driver.findElement(By.id("tinymce"));
        container.sendKeys(Keys.CONTROL+"a"); //Keys.control + a este pentru comanda de copiere de text
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("I am wrinting inside a frame");
    }
}
