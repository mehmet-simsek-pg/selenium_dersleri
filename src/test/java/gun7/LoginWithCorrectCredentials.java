package gun7;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

public class LoginWithCorrectCredentials {
    public static void main(String[] args) {
        // 1. ve 2. step
        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        // 3. Step
        WebElement homePageText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));

        final String expectedHomePage = "FEATURES ITEMS";
        final String actualHomePage = homePageText.getText();

        Assert.assertEquals("Home page acilmadi", expectedHomePage, actualHomePage);

        // 4.Step
        WebElement signInBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]/a"));
        signInBtn.click();

        // 5.Step
        WebElement loginText = driver.findElement(By.xpath("//div[@class='login-form']/h2"));

        Assert.assertTrue("Login page acilmadi", loginText.isDisplayed());

        // 6.Step
        WebElement emailInput = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-qa='login-password']"));

        User user = JSONHelper.read("user1");
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());

        // 7.Step
        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginBtn.click();

        // 8.Step
        WebElement username = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[10]/a"));
        Assert.assertTrue("User login olamadi", username.isDisplayed());

        // 9.Step
        WebElement deleteAccountBtn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]/a"));
        deleteAccountBtn.click();

        //10. Step
        WebElement accountDeleted = driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        Assert.assertTrue("Hesap silinemedi", accountDeleted.isDisplayed());

        driver.quit();

    }
}
