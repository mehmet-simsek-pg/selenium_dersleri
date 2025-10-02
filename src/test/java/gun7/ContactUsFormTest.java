package gun7;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class ContactUsFormTest {
    public static void main(String[] args) {

        // 1. ve 2. step
        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        // 3. Step
        WebElement homePageText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));

        final String expectedHomePage = "FEATURES ITEMS";
        final String actualHomePage = homePageText.getText();

        Assert.assertEquals("Home page acilmadi", expectedHomePage, actualHomePage);

        // 4. Step
        WebElement contactUsBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[8]/a"));
        contactUsBtn.click();

        //5.Step
        WebElement getInTouch = driver.findElement(By.xpath("//div[@class='contact-form']/h2"));

        Assert.assertTrue("Get in touch yazisi görünmüyor", getInTouch.isDisplayed());

        // 6.Step
        final String name = "test user";
        final String email = "testuser001@example.com";
        final String subject = "Testing";
        final String message = "Testing with selenium and java";

        WebElement nameInput = driver.findElement(By.xpath("//input[@data-qa='name']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='email']"));
        WebElement subjectInput = driver.findElement(By.xpath("//input[@data-qa='subject']"));
        WebElement messageInput = driver.findElement(By.xpath("//textarea[@data-qa='message']"));

        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);

        // 7.Step
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadFile.sendKeys("/Users/mehmetsimsek/Desktop/Techno Study/selenium_dersleri/src/test/resources/test-records/LoginExample1759344958221.mov");

        // 8.Step
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitBtn.click();

        // 9.Step
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 10.Step
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));

        Assert.assertTrue("Form gönderilemedi", successMessage.isDisplayed());

        // 11.Step
        WebElement homeBtn = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
        homeBtn.click();

        Assert.assertEquals("Home page acilmadi", expectedHomePage, actualHomePage);

        driver.quit();

    }
}
