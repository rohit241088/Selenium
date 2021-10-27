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
		String element=baseClass.getPageObjectValue(elementKey);
		String locatorType=element.split("///")[1];
		String locatorValue=element.split("///")[0];
		logger.debug("location element with  "+locatorType+" and locatorValue "+locatorValue);
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
			    	 driver=WebDriverEvents.driver;
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

	public static List<WebElement> returnElements(String elementKey) {
		String element=baseClass.getPageObjectValue(elementKey);
		String locatorType=element.split("///")[1];
		String locatorValue=element.split("///")[0];
		logger.debug("location element with  "+locatorType+" and locatorValue "+locatorValue);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
					pollingEvery(Duration.ofMillis(50)).ignoring(NoSuchElementException.class);
			List<WebElement> foo = wait.until(new Function<WebDriver, List<WebElement>>() {
			     public List<WebElement> apply(WebDriver driver) {
			    	 List<WebElement> element=null;
			    	 driver=WebDriverEvents.driver;
			    	 switch (locatorType) {
			 		case "xpath":
			 			element=driver.findElements(By.xpath(locatorValue));
			 			break;
			 		case "css":
			 			element = driver.findElements(By.cssSelector(locatorValue));
			 			break;
			 		case "tagName":
			 			element = driver.findElements(By.tagName(locatorValue));
			 			break;
			 		case "id":
			 			element = driver.findElements(By.id(locatorValue));
			 			break;
			 		case "className":
			 			element = driver.findElements(By.className(locatorValue));
			 			break;
			 		case "linkText":
			 			element = driver.findElements(By.linkText(locatorValue));
			 			break;
			 		case "partialLinkText":
			 			element = driver.findElements(By.partialLinkText(locatorValue));
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
				element.click();
			}
	}

	public static void typeInToElement(String elementKey, String textToEnter) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
		
		if(element!=null) {
			element.sendKeys(textToEnter);
		}
	}

	public static void clearTextElement(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
		if(element!=null) {
			while(element.getText()!="") {
			element.sendKeys(Keys.BACK_SPACE);
			}
		}
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public static void minimizeWindow() {
		driver.manage().window().minimize();
	}
	
	public static void resizeWindow( int width,int height) {
		Dimension dimensions=new Dimension(width,height);
		driver.manage().window().setSize(dimensions);
	}
	
	
	public static void setFullScreenWindow() {
		driver.manage().window().fullscreen();
	}
	
	public static void navigateForwardTo(String titleOfWindow) {
	while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
		
		driver.navigate().forward();
	}
	}
	
	public static void navigateBackwardTo(String titleOfWindow) {
		while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
			
			driver.navigate().back();
	
		}
		}
		
	public static void refreshBrowser() {
		driver.navigate().refresh();
	}
	
	
	public static void implicitWait(String URL) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	
	
	public static String getElementText(String elementKey) {
WebElement element=WebDriverEvents.returnElement(elementKey);
String elementText="";
				if(element!=null) {
		elementText=element.getText();
				}
				return elementText;
	}

	public static void moveMouseOver(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
			if(element!=null) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
			}
	}

	public static void dragElement(String sourceElementKey,String destElementKey) {
		Actions actions = new Actions(driver);
		WebElement source = WebDriverEvents.returnElement(sourceElementKey);
		if(source!=null) {
		WebElement destination = WebDriverEvents.returnElement(destElementKey);
		if(destination!=null) {
			actions.dragAndDrop(source, destination).build().perform();
		}
		
		}
	}

	public static Point getElementPoints(String elementKey) {
		WebElement element=WebDriverEvents.returnElement(elementKey);
		if(element!=null) {
		return element.getLocation();
		}
		return null;
	}

	public static String getPageSource() {

		return driver.getPageSource();
	}

	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public static String getCurrentWindow() {
		return driver.getWindowHandle();
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public static void openLinkInNewTab(String elementKey) {
		Actions actions=new Actions(driver);
		WebDriverEvents.moveMouseOver(elementKey);
	actions.sendKeys(Keys.CONTROL).click().build().perform();
	String elementHrefLink=WebDriverEvents.returnElement(elementKey).getAttribute("href");
	switchToWindowUsingHrefLink(elementHrefLink);
	
	}

	public static void openLinkInNewWindow(String elementKey) {
		Actions actions=new Actions(driver);
		WebDriverEvents.moveMouseOver(elementKey);
	actions.sendKeys(Keys.SHIFT).click().build().perform();
	
	}

	public static boolean switchToWindowUsingTitle(String titleOfWindow) {
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

	public static boolean switchToWindowUsingHrefLink(String elementHrefLink) {
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
