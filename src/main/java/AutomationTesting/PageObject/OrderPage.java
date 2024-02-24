package AutomationTesting.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTesting.AbstractComponents.AbstarctComponents;

public class OrderPage extends AbstarctComponents {

	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productName;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOrderDisplay(String ProductName) {
		boolean match = productName.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	

}
