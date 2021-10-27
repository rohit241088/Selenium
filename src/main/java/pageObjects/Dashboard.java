package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.LoggerClass;
import utils.WebDriverEvents;

public class Dashboard extends baseClass {

	private static WebElement searchField() {
		return WebDriverEvents.returnElement("searchField");
	}

	private WebElement searchButton() {
		return WebDriverEvents.returnElement("searchButton");
	}
	
	private List<WebElement> serachResults() {
		return WebDriverEvents.returnElements("searchResultsTitle");
		
	}

	public void checkSearchWithValidValue(String search_Value) {
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
		serachResults().stream().forEach((WebElement element)->{
			String[] search_ValueArray=search_Value.split(" ");
			for(int i=0;i<search_ValueArray.length;i++) {
				LoggerClass.getLogger().debug("Verifying search value against "
			+search_ValueArray[i]);
				Assert.assertTrue(element.getText().contains(search_ValueArray[i]));
			}
		});
		
		
	}
	public void checkSearchWithInvalidValue(String search_Value) {
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
	}
}
