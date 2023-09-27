import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown extends SeleniumHelper {
    // clasa care testeaza functionalitatea unui dropdown si mosteneste clasa Selenium Helper

    @Test
    public void dropDown() {
        driver.get(url + "dropdown");

        //Instantiez un nou obiect de tip select pentru a gasi elementul dropdown
        Select select = new Select(driver.findElement(By.id("dropdown")));

        //Metodele de selectare a informatiilor din dropdown sunt:
        //By value
        select.selectByValue("2"); //se selecteaza optiunea cu valoarea 2

        //By index
        select.selectByIndex(1);// optiunea cu valoarea 1 este afisata pe ecran

        //By visible Text
        select.selectByVisibleText("Option 2"); // selectez optiunea cu content-ul Option2

    }
}
