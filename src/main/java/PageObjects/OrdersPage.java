package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class OrdersPage extends AbstractClass {

	WebDriver driver;

//WebElement userEmail = driver.findElement(By.id("userEmail"));

	public OrdersPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	


	public boolean verifyOrderPage(String productName)
	
	{
		Boolean match =  productNames.stream().anyMatch(productNames-> productNames.getText().equalsIgnoreCase(productName));
		return match;
	}


}
