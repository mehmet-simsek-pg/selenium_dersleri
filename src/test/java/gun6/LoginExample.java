package gun6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class LoginExample {
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://www.saucedemo.com/");

        final String email = "standard_user";
        final String password = "secret_sauce";

        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement productsText = driver.findElement(By.xpath("//span[@data-test='title']"));

        String expected = "Products";
        String actual = productsText.getText();

        Assert.assertEquals("Ana sayfa acilmadi", expected, actual);
        BaseDriver.threadWait(3);
        driver.quit();
    }
}
