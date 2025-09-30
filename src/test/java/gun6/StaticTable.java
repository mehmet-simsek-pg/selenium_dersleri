package gun6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://qa-practice.netlify.app/web-table");

        List<String> mockData = new ArrayList<>(Arrays.asList("mo@email.com","jacob_t@yahoo.com","lbow@gmail.com","bobby_23@gmail.com","el_icarus@yahoo.com"));

        List<WebElement> emails = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));

        for (int i = 0; i < emails.size(); i++) {

            String expected = mockData.get(i);
            String actual = emails.get(i).getText();

            Assert.assertEquals("Yanlis mail eklenmis", expected, actual);
        }

        driver.quit();
    }
}
