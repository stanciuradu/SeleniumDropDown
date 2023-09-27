import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ExercitiiCurs7Second extends SeleniumHelper {
    /*
        3)
        Access : http://kevinlamping.com/webdriverio-course-content/index.html#
        Select "See our vast robot selection"
        Insert a correct email address in the "Add a review" section
        Don't insert anything in the product field area
    */
    @Test
    public void validateEmailAddress() {
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        // mapam prin butonul 'See our vast robot selection'
        WebElement productPageLink = driver.findElement(By.xpath("//div[3]/a"));
        productPageLink.click();
        // mapam prin inputul de tip email
        WebElement inputEmail = driver.findElement(By.id("review-email"));
        String myEmailAddress = "radunicolaestanciu2020@gmail.com";
        inputEmail.sendKeys(myEmailAddress);
        // mapam pe butonul submit
        WebElement submitButton = driver.findElement(By.id("comment-form"));
        submitButton.click();
    }
    /*2)
            Access : http://kevinlamping.com/webdriverio-course-content/index.html#
            From the “Our Products” dropdown, select any option.
            Insert an incorrect email address in the "Add a review" section
            Validate an error message is displayed
    */
    @Test
    public void validateErrorMessage(){
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        //Select select = new Select(driver.findElement(By.xpath("//ul/li[2]/a[@tabindex='0']")));
        WebElement dropdown = driver.findElement(By.xpath("//ul/li[2]/a[@tabindex='0']"));
        Actions action = new Actions(driver);
        action.moveToElement(dropdown).build().perform(); // la hover effect selectul nu functioneaza
        WebElement firstLink = driver.findElement(By.xpath("//div[1]/ul/li[2]/ul/li[1]/a"));
        firstLink.click();
        WebElement inputEmail = driver.findElement(By.id("review-email")); // am selectat campul de email pt a introduce adresa
        String wrongEmailAddress = "miha.nicolae@";
        inputEmail.sendKeys(wrongEmailAddress);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"comment-form\"]/button"));
        submitButton.click();
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"comment-form\"]/label[1]")).getText();
        System.out.println("Mesajul de eroare este: " +errorMessage);
        Assert.assertEquals(errorMessage, "Please enter a valid email address.");

    }

    /*
    4)
            Access : http://kevinlamping.com/webdriverio-course-content/index.html#
            Select "See our vast robot selection"
            Select "Similar products"
            Verify the price for "Totally Evil Robot" is $15
    */
    @Test
    public void similarProducts(){
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        WebElement productPageLink = driver.findElement(By.xpath("//div[3]/a"));
        productPageLink.click();
        WebElement similarProducts = driver.findElement(By.id("panel2-label"));
        similarProducts.click();
        String headingRobot = driver.findElement(By.xpath("//*[@id=\"panel2\"]/div/div[3]/h5")).getText();
        System.out.println(headingRobot);
        String priceRobot = "$15";
        System.out.println(headingRobot.contains(priceRobot));
        Assert.assertEquals(headingRobot.contains(priceRobot),true);
    }

    /*
           5)
           Access : http://kevinlamping.com/webdriverio-course-content/index.html#
           Hover over "Our Products"
           Select "Dr. Noonian Soong's Emotion Chip"
           Verify the URL has changed to "http://www.kevinlamping.com/webdriverio-coursecontent/
           product-page.html"
    */
    @Test
    public void changeURL(){
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        WebElement dropdown = driver.findElement(By.xpath("//ul/li[2]/a[@tabindex='0']"));
        Actions action = new Actions(driver);
        action.moveToElement(dropdown).build().perform(); // la hover effect selectul nu functioneaza
        WebElement secondLink = driver.findElement(By.xpath("//div[1]/ul/li[2]/ul/li[3]/a"));
        secondLink.click();
        String url ="http://www.kevinlamping.com/webdriverio-course-content/product-page.html";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    /*
        6)
        Access : http://kevinlamping.com/webdriverio-course-content/index.html#
        Wait until the picture changes
        Verify that a different pictures is presented (and not the first)
        --> Tema
    */
    @Test
    public void pictures() {
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        WebElement picture1 = driver.findElement(By.xpath("//img[@ src='images/robot-5.jpg']"));
        WebElement picture2 = driver.findElement(By.xpath("//img[@ src='images/robot-6.jpg']"));
        WebElement picture3 = driver.findElement(By.xpath("//img[@ src='images/robot-1.jpg']"));
        WebElement picture4 = driver.findElement(By.xpath("//img[@ src='images/robot-3.jpg']"));
        String[] pictures = {String.valueOf(picture1), String.valueOf(picture2), String.valueOf(picture3), String.valueOf(picture4)};
        // trebuie sa verifici daca o imagine diferita este stocata in array sau nu
        for (int i = 1; i < pictures.length - 1; i++) {
            if (String.valueOf(picture1).contains(pictures[i])) {
                System.out.println(picture1);
            } else if (String.valueOf(picture2).contains(pictures[i])) {
                System.out.println(picture2);
            } else if (String.valueOf(picture3).contains(pictures[i])) {
                System.out.println(picture3);
            } else if (String.valueOf(picture4).contains(pictures[i])) {
                System.out.println(picture4);
            } else
                System.out.println("Imaginea nu este stocata in array");
        }
    }
    // metoda cu liste
    @Test
    public void ex6() throws InterruptedException {
        driver.get("http://kevinlamping.com/webdriverio-course-content/index.html#");
        // vrem sa mapam imaginile
        List<WebElement> listaPoze = driver.findElements(By.xpath("//*[@ class='orbit-slide.is-active']//img"));
        //lista de poze este o lisatd e obiectele de tip WebElement
        for (int i=0; i<listaPoze.size(); i++){
            System.out.println("Elementul din lista de la indexul [" + i +"] este" + listaPoze.get(i).getAttribute("src"));
        }
        Assert.assertEquals(driver.findElement(By.xpath("//*[@ class='orbit-slide.is-active']//img")), listaPoze.get(0).getAttribute("src"));
        Thread.sleep(7000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@ class='orbit-slide.is-active']//img")), listaPoze.get(1).getAttribute("src"));
    }
}
