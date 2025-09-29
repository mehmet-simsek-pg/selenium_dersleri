package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;

public class SelectMultiple {
    /**
     * Eğer <select multiple> özelliği varsa birden fazla seçenek seçilebilir
     * */

    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://www.selenium.dev/selenium/web/selectPage.html");

        WebElement menu = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        Select select = new Select(menu);

        select.selectByVisibleText("Roquefort");
        select.selectByVisibleText("Parmigiano");

        BaseDriver.threadWait(3);

        select.deselectAll();

        BaseDriver.threadWait(3);
        driver.quit();
    }
}
