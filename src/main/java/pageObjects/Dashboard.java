package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
			System.out.println(element.getText().contains("Rohit")+"\t"+ "Text is "+element.getText());
			
		});
		
		
	}
	public void checkSearchWithInvalidValue(String search_Value) {
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
	}
}
