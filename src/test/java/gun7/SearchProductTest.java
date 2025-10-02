package gun7;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

public class SearchProductTest {
    public static void main(String[] args) {
        // 1. ve 2. step
        WebDriver driver = BaseDriver.driver("https://automationexercise.com/");

        // 3. Step
        WebElement homePageText = driver.findElement(By.xpath("//div[@class='features_items']/h2"));

        final String expectedHomePage = "FEATURES ITEMS";
        final String actualHomePage = homePageText.getText();

        Assert.assertEquals("Home page acilmadi", expectedHomePage, actualHomePage);

        // 4.Step
        WebElement productBtn = driver.findElement(By.cssSelector("div[class='shop-menu pull-right']>ul>li:nth-child(2)>a"));
        productBtn.click();

        // 5. Step
        WebElement verifyProductPage = driver.findElement(By.xpath("//h2[contains(@class, 'title')]"));

        final String expectedProductPage = "ALL PRODUCTS";
        final String actualProductPage = verifyProductPage.getText();

        Assert.assertEquals("Products page acilmadi", expectedProductPage, actualProductPage);

        // 6.Step
        WebElement searchInput = driver.findElement(By.id("search_product"));
        searchInput.sendKeys("Winter Top");

        WebElement searchBtn = driver.findElement(By.id("submit_search"));
        searchBtn.click();

        // 7. Step
        WebElement searchedProducts = driver.findElement(By.cssSelector("h2.title"));

        final String expectedSearched = "SEARCHED PRODUCTS";
        final String actualSearched = searchedProducts.getText();

        Assert.assertEquals("Searched Products yazisi görünmüyor", expectedSearched, actualSearched);

        // 8.Step
        WebElement productName = driver.findElement(By.xpath("//div[@class='single-products']/div/p"));

        Assert.assertTrue("Aranan ürün bulunamadi",productName.isDisplayed());

        driver.quit();

    }

}
