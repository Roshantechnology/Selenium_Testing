package AutomationTesting.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationTesting.AbstractComponents.AbstarctComponents;

public class ProductCatalog extends AbstarctComponents {
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver) {
		//initialization 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;//alternative of line 1
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy =By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) throws InterruptedException  {
		WebElement prod=getProductByName( productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}

	
	
	
	
}
