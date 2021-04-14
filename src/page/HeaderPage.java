package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HeaderPage extends Base {

    @FindBy(css=".container > a")
    WebElement siteNameTitle;
    
    @FindBy(css=".nav a[href='/create_account']")
    WebElement buttonRegisterLogin;

    public HeaderPage(WebDriver driver){
    	super(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void verifyTheSiteNameTitleShouldBe(String siteName){
    	System.out.println("Verify The Site Name Title Should Be: " + siteName);
    	Assert.assertEquals(waitUntilElementToBeClickable(siteNameTitle).getText().trim(), siteName);
    }
    
    public void clickOnButtonRegisterLogin(){
    	System.out.println("CLick on button register login");
    	clickElement(buttonRegisterLogin);
    }
}
