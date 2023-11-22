package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("avinashp22@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Prime123!");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedMessage = "Welcome, Avinash Patel!";
        String actualMessage = driver.findElement(By.xpath("//span[text()='Welcome, Avinash Patel!']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){

        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("patel@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("321!Prime");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[text() = 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully(){

        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("avinashp22@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Prime123!");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        String expected = "Welcome, Avinash Patel!";
        String actual = driver.findElement(By.xpath("//span[text()='Welcome, Avinash Patel!']")).getText();
        Assert.assertEquals(expected, actual);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        String expectedDisplay = "You are signed out";
        String actualDisplay = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals(expectedDisplay, actualDisplay);

    }



    @After
    public void tearDown(){closeBrowser();}

}