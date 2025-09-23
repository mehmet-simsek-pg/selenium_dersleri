package gun2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBulmaXpath {
    public static void main(String[] args) {

        /**
         * Locators-> id, class, name, xpath, css selector
         * Xpath ->
         *
         * 1. Absolute xpath
         * /html/body/header/div/div/div/div[2]/div/ul/li[2]/a
         * html den baslar yazmaya
         * Dezavantaji, sayfa yapisi degisirse calismaz
         *
         * 2. Relative xpath
         *
         * // ile baslar.Daha stabil ve tercih edilen. Örn:
         * //input[@id='username']
         *
         * -------------------------------------------------
         * Xpath bulma yollari ->
         *
         * 1. Attribute ile bulma
         * //input[@id='username'], id yerine class, name gibi attribute lar da olabilir
         *
         * 2. Text ile bulma
         * //a[text()='Products']
         *
         * 3. Contains() ile
         * //a[contains(text(), 'Woman')]
         * //a[contains(@id, 'mat-input')]
         *
         * 4. Starts-with() ile
         * name = 'password'
         * //button[starts-with(@name, 'pass')]
         *
         * 5. Parent-child
         * //div[@class='form-group']/input
         *
         * 6. Following-sibling
         *
         * //div[@class='panel-heading']/following-sibling::div
         * */

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();


        WebElement productBtn =
                driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a"));
        productBtn.click();
    }
}
