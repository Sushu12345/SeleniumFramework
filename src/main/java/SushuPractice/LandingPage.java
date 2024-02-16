package SushuPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "userEmail")
	WebElement Usermail;
	
	@FindBy(id = "userPassword")
	WebElement Userpasswd;
	
	@FindBy(id = "login")
	WebElement Submit;
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalog login(String usermailid, String userpd) {
		Usermail.sendKeys(usermailid);
		Userpasswd.sendKeys(userpd);
		Submit.click();
		ProductCatalog pc = new ProductCatalog(driver);
		return pc;
	}

}


