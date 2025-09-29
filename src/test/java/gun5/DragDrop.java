package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class DragDrop {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://www.selenium.dev/selenium/web/droppableItems.html");

        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        BaseDriver.threadWait(3);
        // 1. yöntem
        actions.dragAndDrop(kaynak,hedef).perform();

        BaseDriver.threadWait(3);
        driver.quit();

        /** 2. yöntem
        actions.clickAndHold(kaynak)
                .moveToElement(hedef)
                .release()
                .build()// coklu islem yapildigi icin yani birden fazla
                        actions metodu kullandigimdan build() metodunu da kullandik
                .perform();
         */

    }
}
