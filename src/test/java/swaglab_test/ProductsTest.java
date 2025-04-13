package swaglab_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import swaglab_pages.LoginPage;
import swaglab_pages.ProductsPage;

public class ProductsTest extends BaseClass{
	
	@Test(priority=0)
	public void AddToCartTest()
	{
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user","secret_sauce");
		
		ProductsPage pp = new ProductsPage();
		pp.AddToCart("Sauce Labs Bolt T-Shirt");
		
		ProductsPage pp1 = new ProductsPage();
		pp1.CheckCartPage();
		
		WebElement ProductDsp = driver.findElement(By.xpath("//div[@data-test=\"inventory-item-name\"]"));
		Assert.assertEquals(ProductDsp.getText(), "Sauce Labs Bolt T-Shirt");
		
		
	}
	

}
