package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class ProductCatalogue extends AbstractClass {

public WebDriver driver;

//WebElement userEmail = driver.findElement(By.id("userEmail"));

	public ProductCatalogue(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> productlist;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By products = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList()
	
	{
		waitForElementsToAppear(products);
		return productlist;
	}
	
	public WebElement getProduct(String productName)
	
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
		
	}
	
	public void addToCart(String productName) throws InterruptedException
	
	{
		WebElement prod = getProduct(productName);
		prod.findElement(addToCart).click();
		waitForElementsToAppear(toastContainer);
		waitForElementsToInvisible(spinner);
		
	}

}
