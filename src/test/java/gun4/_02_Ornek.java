package gun4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class _02_Ornek {

    /**
     * https://demowebshop.tricentis.com/
     * bu sitede navbar kisminda kac eleman oldugunu bulun,
     * son elemanin yazisinin GIFT CARDS olup olmadigini kontrol edin
     * */
    public static void main(String[] args) {

        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        List<WebElement> navbarItems = driver.findElements(By.cssSelector("ul[class='top-menu']>li>a"));

        System.out.println("Linklerin sayisi: " + navbarItems.size());
        WebElement sonEleman = navbarItems.getLast();

        final String expectedText = "GIFT CARDS";
        final String actualText = sonEleman.getText();

        Assert.assertEquals("Son elemanin yazisi yanlis", expectedText, actualText);

        driver.quit();

    }
}
