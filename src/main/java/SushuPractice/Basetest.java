package SushuPractice;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;

public class Basetest {
	WebDriver driver = new ChromeDriver();
	public WebDriver IntialiseDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("\\Users\\prasa\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\SushuPractice\\resources\\GetData.properties");
		prop.load(fis);
	
		//String browserid = prop.getProperty("browser");
		String browserid =System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browserid.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserid.contains("headless"))
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().window().fullscreen();
		}
		else if(browserid.equalsIgnoreCase("Msedge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	public LandingPage StartPage() throws IOException {
		IntialiseDriver();
		LandingPage lp = new LandingPage(driver);
		lp.Goto();
		return  lp;
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports"+testCaseName + ".png";
	}

	


}
