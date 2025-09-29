package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class IframeKonuAnlatimi {
    /**
     * Reklam
     * Video
     * Harita
     * alanlarinda kullanilir.
     * Selenium iframe icerisindeki elementlere direkt olarak ulasamaz.
     * Bunun icin iframe e gecis yapmamiz gerekli.
     * */
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/iframe");

        /**
        WebElement framedenOnce = driver.findElement(By.xpath("//h1[@class='display-4']"));
        System.out.println("Frame den önce: " + framedenOnce.getText());
         */

        // 1. yöntem
        WebElement iframe = driver.findElement(By.id("iframe-checkboxes"));
        driver.switchTo().frame(iframe); // iframe icerisine girdi ve bu sayede
        // iframe icerisindeki elemente locate olabildi

        /**
         * 2. yöntem
         * driver.switchTo().frame(0); index ile iframe e gecis yapma
         * 3. yöntem
         * driver.switchTo().frame("iframeName"); iframe ismi ile frame icerisine gecis yapma
         * */

        WebElement framedenSonra = driver.findElement(By.xpath("//h1[@class='display-4']"));
        System.out.println("Frameden sonra: " + framedenSonra.getText());

        driver.switchTo().defaultContent(); // iframe icinden cikip en üstteki html icerisine girer

        WebElement exampleText = driver.findElement(By.xpath("//div[@id='content']/h2"));
        System.out.println("Example text: " + exampleText.getText());

        driver.quit();
    }
}
