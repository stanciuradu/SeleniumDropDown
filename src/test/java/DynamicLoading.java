import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoading extends SeleniumHelper{
    // clasa care mosteneste clasa parinte Selenium Helper
    // implemntam o metoda de test care testeaza functionaliztatea de asteptare
    @Test
    public void dynamic1() throws InterruptedException {
        driver.get(url+"dynamic_loading");
        WebElement link = driver.findElement(By.xpath("//div[2]/div/div/a"));
        link.click();
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Thread.sleep(5000);
        /*
                Tipuri de wait:
                1. Wait-ul implicit din Java - Thread.sleep
                 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// manage = metoda prin care manipulam browserul
                2. Wait-ul din selenium
        */
    }
    @Test
    public void seleniumExplicit(){
        driver.get(url+"dynamic_loading");
        WebElement link = driver.findElement(By.xpath("//div[2]/div/div/a"));
        link.click();
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        //creare de obiect de tip webdriver wait cu o durata de 10 sa astepte pana cand conditia vizibilitatii elementului sa fie gata
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.println(driver.findElement(By.id("finish")));
    }
}
