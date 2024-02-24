package AutomationTesting.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTesting.AbstractComponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail= driver.findElement(By.id("userEmail")); //line1
	// pageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;// alternative of line 1

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement erroeMessage;

	public ProductCatalog loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;

	}
	public String getErrorMessage() {
		waitForWebElementToAppear(erroeMessage);
		return erroeMessage.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
