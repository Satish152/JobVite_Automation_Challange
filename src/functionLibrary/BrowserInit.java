package functionLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.Test_PO;

public class BrowserInit {
public static WebDriver driver;
public static CommonFunctions functionsWoDriver=new CommonFunctions();
public static CommonFunctions functions;
public static Test_PO page1=new Test_PO();
public static Actions action;
	@BeforeClass
	@Parameters({"browser"})
	public void startBrowser(String browser){
		
		/***based on parameter it should initiate the browser and execute the script in same browser***/
		switch(browser){
		case "chrome":
		       System.setProperty("webdriver.chrome.driver",functionsWoDriver.propertyReader(browser));
		       driver=new ChromeDriver();
		       driver.manage().window().maximize(); 
		       functions=new CommonFunctions(driver);
			break;
		case "firefox":
			   System.setProperty("webdriver.gecko.driver", functionsWoDriver.propertyReader(browser));
			   driver=new FirefoxDriver();
		       driver.manage().window().maximize();
		       functions=new CommonFunctions(driver);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver",functionsWoDriver.propertyReader(browser));
			driver=new InternetExplorerDriver();
		    driver.manage().window().maximize();
		    functions=new CommonFunctions(driver);
			break;
		}
		action=new Actions(driver);
		driver.get(functionsWoDriver.propertyReader("applicationURL"));
	}
	
	
	@AfterMethod()
	public static void testResult(ITestResult result){
		
		//### It will take screen shot of application if any method is failed ###//
		if(ITestResult.FAILURE==result.getStatus()){
			CommonFunctions.screenShot();
			CommonFunctions.logger("Screen shot taken and attached in screenshots folder");
			driver.close();
		}
	}
	
   @AfterClass()
   public void closeBrowser(){
		driver.close();
	}
}
