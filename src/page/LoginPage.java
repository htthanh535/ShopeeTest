package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Base {
    
    @FindBy(id="loginEmail")
    WebElement userName;
    
    @FindBy(id="password")
    WebElement password; 
    
    @FindBy(xpath="(//h1)[2]")
    WebElement loginTitle;
    
    @FindBy(xpath="//button[text()='Login']")
    WebElement buttonLogin;
    
    public LoginPage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
    	System.out.println("Set user name: " + strUserName);
    	userName.sendKeys(strUserName);     
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
    	System.out.println("Set user password: " + strPassword);
    	password.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
    	System.out.println("Click button login");
    	buttonLogin.click();
    }  

    //Get the title of Login Page
    public void verifyTheLoginTitleShouldBe(String title){
    	System.out.println("Verify The Site Name Title Should Be: " + title);
    	Assert.assertEquals(waitUntilElementToBeClickable(loginTitle).getText().trim(), title);
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */
    public void loginToANotePad(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();           
    }

}
