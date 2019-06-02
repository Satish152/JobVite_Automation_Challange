package functionLibrary;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import io.appium.java_client.functions.ExpectedCondition;

public class CommonFunctions{
	
static WebDriver driver;
public static Properties prop;
public static FileInputStream fis;
public static WebDriverWait wait;
public static WebElement ele;

//### for execution of function and initiation of global webdriver etc,
public CommonFunctions(WebDriver driver){
	this.driver=driver;
	wait=new WebDriverWait(driver, 5000);
	
}

//### initiation of CF class for execution  of properties function
public CommonFunctions(){
	//constructor for initializing class
}

//### Screenshot function
	public static void screenShot(){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/JobViteTest/screenshots"));
		} catch (IOException e) {
		   logger(e.getStackTrace());
		}
	}
	
	//### logger for prints the values
	public static void logger(Object message){
		System.out.println(message.toString());
	}
	
	//### properties reader function for object repostiory
	public String propertyReader(String propertyValue){
			try {
			File data=new File("./configurations/ObjectRepository.properties");
			fis = new FileInputStream(data);
            prop=new Properties();
			prop.load(fis);
			return prop.getProperty(propertyValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty(propertyValue)+" vbrowser value");
		return null;
	}
	
	//### element finder
	public WebElement elementFinder(By locator){
	    WebElement element=null;
	    try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator);
	    }catch(Exception e){
	    	return element;	
	    }
	}
	
	//### Sendkeys function
	public void enterTextInFields(By locator,String text){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		    ele=elementFinder(locator);
              ele.sendKeys(text);		
	}
	
	//###function for clicking elements
	public void clickOnElement(WebElement element){
		try{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}catch(Exception e){
	       assertTrue(false);	       
	       e.getMessage();
		}
	}
	
	public List elementsFinder(By locator){
			return driver.findElements(locator);
	}
	
	//### it return true if value not display and return false if value display
	public boolean elementNotDisplayed(WebElement element){
		try{
			if(element.isDisplayed()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			assertTrue(false);
		}
		return false;
	}
	
	//###function to search invalid scenarios
	public void PrintListOfWebElements(WebElement parentElement,By childLocator) throws InterruptedException{
		List<WebElement> options=parentElement.findElements(childLocator);
		for(int i=0;i<options.size();i++){
			logger(options.get(i).getText().toString());
		}
	}
	
	public void printSpecificValuesInList(WebElement parentElement,String searchtext){
		List<WebElement> options=parentElement.findElements(By.xpath("//*[contains(text(),'"+searchtext+"')]"));
		int count=0;
		
		for(int i=0;i<options.size();i++){
			logger(options.get(i).getText());
			String optionText=options.get(i).getText();
			logger(optionText+" search");
			if(optionText.contains(searchtext)){
			    count=count+1;
			    assertTrue(true);
			}else{
				assertTrue(false);
			}
		}
		logger("no of available elements matched with Search text :"+count);
	}
	
	public void searchWithInvalidtext(WebElement element){
		 if(element.isDisplayed()!=true){
			 assertTrue(true);
		 }else{
			 assertTrue(false);
		 }
	}
	
	public String getTextFromElement(By locator){
		return elementFinder(locator).getText();
	}
	
	public void clearTextField(By locator){
	     elementFinder(locator).clear();
	}
	
	public void scrollToElement(By locator){
		ele=elementFinder(locator);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
}
