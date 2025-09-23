package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    public static WebDriver driver(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        try {
            WebElement element =
                    driver.findElement(By.xpath("//div[@class='fc-footer-buttons']/button[1]"));

            element.click();
            throw new NoSuchElementException("Element sayfada yok");

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Bilinmiyen bir hata olustu");
        }
            return driver;
    }

}
