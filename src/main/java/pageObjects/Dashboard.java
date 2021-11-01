package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import utils.WebDriverEvents2;

public class Dashboard {
private Properties properties=null;
private WebDriverEvents2 webEvents=null;
public Dashboard(WebDriverEvents2 events,Properties properties) {
		this.webEvents=events;
		this.properties=properties;
}
	private WebElement searchField() {
		return webEvents.returnElement(properties.getProperty("searchfield"));
	}
	
	private WebElement searchButton() {
		return webEvents.returnElement(properties.getProperty("searchbutton"));
	}
	private List<WebElement> searchResults() {
		return webEvents.returnElements(properties.getProperty("searchresults"));
	}
	
	public Dashboard typeInSearch(String searchValue) {
		this.searchField().sendKeys(searchValue);
		return this;
		
	}
	
	
	public Dashboard clickSearchButton() {
		try {
		this.searchButton().click();
		}
		catch(Exception e) {
			System.out.println("Could not click ");
		}
		return this;
		
	}
	
	public Dashboard clickSearchButton2() {
		this.searchField().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		return this;
		
	}
	
	public boolean verifySearchResults(String searchValue) {
		List<WebElement>allElements=this.searchResults();
		Iterator<WebElement>elementIterator=allElements.iterator();
		String[] searchArray=searchValue.split(" ");
		boolean match=false;
		while(elementIterator.hasNext()) {
			String elementText=elementIterator.next().getText();
			for(int i=0;i<searchArray.length;i++) {
				if(elementText.contains(searchArray[i])){
					match=true;
					break;		}
			}
			System.out.println("Thread is "+Thread.currentThread().getName()+"Matching elementText "+elementText+" with search value "+searchValue+" and found "+match);
			Assert.assertTrue(match);
		}
		
		return match;
	}
	
	
	
}
