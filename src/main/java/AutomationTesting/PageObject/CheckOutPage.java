package AutomationTesting.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTesting.AbstractComponents.AbstarctComponents;

public class CheckOutPage extends AbstarctComponents {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}
		
	public ConfirmationPage submitOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
