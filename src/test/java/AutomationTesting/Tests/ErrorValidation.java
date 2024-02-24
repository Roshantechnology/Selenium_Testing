package AutomationTesting.Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTesting.PageObject.CartPage;
import AutomationTesting.PageObject.ProductCatalog;
import AutomationTesting.TestComponents.BaseTest;
import AutomationTesting.TestComponents.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws Exception {
		
		landingpage.loginApplication("Automation12@gmail.com", "Roshan@124");
	//	Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage()); this is correct
		Assert.assertEquals("Incorrect email  password.", landingpage.getErrorMessage());// this is for error check
		
}
	@Test
	public void productErrorValidation() throws Exception {
		String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingpage.loginApplication("Automation12@gmail.com", "Roshan@1234");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	
	}
	


}
