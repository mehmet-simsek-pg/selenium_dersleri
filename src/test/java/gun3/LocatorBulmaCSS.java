package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class LocatorBulmaCSS {
    public static void main(String[] args) {
        /**
         * 1. ID ile
         * #susbscribe_email -> css, //input[@id='susbscribe_email'] -> xpath
         * driver.findElement(By.cssSelector(#susbscribe_email))
         *
         * 2. class ile
         * class = 'login-btn'
         * .login-btn -> css, //button[@class='login-btn'] -> xpath
         *  driver.findElement(By.cssSelector(.login-btn))
         *
         *  3. Tag+Class/ID
         *  button.login-btn -> tag ve class
         *  input#susbscribe_email -> tag ve id
         *
         *  4. Attribute ile
         *
         *  input[type='email']
         *  button[type='submit']
         *
         *  5. Parent-child
         *  ul > li
         *
         *  6. nth-child
         *  ul li:nth-child(2)
         * */

        final String email = "test_user@example.com";

        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.sendKeys(email);

        driver.quit();
    }
}
