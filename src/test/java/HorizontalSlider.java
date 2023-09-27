import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HorizontalSlider extends SeleniumHelper{
    @Test
    public void scrollFunctionality(){
        driver.get(url + "horizontal_slider");
        //mapez pe element
        WebElement inputField = driver.findElement(By.tagName("input"));
        Actions action = new Actions(driver);
        /*
            1. dau click pe element
            2. dau scroll la dreapta
        */
        //action.click(inputField).sendKeys(Keys.ARROW_RIGHT).build().perform();
        for (int i =1; i <8; i ++){
            action.click(inputField).sendKeys(Keys.ARROW_RIGHT).perform();
            System.out.println("Am apasat sageata dreapta de " + i+"ori!");
        }
    }
}
