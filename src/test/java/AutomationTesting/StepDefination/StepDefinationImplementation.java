package AutomationTesting.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AutomationTesting.PageObject.CartPage;
import AutomationTesting.PageObject.CheckOutPage;
import AutomationTesting.PageObject.ConfirmationPage;
import AutomationTesting.PageObject.LandingPage;
import AutomationTesting.PageObject.ProductCatalog;
import AutomationTesting.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinationImplementation extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationpage;
	
	@Given("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException {
		landingPage= launchApplication();
	}
	
	@Given("^Logged in with username (.+) and (.+)$")
	public void  Given_Logged_in_with_username_password(String username, String password) {
		
		 productCatalog = landingpage.loginApplication(username,password);
		
	}
	@ When ("^I add product (.+) to cart$")
	//I add product <productName> to cart
	public void  I_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		
	}
	@When ("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException {
		
		CartPage cartPage = productCatalog.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartPage.checkout();
		checkoutpage.selectCountry("India");
		 confirmationpage = checkoutpage.submitOrder();
	}
	
	@Then ("{string} message is displayed on ConfirmationPage")
	public void message_displayed_ConfirmationPage(String string) {
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
	@Then("^\"([^\"]*)\" message is displayed")
	public void Something_Message_Displayed(String string) {
		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	