package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class ActionsKonuAnlatimiDoubleClick {
    /**
     * Fareyi bir elementin üzerine götürme (hover)
     * Sağ tık (contextClick)
     * Çift tık (doubleClick)
     * Sürükle-bırak (dragAndDrop)
     * Klavye kısayolları (CTRL + A, CTRL + C vs.)
     * */

    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/double-click");

        Actions actions = new Actions(driver);

        WebElement doubleClickButton = driver.findElement(By.id("double-click-btn"));
        actions.doubleClick(doubleClickButton).perform();
        // yapilacak islemleri tanimladiktan sonra
        // en son perform() metodu kullanilmali yoksa islem yapmaz

        BaseDriver.threadWait(3);
        driver.quit();
    }

}
