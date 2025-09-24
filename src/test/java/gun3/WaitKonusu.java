package gun3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class WaitKonusu {
    public static void main(String[] args) {
        /**
         * 1. Implicit wait
         * Tüm driver a tanimlanir.
         * Belirtilen süre boyunca element bulunana kadar bekler.
         * Bir kez ayarladiktan sonra driver kapanana kadar calisir.
         * Dezavantaji -> Tüm elementler icin calisir, gereksiz yere testleri yavaslatabilir.
         *
         * 2. Explicit wait
         * Sadece belirli bir web element icin bekleme yapar.
         * WebDriverWait + ExpectedConditions birlikte kullanir.
         * Elemet bulunursa belirtilen süreyi beklemez.
         *
         * visibilityOf -> element görünür olana kadar bekle
         * elementToBeClickable -> tiklanabilir olana kadar bekle
         * textToBePresentInElement -> belirli bir yazi cikana kadar bekle
         * presenceOfElementLocated -> DOM'da görünür olana kadar bekle
         * */

        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement productsBtn = driver.findElement(By.cssSelector("a[href='/products']"));
        wait.until(ExpectedConditions.elementToBeClickable(productsBtn));
        productsBtn.click();

        WebElement allProductText = driver.findElement(By.cssSelector(".features_items>h2"));
        wait.until(ExpectedConditions.visibilityOf(allProductText));
        // wait icin 29. satirda 30 saniye olarak bekleme süresini belirttik. Eger elementi bulursa
        // 30 saniye beklemez, yoksa 30 saniye bekler yine de bulamazsa hata verir.

        String expectedText = "ALL PRODUCTS";
        String actualText = allProductText.getText();

        Assert.assertEquals("Yanlis sayfa acildi", expectedText, actualText);

        // 43. satirda eger hata verirse ki buna Runtime Exception diyoruz, bundan sonra alt satirlari okumaz
        driver.quit();
    }
}
