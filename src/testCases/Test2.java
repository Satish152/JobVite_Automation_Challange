package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionLibrary.BrowserInit;

public class Test2 extends BrowserInit{

	@Test
	public static void SearchValidation() throws InterruptedException{
		String searchText="Angular";
		String invalidText="Reactjs";
		WebElement clickBtn=functions.elementFinder(page1.clickMe);
		functions.clickOnElement(clickBtn);
		WebElement dropdown=functions.elementFinder(page1.dropdownBlock);
		functions.PrintListOfWebElements(dropdown, page1.items);
		functions.enterTextInFields(page1.searchField, searchText);
		functions.printSpecificValuesInList(dropdown,searchText);
		functions.clearTextField(page1.searchField);
		functions.enterTextInFields(page1.searchField, invalidText);
		WebElement items=functions.elementFinder(page1.items);
	    functions.elementNotDisplayed(items); 
	}
}
