package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void verifyThatSignInPageDisplay(){
        driver.findElement(By.linkText("Create an Account")).click();
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[text()='Create New Customer Account']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }


    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Create an Account")).click();

        driver.findElement(By.id("firstname")).sendKeys("Michael");
        driver.findElement(By.id("lastname")).sendKeys("Jordan");
        driver.findElement(By.id("email_address")).sendKeys("michaelljjordan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Prime123!");
        driver.findElement(By.id("password-confirmation")).sendKeys("Prime123!");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedText, actualText);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expectedMessage = "You are signed out";
        String actualMessage = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @After
    public void tearDown(){closeBrowser();}

}