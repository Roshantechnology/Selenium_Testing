package AutomationTesting.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationTesting.PageObject.CartPage;
import AutomationTesting.PageObject.CheckOutPage;
import AutomationTesting.PageObject.ConfirmationPage;
import AutomationTesting.PageObject.OrderPage;
import AutomationTesting.PageObject.ProductCatalog;
import AutomationTesting.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws Exception { 
		
		
		ProductCatalog productCatalog = landingpage.loginApplication(input.get("email"), input.get("Password"));
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartPage.checkout();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));// to compare actual vs expected
	}

	//to verify zara coat 3 is displaying in orders page
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void orderHistoryTest() {
		ProductCatalog productCatalog = landingpage.loginApplication("roshan12@gmail.com", "Roshan@1234");
		OrderPage orderpage=productCatalog.goToOrderPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//AutomationTesting//Data//purchaseOrder.json");
		return new Object[][] {{data.get(0)} , {data.get(1)}};
	}
	
	
	
	
	
	
	
	
	
}
