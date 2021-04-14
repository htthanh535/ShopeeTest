package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected WebDriver driver;
	protected WebDriverWait wait;
	public static final int TIMEOUT_IN_SECOND = 30;
	
	public Base(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Base.TIMEOUT_IN_SECOND);
	}
	
	public WebElement waitUntilElementToBeClickable(WebElement elementToWait) {
		return wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
	}
	
	public void clickElement(WebElement element) {
		WebElement elementIsWaited = waitUntilElementToBeClickable(element);
		elementIsWaited.click();
	}
}
