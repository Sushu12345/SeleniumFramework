package SushuPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCatalog extends Reusecode{
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//@FindBy(css= ".mb-3")
	List<WebElement> products;
	
	
	
	By waitlocate = By.cssSelector(".mb-3");
	By addcart = By.cssSelector(".card-body button:last-of-type");
	By toastwait = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");
	
	public List<WebElement> Productlist() {
		waits(waitlocate);
		products = driver.findElements(waitlocate);
		return products;
	}
	
	public WebElement getproductwebelement(String productname) {
		WebElement product = Productlist().stream().filter(p->p.findElement(By.cssSelector("b"))
				.getText().equals(productname)).findFirst().orElse(null);
		return product;
	}
	
	public void addtocart(String productname) {
		WebElement prod = getproductwebelement(productname);
		prod.findElement(addcart).click();
		waits(toastwait);
		waitsinvisible(spinner);	
	}
	
	
	
	
	
	 
	
}
