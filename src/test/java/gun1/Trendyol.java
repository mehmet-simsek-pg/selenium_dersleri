package gun1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trendyol {
    public static void main(String[] args) {

        WebDriver chromeDriver = new ChromeDriver();

        /**
        WebDriver firefoxDriver = new FirefoxDriver();
        WebDriver safariDriver = new SafariDriver();
        */

        chromeDriver.get("https://www.trendyol.com/"); // siteye gider
        chromeDriver.manage().window().maximize(); // tam ekran yapmak icin


        WebElement cookiesAcceptBtn = chromeDriver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAcceptBtn.click();

    }
}
