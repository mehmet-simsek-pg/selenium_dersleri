package gun4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class _01_Ornek {
    /**
     * https://qa-practice.netlify.app/auth_ecommerce
     * bu siteye gidip,login formunu doldurduktan ve
     * submit butonuna click yaptiktan sonra
     * SHOPPING CART yazisinin ekranda görünüp görünmedigini test edin
     * */
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/auth_ecommerce");

        final String email = "admin@admin.com";
        final String password = "admin123";
        final String expectedText = "SHOPPING CART";

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submitLoginBtn"));
        WebElement shoppingText = driver.findElement(By.cssSelector("section>h2"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        BaseDriver.threadWait(2); // debug icin gercekten mail ve sifreyi yazdi mi
        submitBtn.click();
        BaseDriver.threadWait(2); // debug icin login oldu mu, sayfa degisti mi

        final String actualText = shoppingText.getText();

        Assert.assertEquals("Login islemi basarisiz oldu", expectedText, actualText);

        driver.quit();

    }
}
