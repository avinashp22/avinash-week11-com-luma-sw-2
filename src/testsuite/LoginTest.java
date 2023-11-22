package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){


    }


    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){

    }

    @Test
    public void userShouldLogOutSuccessfully(){

    }



    @After
    public void tearDown(){closeBrowser();}

}