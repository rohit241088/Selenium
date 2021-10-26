package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;


public class WebDriverEvents {

	public static void loadURL(WebDriver driver, String URL) {
		driver.get(URL);

	}

	private static WebElement returnElement(WebDriver driver, String locatorValue, String locatorType) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
					pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);
			 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 WebElement element=null;
			    	 switch (locatorType) {
			 		case "xpath":
			 			element=driver.findElement(By.xpath(locatorValue));
			 			break;
			 		case "css":
			 			element = driver.findElement(By.cssSelector(locatorValue));
			 			break;
			 		case "tagName":
			 			element = driver.findElement(By.tagName(locatorValue));
			 			break;
			 		case "id":
			 			element = driver.findElement(By.id(locatorValue));
			 			break;
			 		case "className":
			 			element = driver.findElement(By.className(locatorValue));
			 			break;
			 		case "linkText":
			 			element = driver.findElement(By.linkText(locatorValue));
			 			break;
			 		case "partialLinkText":
			 			element = driver.findElement(By.partialLinkText(locatorValue));
			 			break;
			 		}
			    	  return element;
			     }
			   });

		return foo;

	}

	public static List<WebElement> returnElements(WebDriver driver, String locatorValue, String locatorType) {
		List<WebElement> elements = new ArrayList<>();
		switch (locatorType) {
		case "xpath":
			elements = driver.findElements(By.xpath(locatorValue));
			break;
		case "css":
			elements = driver.findElements(By.cssSelector(locatorValue));
			break;
		case "tagName":
			elements = driver.findElements(By.tagName(locatorValue));
			
			break;
		case "id":
			elements = driver.findElements(By.id(locatorValue));
			break;
		case "className":
			elements = driver.findElements(By.className(locatorValue));
			break;
		case "linkText":
			elements = driver.findElements(By.linkText(locatorValue));
			break;
		case "partialLinkText":
			elements = driver.findElements(By.partialLinkText(locatorValue));
			break;
		}
		return elements;

	}

	public static void clickElement(String locatorValue, String locatorType, WebDriver driver) {
		WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
			
			if(element!=null) {
				element.click();
			}
	}

	public static void typeInToElement(String locatorValue, String locatorType, WebDriver driver, String textToEnter) {
		WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
		
		if(element!=null) {
			element.sendKeys(textToEnter);
		}
	}

	public static void clearTextElement(String locatorValue, String locatorType, WebDriver driver) {
		WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
		if(element!=null) {
			while(element.getText()!="") {
			element.sendKeys(Keys.BACK_SPACE);
			}
		}
	}

	public static void maximizeWindow( WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void minimizeWindow( WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public static void resizeWindow( WebDriver driver, int width,int height) {
		Dimension dimensions=new Dimension(width,height);
		driver.manage().window().setSize(dimensions);
	}
	
	
	public static void getFullScreenWindow( WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	public static void navigateForwardTo( WebDriver driver,String titleOfWindow) {
	while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
		
		driver.navigate().forward();
	}
	}
	
	public static void navigateBackwardTo( WebDriver driver,String titleOfWindow) {
		while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
			
			driver.navigate().back();
	
		}
		}
		
	public static void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	public static void implicitWait(WebDriver driver,String URL) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	
	
	public static String getElementText(String locatorValue, String locatorType, WebDriver driver) {
WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
String elementText="";
				if(element!=null) {
		elementText=element.getText();
				}
				return elementText;
	}

	public static void moveMouseOver(String locatorValue, String locatorType, WebDriver driver) {
		WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
			if(element!=null) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
			}
	}

	public static void dragElement(String sourceLocatorValue, String sourceLocatorType, String targetLocatorValue,
			String targetLocatorType, WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement source = WebDriverEvents.returnElement(driver, sourceLocatorValue, sourceLocatorType);
		if(source!=null) {
		WebElement destination = WebDriverEvents.returnElement(driver, targetLocatorValue, targetLocatorType);
		if(destination!=null) {
			actions.dragAndDrop(source, destination).build().perform();
		}
		
		}
	}

	public static Point getElementPoints(String locatorValue, String locatorType, WebDriver driver) {
		WebElement element=WebDriverEvents.returnElement(driver, locatorValue, locatorType);
		if(element!=null) {
		return element.getLocation();
		}
		return null;
	}

	public static String getPageSource(WebDriver driver) {

		return driver.getPageSource();
	}

	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static String getCurrentWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	
	public static void openLinkInNewTab(WebDriver driver,String locatorType,String locatorValue) {
		Actions actions=new Actions(driver);
		WebDriverEvents.moveMouseOver(locatorValue, locatorType, driver);
	actions.sendKeys(Keys.CONTROL).click().build().perform();
	String elementHrefLink=WebDriverEvents.returnElement(driver, locatorValue, locatorType).getAttribute("href");
	switchToWindowUsingHrefLink(driver, elementHrefLink);
	
	}

	public static void openLinkInNewWindow(WebDriver driver,String locatorType,String locatorValue) {
		Actions actions=new Actions(driver);
		WebDriverEvents.moveMouseOver(locatorValue, locatorType, driver);
	actions.sendKeys(Keys.SHIFT).click().build().perform();
	
	}

	public static boolean switchToWindowUsingTitle(WebDriver driver, String titleOfWindow) {
		boolean switched = false;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		Set<String> allTitles = new HashSet<>();
		while (iterator.hasNext()) {
			allTitles.add(driver.switchTo().window(iterator.next()).getTitle());
		}
		Iterator<String> titlesIterator = allTitles.iterator();
		while (titlesIterator.hasNext()) {
			String currentWindows = titlesIterator.next();
			if (currentWindows.compareToIgnoreCase(titleOfWindow) == 0) {
				driver.switchTo().window(currentWindows);
				switched = true;
			}
		}
		return switched;
	}

	public static boolean switchToWindowUsingHrefLink(WebDriver driver, String elementHrefLink) {
		boolean switched = false;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		Set<String> allUrl = new HashSet<>();
		while (iterator.hasNext()) {
			allUrl.add(driver.switchTo().window(iterator.next()).getCurrentUrl());
		}
		Iterator<String> titlesIterator = allUrl.iterator();
		while (titlesIterator.hasNext()) {
			String currentWindows = titlesIterator.next();
			if (currentWindows.contains(elementHrefLink)) {
				driver.switchTo().window(currentWindows);
				switched = true;
			}
		}
		return switched;
	}
	
	
}
