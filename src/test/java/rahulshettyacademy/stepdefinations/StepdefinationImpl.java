package rahulshettyacademy.stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.Checkout;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepdefinationImpl extends BaseTest{

	public LandingPage landingpage;
	public ProductCatalogue productcataloue;
	public CartPage cartpage;
	public ConfirmationPage confirmationpage;
	public Checkout checkout;
	
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		
		landingpage = new LandingPage(driver);
		launchApplication();	
	}
	
	
	@Given("Loged in with username {string} and password {string}")
	public void loged_in_with_username_and_password(String username, String password) 	
	{
		
		ProductCatalogue productcataloue = landingpage.logInApplication(username, password);
	}
	
	@When("I add product {string} to cart")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productcataloue.getProductList();
		productcataloue.getProduct(productName);
		productcataloue.addToCart(productName);
	}
	
	@When("Checkout {string} and Submit")
	public void checkout_and_submit(String productName) throws InterruptedException
	{
		cartpage = productcataloue.clickCartHeader();
		Boolean match = cartpage.verifyCartElements(productName);
		Assert.assertTrue(match);
		checkout = cartpage.placeOrder();
		checkout.selectCountry("india");
		Thread.sleep(3000);
		confirmationpage = checkout.placeOrder();
		Thread.sleep(3000);
	}
	
	@Then("{string} message is displayed on  Confirmation Page")
	public void message_is_displayed_on_confirmation_page(String string) {
		
		String confirmMessage = confirmationpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String str)
	{
		Assert.assertEquals(str, landingpage.getErrorMessage());
		driver.close();
	}

}
