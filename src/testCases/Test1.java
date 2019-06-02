package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionLibrary.BrowserInit;

public class Test1 extends BrowserInit{

	@Test
	public static void dataValidation(){
		String nameVal="testName";
		String cityVal="hyderabada";
		WebElement open=functions.elementFinder(page1.openModelBtn);
		functions.clickOnElement(open);
		functions.enterTextInFields(page1.nameInput,nameVal);
		functions.enterTextInFields(page1.cityInput,cityVal);
		WebElement Enter=functions.elementFinder(page1.enterBtn);
		WebElement close=functions.elementFinder(page1.closeBtn);
		functions.clickOnElement(Enter);
		functions.clickOnElement(close);
		assertEquals(functions.getTextFromElement(page1.displayName), nameVal, "name value not matahing");
		assertEquals(functions.getTextFromElement(page1.displayCity), cityVal, "city value not matahing");
	}
}
