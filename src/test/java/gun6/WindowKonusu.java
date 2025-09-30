package gun6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.Set;

public class WindowKonusu {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");

        WebElement link = driver.findElement(By.xpath("//p/a"));
        link.click();

        String ilkPencere = driver.getWindowHandle(); // Her pencerenin kendine ait benzersiz bir id si vardir.
        // Bu satirda ilk pencerenin id sini bulduk
        System.out.println(ilkPencere);

        Set<String> tumPencereler = driver.getWindowHandles(); // Acilan tüm pencerelerin id sini bulduk

        for(String window : tumPencereler) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals("Simple Page")) {
                break;
            }
        }
        WebElement text = driver.findElement(By.xpath("//div"));
        System.out.println(text.getText());

        BaseDriver.threadWait(3);
        driver.quit();
    }
}
