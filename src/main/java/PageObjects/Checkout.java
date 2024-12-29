package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class Checkout extends AbstractClass {

	WebDriver driver;

	public Checkout(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutbutton;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement requiredcountry;

	@FindBy(css = ".action__submit")
	WebElement placeOrder;

	By countryResult = By.cssSelector(".ta-results");


	
	public void selectCountry(String country)
	
	{
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, country).build().perform();
		waitForElementsToAppear(countryResult);
		requiredcountry.click();
		windowScrollDown();
	}
	
	public ConfirmationPage placeOrder()
	{
		placeOrder.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
		
	}

}
