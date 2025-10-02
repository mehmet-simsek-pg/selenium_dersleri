package gun6;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojo.User;
import utility.BaseDriver;
import utility.JSONHelper;

public class LoginExample {
    public static void main(String[] args) throws ATUTestRecorderException {

        ATUTestRecorder recorder = new ATUTestRecorder(
                "src/test/resources/test-records",
                "LoginExample" + System.currentTimeMillis(),
                false
        );

        recorder.start(); // kayit basladi

        WebDriver driver = BaseDriver.driver("https://www.saucedemo.com/");

        User user = JSONHelper.read("users");

        final String email = user.getEmail();
        final String password = user.getPassword();

        WebElement emailInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        BaseDriver.threadWait(3);
        loginButton.click();

        WebElement productsText = driver.findElement(By.xpath("//span[@data-test='title']"));

        String expected = "Products";
        String actual = productsText.getText();

        Assert.assertEquals("Ana sayfa acilmadi", expected, actual);
        BaseDriver.threadWait(3);
        driver.quit();

        recorder.stop(); // kayit kapandi
    }
}
