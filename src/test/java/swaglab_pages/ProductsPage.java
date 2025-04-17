package swaglab_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab_test.BaseClass;

public class ProductsPage {
	
	WebDriver driver =BaseClass.driver;
	
	//=================Locators=================
	
	@FindBy(xpath="//a[@data-test=\"shopping-cart-link\"]")
	WebElement CartIcon;
	
	@FindBy(xpath="//button[@id=\"checkout\"]")
	WebElement CheckOutButton;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name=\"lastName\"]")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name=\"postalCode\"]")
	WebElement PostalCode;
	
	@FindBy(xpath="//input[@name=\"continue\"]")
	WebElement Continue;
	
	@FindBy(xpath="//button[@id=\"finish\"]")
	WebElement Finish;
	
	//=================Methods==================
	
	public ProductsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
    public void AddToCart(String ProductName) 
    {
		
		String ProductXapth = "//div[text()='" + ProductName + "']//following::button[1]";
		
		WebElement AddToCart = driver.findElement(By.xpath(ProductXapth));
		AddToCart.click();
	
}
    
    public void CheckCartPage()
    {
    	
    	CartIcon.click();
    	
    }

	public void CheckOutPage()
	{
		CheckOutButton.click();
		
	}
	public void CheckOutInformation(String FirstNameVal, String LastNameVal, String PostalCodeVal)
	{

		FirstName.sendKeys(FirstNameVal);
		LastName.sendKeys(LastNameVal);
		PostalCode.sendKeys(PostalCodeVal);
		Continue.click();
		Finish.click();
	}
	
	
}
	

		
		
		
   
