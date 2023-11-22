package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){

        driver.findElement(By.xpath("//span[text() = 'Sale']")).click();
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html'][text()='Jackets']")).click();

        String expected = "Jackets";
        String actual = driver.findElement(By.xpath("//span[@class = 'base']")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);

        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        int expectedCount = 12;
        int actualCount = items.size();
        System.out.println("Expected Items : 12");
        System.out.println("Actual Items : "+items.size());
        Assert.assertEquals("Correct Amount not Displayed",expectedCount,actualCount);

        List<WebElement> itemsName = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        for(WebElement list : itemsName){System.out.println(list.getText());}

    }


    @After
    public void tearDown(){closeBrowser();}

}
