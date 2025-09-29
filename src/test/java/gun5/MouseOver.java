package gun5;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class MouseOver {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/mouse-hover");

        Actions actions = new Actions(driver);

        WebElement hoverElement = driver.findElement(By.id("button-hover-over"));
        actions.moveToElement(hoverElement).perform();
        // selenium da mouse hareketleri yaptirirken test calistigi esnada mouse u hareket ettirmiyoruz
        // yoksa selenium komutlari calismayabilir

        WebElement hideElement = driver.findElement(By.xpath("//div[@class='hide']"));

        Assert.assertTrue("Mouse hareket etmedi", hideElement.isDisplayed());
        driver.quit();
    }
}
