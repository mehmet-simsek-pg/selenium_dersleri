package gun1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementBulma {
    public static void main(String[] args) {

        final String username = "akin_aslan";
        final String password = "Techno.Student25";

        WebDriver driver = new ChromeDriver();

        driver.get("https://live.mersys.io/");
        driver.manage().window().maximize();

        WebElement userNameInput = driver.findElement(By.id("mat-input-0"));
        WebElement passwordInput = driver.findElement(By.id("mat-input-1"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@aria-label='LOGIN']"));

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        loginBtn.click();
    }
}
