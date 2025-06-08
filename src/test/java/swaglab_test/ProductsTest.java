package swaglab_test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglab_pages.LoginPage;
import swaglab_pages.ProductsPage;

@Listeners(Listener.class)
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

		ProductsPage pp2 = new ProductsPage();
		pp2.CheckOutPage();

		WebElement CheckOut = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(CheckOut.getText(), "Checkout: Your Information");

		ProductsPage pp3 = new ProductsPage();
		pp3.CheckOutInformation("Navya", "Roy","411012");

		WebElement CheckOverview = driver.findElement(By.xpath("//span[@data-test='title']"));
		Assert.assertEquals(CheckOverview.getText(),"Checkout: Overview");

		WebElement SuccessOrderMessage = driver.findElement(By.xpath("//h2[@data-test='complete-header']"));
		Assert.assertEquals(SuccessOrderMessage.getText(),"Thank you for your order!");



	}


}
