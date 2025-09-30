package gun6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class AlertKonusu {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/alerts");

        WebElement alertButton = driver.findElement(By.id("alert-btn"));
        alertButton.click();

        BaseDriver.threadWait(3);
        Alert alert = driver.switchTo().alert();
        alert.accept(); // Tamam butonuna basmis oluruz

        BaseDriver.threadWait(3);
        WebElement confirmButton = driver.findElement(By.id("confirm-btn"));
        confirmButton.click();

        BaseDriver.threadWait(3);
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss(); // iptal butonuna basmis oluruz

        // alert.sendKeys("Hello Alert");

        BaseDriver.threadWait(3);
        driver.quit();
    }
}
