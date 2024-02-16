package SushuPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkoutpage extends Reusecode {
	
	WebDriver  driver;
	List <WebElement> cartproducts;
	
	
	By orders = By.cssSelector(".cartSection h3");
	
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> orderdlist(){
		 cartproducts = driver.findElements(orders);
		 System.out.println(cartproducts);
		return cartproducts;
	}
	 public void checkproduct(String productname) {
		 cartproducts.stream().anyMatch(c->
		 c.getText().equalsIgnoreCase(productname)); 
		 //Assert.assertTrue(tru);
		 
	 }
	 public void checkoutclick() {
		 checkoutbutton.click();
	 }
	
	 
}
