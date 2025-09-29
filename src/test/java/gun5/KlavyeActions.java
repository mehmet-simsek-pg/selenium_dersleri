package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

public class KlavyeActions {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/auth_ecommerce");

        Actions actions = new Actions(driver);

        final String emailAddress = "testuser";

        WebElement emailInput = driver.findElement(By.id("email"));
        //emailInput.sendKeys(emailAddress); normal elimdeki veriyi yazdi,
        // peki veriyi büyük harflerle yazdirmak isteseydim
        actions
                .click(emailInput)
                .keyDown(Keys.SHIFT)
                .sendKeys(emailAddress)
                .keyUp(Keys.SHIFT)
                .build()
                .perform();

        BaseDriver.threadWait(3);

        actions
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();

        BaseDriver.threadWait(3);
        driver.quit();

    }
}
