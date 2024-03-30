package utils;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 */

/**
 * @author Sachin Dongare
 *
 */
public class ElementsUtils {

	WebDriver driver;
	public ElementsUtils(WebDriver driver) {
		this.driver=driver;
	}

	//This method is used for the waiting Mechanism only(Explicit Wait)
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		WebElement webElement=null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	//Click on WebElement with the Explicit wait
	public void clickOnWebElement(WebElement element,long durationInSeconds) {
		WebElement webElement =waitForElement(element,durationInSeconds);
		webElement.click();
	}

	//This method is used to enter the value in text field with clearing the exist value
	public void enterValueInToTextField(WebElement element,String textToBeTyped,long durationInSeconds) {

		WebElement webElement = waitForElement(element,durationInSeconds);
		//webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	//Select value form the dropdown
	public void selectOptionFromDropdown(WebElement element,String DropdownOption,long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select =new Select(webElement);
		select.selectByVisibleText(DropdownOption);
	}

	//Wait Alert method
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert =null;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	//This method is used for to accept the alert
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	//This method is used for to dismiss the alert
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	//This method is used to mouseHoverAnd click on WebElement
	public void mouseHoverAndCliek(WebElement element,long durationInSeconds) {
		
	 WebElement webElement = WaitForVisiBlityOfWebElement(element,durationInSeconds);
	 Actions actions=new Actions(driver);
	 actions.moveToElement(webElement).click().build().perform();
	}

	// Waiting Mechanism for the visibility of WebElement
	public WebElement WaitForVisiBlityOfWebElement(WebElement element,long durationInSeconds) {
		WebElement webElement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		  webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	//This method is used for to click on WebElement by using the Javascript
	public void clickOnWebElementUsingJavaScript(WebElement element,long durationInSeconds) {
		WebElement webElement = WaitForVisiBlityOfWebElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click()", webElement);
	}
	
	//This method is used to enter the character using the javascript Executor
	public void enterValueUsingJavascriptExecutor(WebElement element,String textToBeTyped,long durationInSeconds) {
		WebElement webElement = WaitForVisiBlityOfWebElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
	}
	
	//This method is used for the get Text from the webElement
	public String getTextValueFromWebElement(WebElement element,long durationInSeconds) {
		WebElement webElement =waitForElement(element,durationInSeconds);
	return webElement.getText();
	}
	
	//Is element Display
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		try {
		WebElement webElement = WaitForVisiBlityOfWebElement(element,durationInSeconds);
		return webElement != null && webElement.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
}
