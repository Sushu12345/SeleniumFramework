package SushuPracticeActual;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SushuPractice.Basetest;
import SushuPractice.LandingPage;
import SushuPractice.ProductCatalog;



	public class Testsfore2e extends Basetest{

		@Test(dataProvider="getData", groups= {"testing"})
			public void firsttest(HashMap<String, String> input) throws IOException {
			String productname = "ZARA COAT 3";
			
			LandingPage lp = StartPage();
			 ProductCatalog pc = lp.login(input.get("email"), input.get("password"));
			
			List<WebElement> products = pc.Productlist();
	
		}

//@DataProvider
//public Object[][] getData(){
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("email", "sushu@gmail.com");
//	map.put("password", "Sushu@1234");
//	map.put("productname", "ZARA COAT 3");
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email", "prasanth@gmail.com");
//	map1.put("password", "Prasanth@1234");
//	map1.put("productname", "ZARA COAT 3");
//	return new Object[][] {{map},{map1}};
//}

}
	


