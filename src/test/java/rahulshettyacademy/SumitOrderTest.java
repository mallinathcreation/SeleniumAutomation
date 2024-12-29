package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.Checkout;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.OrdersPage;
import PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;

public class SumitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider ="getData" , groups = {"purhase"})
	public void SubmitOrderTest(HashMap<String, String> map) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// String selectedcountry = "India";

		// WebDriverManger -- same works like System.set property. Useful as it
		// downloads automatically the
		// latest driver version which is compatible to our browser.

		ProductCatalogue productcataloue = landingpage.logInApplication(map.get("email"), map.get("password"));
		List<WebElement> products = productcataloue.getProductList();
		productcataloue.getProduct(map.get("product"));
		productcataloue.addToCart(map.get("product"));
		CartPage cartpage = productcataloue.clickCartHeader();
		Boolean match = cartpage.verifyCartElements(map.get("product"));
		Assert.assertTrue(match);
		Checkout checkout = cartpage.placeOrder();
		checkout.selectCountry("india");
		Thread.sleep(3000);
		ConfirmationPage confirmationpage = checkout.placeOrder();
		Thread.sleep(3000);
		String confirmMessage = confirmationpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = { "SubmitOrderTest" })
	public void orderHistoryTest() {
		ProductCatalogue productcataloue = landingpage.logInApplication("joyee@gmail.com", "Joyee@007");
		OrdersPage orderspage = productcataloue.clickOrdersTab();
		Assert.assertTrue(orderspage.verifyOrderPage(productName));

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "joyee@gmail.com"); map.put("password", "Joyee@007"); map.put("product",
		 * "ZARA COAT 3");
		 * 
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "mallinath@gmail.com"); map1.put("password", "Malli007");
		 * map1.put("product", "ADIDAS ORIGINAL");
		 */
		
		//when passing data within the test case through objects
		//return new Object[] [] {{"joyee@gmail.com","Joyee@007" ,"ZARA COAT 3"},{"mallinath@gmail.com","Malli007", "ADIDAS ORIGINAL"}};
	
		//when passing the data through map
		
		List<HashMap<String, String>> data = getJasonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		
		//getting the data from the method . 0 --  first data, 1-- second data and so on
		return new Object[] [] {{data.get(0)},{data.get(1)}};
	
	}

}
