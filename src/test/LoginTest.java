package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import page.HeaderPage;
import page.LoginPage;

/**
 * Unit test for simple App.
 */
public class LoginTest {
	String driverPath = System.getProperty("user.dir") + "\\geckodriver.exe";
    
    WebDriver driver;
    HeaderPage headerPage;
    LoginPage loginPage;
    
    @BeforeClass
    public void constructerWebDriver() {
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    }
    
    @BeforeMethod
    public void setup(){

        driver.get("https://anotepad.com/");
    }

    /**
     * This test go to 
     * Verify login page title
     * Login to application
     * Verify the home page using
     */
    @Test(priority=0)
    public void loginWithEmptyUserNameAndPassword(){
    	
    	headerPage.verifyTheSiteNameTitleShouldBe("aNotepad.com");
	    //click button register login
    	headerPage.clickOnButtonRegisterLogin();
    	loginPage.verifyTheLoginTitleShouldBe("Login");
    	loginPage.loginToANotePad("", "");

    }
    
    @AfterMethod(alwaysRun = true)
	protected void closeBrowser() throws Exception
	{
    	driver.quit();
	}
}
