package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import pageObjects.baseClass;


public class WebDriverEvents {
private static Logger logger=LoggerClass.getLogger();
private static WebDriver driver=baseClass.returnDriver();
	public static void loadURL(String URL) {
		logger.debug("Loading URL "+URL+" in browser" );
		driver.get(URL);
		logger.debug("Loaded URL "+URL+" in browser" );


	}

	public static WebElement returnElement(String elementKey) {
		logger.debug("location element with pageObject key "+elementKey);

		String element=baseClass.getPageObjectValue(elementKey);
		logger.debug("Element value from object properties file "+elementKey);
		String locatorType=element.split("///")[1];
		String locatorValue=element.split("///")[0];
			FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
					pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);
			 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 WebElement element=null;
			    	 driver=WebDriverEvents.driver;
			    	 switch (locatorType) {
			 		case "xpath":
			 			element=driver.findElement(By.xpath(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "css":
			 			element = driver.findElement(By.cssSelector(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "tagName":
			 			element = driver.findElement(By.tagName(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "id":
			 			element = driver.findElement(By.id(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "className":
			 			element = driver.findElement(By.className(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "linkText":
			 			element = driver.findElement(By.linkText(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "partialLinkText":
			 			element = driver.findElement(By.partialLinkText(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		}
			    	 
			    	  return element;
			     }
			   });

		return foo;

	}

	public static List<WebElement> returnElements(String elementKey) {
		logger.debug("location element with pageObject key "+elementKey);

		String element=baseClass.getPageObjectValue(elementKey);
		logger.debug("Element value from object properties file "+elementKey);

		String locatorType=element.split("///")[1];
		String locatorValue=element.split("///")[0];
				FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
					pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);
			List<WebElement> foo = wait.until(new Function<WebDriver, List<WebElement>>() {
			     public List<WebElement> apply(WebDriver driver) {
			    	 List<WebElement> element=null;
			    	 driver=WebDriverEvents.driver;
			    	 switch (locatorType) {
			 		case "xpath":
			 			element=driver.findElements(By.xpath(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "css":
			 			element = driver.findElements(By.cssSelector(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "tagName":
			 			element = driver.findElements(By.tagName(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "id":
			 			element = driver.findElements(By.id(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "className":
			 			element = driver.findElements(By.className(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "linkText":
			 			element = driver.findElements(By.linkText(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		case "partialLinkText":
			 			element = driver.findElements(By.partialLinkText(locatorValue));
			 			logger.debug("Element located with  "+locatorType);
			 			break;
			 		}
			    	  return element;
			     }
			   });

		return foo;
	}

	public static void clickElement(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
			
			if(element!=null) {
				logger.debug("Clicking on element "+elementKey.split("///")[0]);

				element.click();
				logger.debug("Clicked element "+elementKey.split("///")[0]);
			}
	}

	public static void typeInToElement(String elementKey, String textToEnter) {
		WebElement element=WebDriverEvents.returnElement(elementKey);

		if(element!=null) {
			logger.debug("Typing into element "+elementKey.split("///")[0]+" value"+textToEnter);
			element.sendKeys(textToEnter);
			logger.debug("Typed into element "+elementKey.split("///")[0]+" value"+textToEnter);

		}
	}

	public static void clearTextElement(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
		if(element!=null) {
			logger.debug("clearing value from element "+elementKey.split("///")[0]);

			while(element.getText()!="") {

				element.sendKeys(Keys.BACK_SPACE);
			}
			logger.debug("Cleared value from element "+elementKey.split("///")[0]);

		}
	}

	public static void maximizeWindow() {
	logger.debug("Setting browser to maximize ");
		driver.manage().window().maximize();
	logger.debug("Browser maximized ");

	}
	
	public static void minimizeWindow() {
		logger.debug("Setting browser to minimize ");
		driver.manage().window().minimize();
		logger.debug("Browser minimized ");

	}
	
	public static void resizeWindow( int width,int height) {
		logger.debug("Resizing browser window to hgight "+height+" and width "+width );
		Dimension dimensions=new Dimension(width,height);
		driver.manage().window().setSize(dimensions);
		logger.debug("Browser resized" );

	}
	
	
	public static void setFullScreenWindow() {
		logger.debug("Resizing browser window to full screen" );
		driver.manage().window().fullscreen();
		logger.debug("Browser set to full screen" );

	}
	
	public static void navigateForwardTo(String titleOfWindow) {
		logger.debug("Navigating browser forward untill "+titleOfWindow+" is loaded " );

	while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
		
		driver.navigate().forward();
	}
	logger.debug("Loaded URL after forward navigation "+titleOfWindow );

	}
	
	public static void navigateBackwardTo(String titleOfWindow) {
		logger.debug("Navigating browser backward untill "+titleOfWindow+" is loaded " );

		while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
			
			driver.navigate().back();
	
		}
		logger.debug("Loaded URL after backward navigation "+titleOfWindow );

		}
		
	public static void refreshBrowser() {
		logger.debug("Refreshed browser with current URL "+driver.getCurrentUrl() );

		driver.navigate().refresh();
		logger.debug("Refreshed browser" );

	}
	
	
	public static void implicitWait(String URL) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	
	
	public static String getElementText(String elementKey) {
WebElement element=WebDriverEvents.returnElement(elementKey);
String elementText="";
				if(element!=null) {

		elementText=element.getText();
		logger.debug("Fetched text" +elementText+" from  "+elementKey.split("///")[0] );

				}
				return elementText;
	}

	public static void moveMouseOver(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
			if(element!=null) {
		Actions actions = new Actions(driver);
		logger.debug("Hovering mouse over element "+elementKey.split("///")[0] );
		actions.moveToElement(element).build().perform();
		logger.debug("Hovered mouse over element "+elementKey.split("///")[0] );

			}
	}

	public static void dragElement(String sourceElementKey,String destElementKey) {
		Actions actions = new Actions(driver);
		WebElement source = WebDriverEvents.returnElement(sourceElementKey);
				if(source!=null) {
		WebElement destination = WebDriverEvents.returnElement(destElementKey);
		if(destination!=null) {
			actions.dragAndDrop(source, destination).build().perform();
			logger.debug("Dragging element from "+sourceElementKey.split("///")[0]+""
					+ " to  destination element "+destElementKey );

		}
		
		}
	}

	public static Point getElementPoints(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
		if(element!=null) {
			logger.debug("Returning element points"+element.getLocation().x+" "+
					+element.getLocation().y);

		return element.getLocation();

		}
		return null;
	}

	public static String getPageSource() {
		logger.debug("Returning page source of web page ");
		return driver.getPageSource();

	}

	public static String getCurrentURL() {
		logger.debug("Returning current URL of application "+driver.getCurrentUrl());

		return driver.getCurrentUrl();
	}

	public static String getCurrentWindow() {
		logger.debug("Fetching current window string ");
		return driver.getWindowHandle();
	}

	public static String getPageTitle() {
		logger.debug("Fetching current page title "+driver.getTitle());
		return driver.getTitle();
	}
	
	
	public static void openLinkInNewTab(String elementKey) {
		Actions actions=new Actions(driver);
		WebDriverEvents.moveMouseOver(elementKey);
		actionSendKeyEvent(Keys.CONTROL);
	String elementHrefLink=WebDriverEvents.returnElement(elementKey).getAttribute("href");
	switchToWindowUsingHrefLink(elementHrefLink);
	
	}

	
	private static void actionSendKeyEvent(CharSequence ch) {
		Actions actions=new Actions(driver);
		logger.debug("Sending action event "+ch);

		actions.sendKeys(ch).build().perform();
		
		logger.debug("Sent event "+ch);

		
	}
	
	
	public static void openLinkInNewWindow(String elementKey) {
		WebDriverEvents.moveMouseOver(elementKey);
		actionSendKeyEvent(Keys.SHIFT);
	
	}

	public static boolean switchToWindowUsingTitle(String titleOfWindow) {
		boolean switched = false;
		logger.debug("checking total number of windows opened currently");

			Set<String> allWindows = driver.getWindowHandles();
			logger.debug("Total windows opened in browser "+allWindows.size());

		Iterator<String> iterator = allWindows.iterator();
		Set<String> allTitles = new HashSet<>();
		logger.debug("Storing all windows titles in a list ");

		while (iterator.hasNext()) {
			allTitles.add(driver.switchTo().window(iterator.next()).getTitle());
		}
		

		Iterator<String> titlesIterator = allTitles.iterator();
		logger.debug("Checking if windows with title "+titleOfWindow+ " exist in all opened windows");

		while (titlesIterator.hasNext()) {
			String currentWindows = titlesIterator.next();
			if (currentWindows.compareToIgnoreCase(titleOfWindow) == 0) {
				driver.switchTo().window(currentWindows);
				switched = true;
				logger.debug("One of opened window matching with title "+titleOfWindow+""
						+ "  looking for and switched to it ");
break;
			}
		}
		return switched;
	}

	public static boolean switchToWindowUsingHrefLink(String elementHrefLink) {
		boolean switched = false;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		Set<String> allUrl = new HashSet<>();
		logger.debug("Storing all windows links in a list ");

		while (iterator.hasNext()) {
			allUrl.add(driver.switchTo().window(iterator.next()).getCurrentUrl());
		}
		Iterator<String> titlesIterator = allUrl.iterator();
		logger.debug("Checking if windows with links "+titlesIterator+ " exist in all opened windows");

		while (titlesIterator.hasNext()) {
			String currentWindows = titlesIterator.next();
			if (currentWindows.contains(elementHrefLink)) {
				driver.switchTo().window(currentWindows);
				switched = true;
				logger.debug("One of opened window matching with title "+elementHrefLink+""
						+ "  looking for and switched to it ");
break;
			}
		}
		return switched;
	}
	
	
}
