import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsAlert extends SeleniumHelper {
    // clasa in care vom crea metode de teste pentru partea de alert de JavaScript
    // alertele in JS destinate browserului sunt: alert(), promt()
    // clasa aceasta va mosteni clasa SeleniumHelper pentru partea de cod repetitiv cu privire la set-up
    @Test
    public void clickForJsAlert(){
        driver.get(url + "javascript_alerts");// deschindem browserul pe pagina curenta
        /*
            1. trebuie testat butonul "Click for JS Alert"
            2. trebuie apasat butonul ok pe alerta deschisa dupa apasarea butonului -> "Click for JS Alert"
        */

        // mapez pe element
        WebElement button = driver.findElement(By.xpath("//ul/li/button"));
        button.click(); //testeaz functionalitatea de click pe buton
        // pentru a testa o alerta din Browser, nu mai avem partea de inspect ci, prin Selenium avem urmatoarea metoda:
        Alert alert = driver.switchTo().alert();
        alert.accept();// se accepta alerta din Browser
    }

    @Test
    public void clickForJsConfirm(){
        driver.get(url + "javascript_alerts");// deschindem browserul pe pagina curenta
        WebElement button = driver.findElement(By.xpath("//li[2]/button"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void clickForJsPromt(){
        driver.get(url + "javascript_alerts");// deschindem browserul pe pagina curenta
        WebElement button = driver.findElement(By.xpath("//ul/li[3]/button"));
        button.click();
        Alert promt = driver.switchTo().alert();
        String message = "hello"; // formez un string introdus de la tastatura
        promt.sendKeys(message); // il pasez prin metoda sendKeys
        promt.accept(); //inchid promt-ul

        //trebuie sa daca stringul introdus este corect in concordatnta cu cel afisat -> mesajul de afisare se afla intr-un paragraf cu id-ul result
        //mapez prin acel paragraf si scot textul de acolo
        WebElement paragraf = driver.findElement(By.id("result"));
        System.out.println(paragraf.getText());
        // am identificat paragraful randat -> urmeaza sa compar cu metoda Assert daca stringul introdus in promt este acelasi cu cel randat in cadrul paragrafului de pe UI
        Assert.assertEquals(message,"hello");
    }
}
