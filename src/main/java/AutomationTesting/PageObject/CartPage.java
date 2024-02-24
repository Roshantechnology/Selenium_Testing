package AutomationTesting.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTesting.AbstractComponents.AbstarctComponents;

public class CartPage extends AbstarctComponents {

	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductDisplay(String ProductName) {
		boolean match = cartProducts.stream()
				.anyMatch(cartproductnew -> cartproductnew.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public CheckOutPage checkout() {
		checkoutEle.click();
		return new CheckOutPage(driver);
	}

}
