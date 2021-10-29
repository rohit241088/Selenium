package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import src.baseClass2;
import utils.LoggerClass;
import utils.WebDriverEvents2;

public class Dashboard{

	

	private static WebElement searchButton() {
		return WebDriverEvents2.returnElement("searchButton");
	}
	
	

	
	
	public static void performSearchWithValue(String text){
		WebDriverEvents2.returnElement("searchField").sendKeys(text);
		WebDriverEvents2.returnElement("searchField").sendKeys(Keys.ARROW_DOWN);
		WebDriverEvents2.returnElement("searchField").sendKeys(Keys.ENTER);
			
	}
		
		
	public static void validateResultWithSearch(String text){
		int j=0;
		boolean matching=false;
		String[] searchParameters=text.split(" ");
		List<WebElement>allSearchResults=WebDriverEvents2.returnElements("searchResultsTitle");
		Iterator<WebElement>elementIterator=allSearchResults.iterator();
		LoggerClass.getLogger().debug("Total resutls "+allSearchResults.size());
			while(elementIterator.hasNext()) {
			String currentElementText=elementIterator.next().getText();
			for(int i=0;i<searchParameters.length;i++) {
				String indexString=searchParameters[i];
				LoggerClass.getLogger().debug("Verifying search value "
			+indexString+ " against "+currentElementText+ "at index value "+j);
				System.out.println("Verifying search value "
			+indexString+ " against "+currentElementText+ "at index value "+j);
				if(currentElementText.contains(indexString)) {
matching=true;
break;
				}
				else {
					matching=false;
				}
			}
			j++;
			Assert.assertTrue(matching);
		}
	}
		

	public static void checkSearchWithValidValue(String search_Value) {
		int j=0;
		boolean matching=false;
		String[] searchParameters=search_Value.split(" ");
		WebDriverEvents2.returnElement("searchField").sendKeys(search_Value);
		WebDriverEvents2.returnElement("searchField").sendKeys(Keys.ARROW_DOWN);
		WebDriverEvents2.returnElement("searchField").sendKeys(Keys.ENTER);
		List<String>allElementsText=new ArrayList<>();
		List<WebElement>allSearchResults=WebDriverEvents2.returnElements("searchResultsTitle");
		Iterator<WebElement>elementIterator=allSearchResults.iterator();
		System.out.println("Total Occurances "+allSearchResults.size());
			while(elementIterator.hasNext()) {
			allElementsText.add(elementIterator.next().getText());
		}
		
		Iterator<String>iterator=allElementsText.iterator();
		LoggerClass.getLogger().debug("Total resutls "+allSearchResults.size());
			while(iterator.hasNext()) {
			String currentElementText=iterator.next();
			for(int i=0;i<searchParameters.length;i++) {
				String indexString=searchParameters[i];
				LoggerClass.getLogger().debug("Verifying search value "
			+indexString+ "against "+currentElementText+" at index "+i);
				System.out.println("Verifying search value "
			+indexString+ "against "+currentElementText+ "at index value "+j);
				if(currentElementText.contains(indexString)) {
matching=true;
break;
				}
				else {
					matching=false;
				}
			}
			j++;
			
			Assert.assertTrue(matching);
		}
			
	}
	
}
