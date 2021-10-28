package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.LoggerClass;
import utils.WebDriverEvents;

public class Dashboard {

	private static WebElement searchField() {
		return WebDriverEvents.returnElement("searchField");
	}

	private static WebElement searchButton() {
		return WebDriverEvents.returnElement("searchButton");
	}
	
	private static List<WebElement> serachResults() {
		return WebDriverEvents.returnElements("searchResultsTitle");
		
	}
	

	
	
	public static void performSearchWithValue(String text){
		searchField().sendKeys(text);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
			
	}
		
		
	public static void validateResultWithSearch(String text){
		boolean matching=false;
		String[] searchParameters=text.split(" ");
		Iterator<WebElement>elementIterator=serachResults().iterator();
		LoggerClass.getLogger().debug("Total resutls "+serachResults().size());
			while(elementIterator.hasNext()) {
			String currentElementText=elementIterator.next().getText();
			for(int i=0;i<searchParameters.length;i++) {
				String indexString=searchParameters[i];
				LoggerClass.getLogger().debug("Verifying search value "
			+indexString+ "against "+currentElementText);
				System.out.println("Verifying search value "
			+indexString+ "against "+currentElementText);
				if(currentElementText.contains(indexString)) {
matching=true;
break;
				}
				else {
					matching=false;
				}
			}
			Assert.assertTrue(matching);
		}
	}
		

	public static void checkSearchWithValidValue(String search_Value) {
		boolean matching=false;
		String[] searchParameters=search_Value.split(" ");
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
			//	WebDriverEvents.clickElement(searchButton());
		Iterator<WebElement>elementIterator=serachResults().iterator();
		LoggerClass.getLogger().debug("Total resutls "+serachResults().size());
			while(elementIterator.hasNext()) {
			String currentElementText=elementIterator.next().getText();
			for(int i=0;i<searchParameters.length;i++) {
				String indexString=searchParameters[i];
				LoggerClass.getLogger().debug("Verifying search value "
			+indexString+ "against "+currentElementText);
				System.out.println("Verifying search value "
			+indexString+ "against "+currentElementText);
				if(currentElementText.contains(indexString)) {
matching=true;
break;
				}
				else {
					matching=false;
				}
			}
			Assert.assertTrue(matching);
		}
		
			}
	public static void checkSearchWithInvalidValue(String search_Value) {
		searchField().sendKeys(search_Value);
			searchButton().click();
	}
}
