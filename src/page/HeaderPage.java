package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderPage extends Base {
    
	public static final String LOGO_IMAGE = "http://automationpractice.com/img/logo.jpg";
	
    @FindBy(css=".logo")
    WebElement logo;
    
    @FindBy(css=".login")
    WebElement buttonLogin;
    
    @FindBy(css=".account")
    WebElement userLoggedIn;

    public HeaderPage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void verifyHomeLogoShouldDisplay(){
    	System.out.println("Verify Home Logo Should Display");
    	waitUntilElementToBeClickable(logo);
    	Assert.assertEquals(logo.getAttribute("src"), LOGO_IMAGE);
    	Assert.assertTrue(logo.isDisplayed());
    }
    
    public void clickLogin(){
    	System.out.println("Click button login");
    	buttonLogin.click();
    }
    
    public void verifyUserNameLoggedInShouldBe(String name){
    	System.out.println("verify User Name Logged In Should Be: " + name);
    	Assert.assertEquals(waitUntilElementToBeClickable(userLoggedIn).getText().trim(), name);
    }
}
