package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import functionLibrary.BrowserInit;

public class Test3 extends BrowserInit {
	
       @Test
       public static void tableValidation() throws InterruptedException{
    	   String country="USA";
    	  int beforeSearch=functions.elementsFinder(page1.tableRows).size();
    	    functions.enterTextInFields(page1.tableSearch, country);
    	    Thread.sleep(3000);
    	    List<WebElement> countries=functions.elementsFinder(By.xpath("//td[contains(text(),'"+country+"')]"));
    	    int afterSearch=countries.size();	
    	    assertNotEquals(beforeSearch,afterSearch,"rows count not matched");
    	    int rowCount=0;
    	    for(int i=0;i<afterSearch;i++){
    	    	String countryName=countries.get(i).getText();
    	    	if(countryName.contains(country)){
    	    		rowCount=rowCount+1;
    	    	}
           }
    	    assertEquals(rowCount, "2");
    	    assertEquals(afterSearch, rowCount);
    	    functions.clearTextField(page1.tableSearch);
    	    Thread.sleep(4000);
    	    int afterClear=functions.elementsFinder(page1.tableRows).size();
    	    assertEquals(beforeSearch, afterClear);
      }
}