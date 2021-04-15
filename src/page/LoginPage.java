package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Base {
	
	public static final String URL_LOGIN_PAGE = "https://phptravels.org/index.php?rp=/login";
	
    @FindBy(tagName="h1")
    WebElement loginTitle;
    
    @FindBy(id="email")
    WebElement userName;
    
    @FindBy(id="passwd")
    WebElement password; 
    
    @FindBy(id="SubmitLogin")
    WebElement buttonSignIn;
    
    @FindBy(xpath="(//div[contains(@class,'alert')])[1]")
    WebElement alertMessage;
    
    public LoginPage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName){
    	System.out.println("Set user name: " + strUserName);
    	userName.sendKeys(strUserName);     
    }

    public void setPassword(String strPassword){
    	System.out.println("Set user password: " + strPassword);
    	password.sendKeys(strPassword);
    }

    public void clickButtonSignIn(){
    	System.out.println("Click button sign in");
    	buttonSignIn.click();
    }  

    public void verifyTheLoginTitleShouldBe(String title){
    	System.out.println("Verify The Site Name Title Should Be: " + title);
    	Assert.assertEquals(waitUntilElementToBeClickable(loginTitle).getText().trim(), title);
    }
    
    public void verifyAlertMessageShouldBe(String message){
    	System.out.println("Verify The Alert Message Title Should Be: " + message);
    	Assert.assertEquals(waitUntilElementToBeClickable(alertMessage).getText().trim(), message);
    }

}
