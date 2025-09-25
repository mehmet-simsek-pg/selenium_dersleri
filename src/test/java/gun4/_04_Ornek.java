package gun4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class _04_Ornek {
    /**
     * https://qa-practice.netlify.app/auth_ecommerce
     * bu siteye gidin
     * login olun
     * SHOPPING CART yazisinin geldiginni dogrulayin
     * ardindan ürünlerin isim ve fiyatlari ayri iki list icerisinde tutup ekrana yazdirin
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

        /**
         *  //div[@class='shop-item']/span[@class='shop-item-title']" -> xpath
         *  div[class='shop-item']>span[class='shop-item-title']" -> css
         */

        List<WebElement> isimler = driver.findElements(By.cssSelector("div[class='shop-item']>span"));

        // div[class='shop-item-details']>span
        List<WebElement> fiyatlar = driver.findElements(By.cssSelector("div[class='shop-item']>div>span"));

        System.out.println("Isimler size: " + isimler.size());
        System.out.println("Fiyatlar size: " + fiyatlar.size());


        for (int i = 0; i < isimler.size(); i++) {
            System.out.println("Ürün ismi: " + isimler.get(i).getText()
            +" " + " ürün fiyati: " + fiyatlar.get(i).getText());
        }

        driver.quit();

    }
}
