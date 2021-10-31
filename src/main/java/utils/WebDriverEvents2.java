package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import src.baseClass2;

public class WebDriverEvents2 {
	private static WebDriver driver=null;
	public WebDriverEvents2(WebDriver driver) {
		WebDriverEvents2.driver=driver;
	}
	private static Logger logger=LoggerClass.getLogger();
	

		public WebElement returnElement(String elementkey) {
			String element=elementkey;
			logger.debug("location element with pageObject key "+element);
			logger.debug("Element value from object properties file "+element);
			String locatorType=element.split("///")[1];
			String locatorValue=element.split("///")[0];
			FluentWait<WebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
			pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class);
				 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driverLocal) {
				    	 driverLocal=driver;
				    	 WebElement element=null;
				     switch (locatorType.toLowerCase()) {
				 		case "xpath":
				 			element=driverLocal.findElement(By.xpath(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "css":
				 			element = driverLocal.findElement(By.cssSelector(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "tagName":
				 			element = driverLocal.findElement(By.tagName(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "id":
				 			element = driverLocal.findElement(By.id(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "className":
				 			element = driverLocal.findElement(By.className(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "linkText":
				 			element = driverLocal.findElement(By.linkText(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "partialLinkText":
				 			element = driverLocal.findElement(By.partialLinkText(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		}
				    	 
				    	  return element;
				     }
				   });

			return foo;

		}
		public List<WebElement> returnElements(String elementkey) {
	
			String element=elementkey;
			logger.debug("location element with pageObject key "+element);
			logger.debug("Element value from object properties file "+element);
			String locatorType=element.split("///")[1];
			String locatorValue=element.split("///")[0];
			Wait<WebDriver>wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				 List<WebElement>elements=null;
					   	 switch (locatorType) {
				 		case "xpath":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorValue)));
				 			
				 			elements= driver.findElements(By.xpath(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			
				 			break;
				 		case "css":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
				 			elements = driver.findElements(By.cssSelector(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 			
				 		case "tagName":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(locatorValue)));
				 			elements = driver.findElements(By.tagName(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "id":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locatorValue)));
				 			elements = driver.findElements(By.id(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "className":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locatorValue)));
				 			elements = driver.findElements(By.className(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "linkText":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(locatorValue)));
				 			elements = driver.findElements(By.linkText(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		case "partialLinkText":
				 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(locatorValue)));
				 			elements = driver.findElements(By.partialLinkText(locatorValue));
				 			logger.debug("Element located with "+locatorType+" "+locatorValue);
				 			break;
				 		}
		   
						return elements;
				   
				
		}

	
		

		public void typeInToElement(WebElement element, String textToEnter) {
			
			if(element!=null) {
				logger.debug("Typing into element "+" value"+textToEnter);
				element.sendKeys(textToEnter);
				logger.debug("Typed into element "+" value"+textToEnter);

			}
		}

		public void clearTextElement(WebElement element) {
			
				while(element.getText()!="") {

					element.sendKeys(Keys.BACK_SPACE);
				}
				logger.debug("Cleared value from element");

			
		}

		public void maximizeWindow() {
		logger.debug("Setting browser to maximize ");
			driver.manage().window().maximize();
		logger.debug("Browser maximized ");

		}
		
		public  void minimizeWindow() {
			logger.debug("Setting browser to minimize ");
			driver.manage().window().minimize();
			logger.debug("Browser minimized ");

		}
		
		public  void resizeWindow( int width,int height) {
			logger.debug("Resizing browser window to hgight "+height+" and width "+width );
			Dimension dimensions=new Dimension(width,height);
			driver.manage().window().setSize(dimensions);
			logger.debug("Browser resized" );

		}
		
		
		public void setFullScreenWindow() {
			logger.debug("Resizing browser window to full screen" );
			driver.manage().window().fullscreen();
			logger.debug("Browser set to full screen" );

		}
		
		public void navigateForwardTo(String titleOfWindow) {
			logger.debug("Navigating browser forward untill "+titleOfWindow+" is loaded " );

		while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
			
			driver.navigate().forward();
		}
		logger.debug("Loaded URL after forward navigation "+titleOfWindow );

		}
		
		public  void navigateBackwardTo(String titleOfWindow) {
			logger.debug("Navigating browser backward untill "+titleOfWindow+" is loaded " );

			while(!driver.getTitle().equalsIgnoreCase(titleOfWindow)){
				
				driver.navigate().back();
		
			}
			logger.debug("Loaded URL after backward navigation "+titleOfWindow );

			}
			
		public  void refreshBrowser() {
			logger.debug("Refreshed browser with current URL "+driver.getCurrentUrl() );

			driver.navigate().refresh();
			logger.debug("Refreshed browser" );

		}
		
		
		public  void implicitWait(String URL) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		
		
		
		
	
		public void moveMouseOver(String elementKey) {
			WebElement element=returnElement(elementKey);
				if(element!=null) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();

				}
		}

		public void dragElement(String sourceElementKey,String destElementKey) {
			Actions actions = new Actions(driver);
			WebElement source = returnElement(sourceElementKey);
					if(source!=null) {
			WebElement destination = returnElement(destElementKey);
			if(destination!=null) {
				actions.dragAndDrop(source, destination).build().perform();
			

			}
			
			}
		}

		public Point getElementPoints(String elementKey) {
			WebElement element=returnElement(elementKey);
			if(element!=null) {
				logger.debug("Returning element points"+element.getLocation().x+" "+
						+element.getLocation().y);

			return element.getLocation();

			}
			return null;
		}

	

		

	

		
		
		
		public void openLinkInNewTab(String elementKey) {
			moveMouseOver(elementKey);
			actionSendKeyEvent(Keys.CONTROL);
		String elementHrefLink=returnElement(elementKey).getAttribute("href");
		switchToWindowUsingHrefLink(elementHrefLink);
		
		}

		
		private void actionSendKeyEvent(CharSequence ch) {
			Actions actions=new Actions(driver);
			logger.debug("Sending action event "+ch);

			actions.sendKeys(ch).build().perform();
			
			logger.debug("Sent event "+ch);

			
		}
		
		
		public void openLinkInNewWindow(String elementKey) {
			moveMouseOver(elementKey);
			actionSendKeyEvent(Keys.SHIFT);
		
		}

		public boolean switchToWindowUsingTitle(String titleOfWindow) {
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

		public boolean switchToWindowUsingHrefLink(String elementHrefLink) {
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
		
		public void executeJavaScript(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}
		
		public void closeBrowser() {
			driver.close();
		}

}
