package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class XpathOrnekleri {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        WebElement productBtn =
                driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        productBtn.click();
    }
}
