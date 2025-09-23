package gun2;

import org.junit.Assert;
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

        WebElement allProductsText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));

        String expectedText = "ALL PRODUCTS";
        String actualText = allProductsText.getText();

        Assert.assertEquals("Products sayfasi acilmadi", expectedText, actualText);
    }
}
