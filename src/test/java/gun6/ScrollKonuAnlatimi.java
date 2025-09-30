package gun6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class ScrollKonuAnlatimi {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://www.selenium.dev/selenium/web/scroll3.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,2500)"); // Sayfayi 500 px asagi kaydirir

        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // Sayfanin en sonuna kaydirir

        WebElement button1 = driver.findElement(By.id("button1"));
        js.executeScript("arguments[0].scrollIntoView(true)", button1);

        BaseDriver.threadWait(3);

        WebElement button2 = driver.findElement(By.id("button2"));
        js.executeScript("arguments[0].scrollIntoView(true)", button2);

        BaseDriver.threadWait(3);
        driver.quit();

    }
}
