package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class CartPage extends AbstractClass {

	WebDriver driver;

//WebElement userEmail = driver.findElement(By.id("userEmail"));

	public CartPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(css = "[routerlink*='cart']")
	WebElement prodclick;
	
	@FindBy(css= ".totalRow button")
	WebElement proceedToCheckout;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public boolean verifyCartElements(String productName)
	
	{
		List <WebElement> ele = cartProducts;
		Boolean match =  cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public Checkout placeOrder()
	{
		proceedToCheckout.click();
		Checkout checkout = new Checkout(driver);
		return checkout;
	}

}
