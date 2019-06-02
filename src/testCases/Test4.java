package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionLibrary.BrowserInit;

public class Test4 extends BrowserInit{

	@Test
	public static void dragAndDropValidation() throws InterruptedException{
		functions.scrollToElement(page1.dragBlock);
		Thread.sleep(3000);
		WebElement drag=functions.elementFinder(page1.dragBlock);
		WebElement drop=functions.elementFinder(page1.dropBlock);
	    action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		Thread.sleep(3000);
		if(functions.elementFinder(page1.afterDrop).isDisplayed()){
	    	assertTrue(true);
	    }else{
	    	assertTrue(false);
	    }
	}
}
