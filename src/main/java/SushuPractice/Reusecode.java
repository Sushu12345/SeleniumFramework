package SushuPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reusecode {

	WebDriver driver;
	public Reusecode(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartclick;
	
	By heading = By.cssSelector(".heading");
	
	public void waits(By waitlocate) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(waitlocate));
	}
	
	//class= .ng-animating
	public void waitsinvisible(By spinner) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
		}
	
	public void gotocart() {
		cartclick.click();
	}
	

}

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading")));
		
		