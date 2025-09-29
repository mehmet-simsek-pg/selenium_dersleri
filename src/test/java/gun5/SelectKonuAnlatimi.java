package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BaseDriver;

public class SelectKonuAnlatimi {
    /**
     * <select id="country">
     *   <option value="tr">Türkiye</option>
     *   <option value="us">Amerika</option>
     *   <option value="de">Almanya</option>
     * </select>
     *
     * select tag i icin dropdown menüleri örnek verebiliriz.
     * select tag i ile calismak icin Selenium um Select sinifi kullanilir.
     * */
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/dropdowns");

        WebElement dropdownMenu = driver.findElement(By.id("dropdown-menu"));
        Select select = new Select(dropdownMenu);

        // 1. yöntem value ile secmek
        select.selectByValue("Azerbaijan");
/**
        // 2. yöntem index ile secim
        select.selectByIndex(2);

        // 3. yöntem visible text
        select.selectByVisibleText("Austria");
 */

    BaseDriver.threadWait(3);
    driver.quit();
    }
}
