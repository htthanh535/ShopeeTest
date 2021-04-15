package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    
    @BeforeMethod
    public void setup(){
    	System.setProperty("webdriver.gecko.driver", driverPath);
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability("marionette",true);
    	driver= new FirefoxDriver(capabilities);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerPage = new HeaderPage(driver);
        loginPage = new LoginPage(driver);
    	
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority=0)
    public void loginWithEmptyUserNameAndPassword(){
    	
	    //click button register login
    	headerPage.verifyHomeLogoShouldDisplay();
    	headerPage.clickLogin();
    	loginPage.verifyTheLoginTitleShouldBe("AUTHENTICATION");

    	loginPage.setUserName("");
        //Fill password
    	loginPage.setPassword("");
        //Click Login button
    	loginPage.clickButtonSignIn(); 
    	loginPage.verifyAlertMessageShouldBe("There is 1 error\nAn email address required.");
    	
    	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
    
    @Test(priority=1)
    public void loginWithInvalidEmail(){

	    //click button register login
    	headerPage.verifyHomeLogoShouldDisplay();
    	headerPage.clickLogin();
    	loginPage.verifyTheLoginTitleShouldBe("AUTHENTICATION");

    	loginPage.setUserName("abc");
        //Fill password
    	loginPage.setPassword("abc");
        //Click Login button
    	loginPage.clickButtonSignIn(); 
    	loginPage.verifyAlertMessageShouldBe("There is 1 error\nInvalid email address.");
    	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
    
    @Test(priority=2)
    public void loginWithWrongPassword(){

	    //click button register login
    	headerPage.verifyHomeLogoShouldDisplay();
    	headerPage.clickLogin();
    	loginPage.verifyTheLoginTitleShouldBe("AUTHENTICATION");

    	loginPage.setUserName("htthanh535@gmail.com");
        //Fill password
    	loginPage.setPassword("123");
        //Click Login button
    	loginPage.clickButtonSignIn(); 
    	loginPage.verifyAlertMessageShouldBe("There is 1 error\nInvalid password.");
    	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
    
    @Test(priority=3)
    public void loginWithExactlyPassword(){

	    //click button register login
    	headerPage.verifyHomeLogoShouldDisplay();
    	headerPage.clickLogin();
    	loginPage.verifyTheLoginTitleShouldBe("AUTHENTICATION");

    	loginPage.setUserName("htthanh535@gmail.com");
        //Fill password
    	loginPage.setPassword("Admin123");
        //Click Login button
    	loginPage.clickButtonSignIn(); 
    	headerPage.verifyUserNameLoggedInShouldBe("Thanh Huynh");
    	System.out.println(">>>>>> TEST PASSED >>>>>>");
    }
    
    @AfterMethod(alwaysRun = true)
	protected void closeBrowser() throws Exception
	{
    	driver.quit();
	}
}
