package SushuPracticeActual;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SushuPractice.Basetest;
import SushuPractice.Checkoutpage;
import SushuPractice.LandingPage;
import SushuPractice.ProductCatalog;
import SushuPractice.Retry;
import SushuPractice.Reusecode;

public class Ecommercee2e extends Basetest{

	@Test(retryAnalyzer = Retry.class)
		public void firsttest() throws IOException {
		String productname = "ZARA COAT 3";
		
		LandingPage lp = StartPage();
		 ProductCatalog pc = lp.login("sushu@gmail.com", "Sushu@1234");
		
		List<WebElement> products = pc.Productlist();
		pc.getproductwebelement(productname);
		pc.addtocart(productname);
		pc.gotocart();
		
		
		
		
	}

}
