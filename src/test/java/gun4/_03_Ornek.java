package gun4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class _03_Ornek {
    /**
     * https://demowebshop.tricentis.com/
     * sitede anasayfa daki elemanlarin linklerini ekrana yazdirin
     * */
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        List<WebElement> linkler = driver.findElements(By.cssSelector("h2[class='product-title']>a"));
        List<WebElement> ratings = driver.findElements(By.cssSelector("div[class='product-rating-box']"));

        System.out.println("Linkerin sayisi: " + linkler.size());
        System.out.println("Ratings size: " + ratings.size());

        for(WebElement link : linkler) {
            // getAttribute metodu ile html tagleri icerisindeki istedigimiz attribute verilerine ulasabiliriz
            System.out.println(link.getAttribute("href"));
        }
        System.out.println("************");

        for (WebElement rate: ratings) {
            System.out.println(rate.getAttribute("title"));
        }

        driver.quit();
    }
}
