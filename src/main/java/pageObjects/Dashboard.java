package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Dashboard extends baseClass {

	private static WebElement searchField() {
		return returnElement("searchField");
	}

	private WebElement searchButton() {
		return returnElement("searchButton");
	}

	public void checkSearchWithValidValue(String search_Value) {
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
	}
	public void checkSearchWithInvalidValue(String search_Value) {
		searchField().sendKeys(search_Value);
		searchField().sendKeys(Keys.ARROW_DOWN);
		searchField().sendKeys(Keys.ENTER);
		searchButton().click();
	}
}
