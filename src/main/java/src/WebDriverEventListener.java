package src;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import utils.LoggerClass;

public class WebDriverEventListener implements WebDriverListener {
	private static Logger logger=LoggerClass.getLogger();
	 public void beforeAnyCall(Object target, Method method, Object[] args)  {}
	 public void afterAnyCall(Object target, Method method, Object[] args, Object result)  {}

	 public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {}

	  // WebDriver

	 public  void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args)  {}
	 public  void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result)  {}

//	 public void beforeGet(WebDriver driver, String url) {
//			logger.debug("Loading URL in browser  "+url);
//
//	 }
//	 public  void afterGet(WebDriver driver, String url) {
//			logger.debug("Loaded URL in browser  "+url);
//
//	 }
//
//	 public  void beforeGetCurrentUrl(WebDriver driver) {
//			logger.debug("Fetching current URL");
//
//	 }
//	 public  void afterGetCurrentUrl(String result, WebDriver driver) {
//			logger.debug("Current URL fetched "+result);
//
//	 }
//
//	 public void beforeGetTitle(WebDriver driver) {
//			logger.debug("Fetching page title");
//	 }
//	 public void afterGetTitle(WebDriver driver, String result) {
//			logger.debug("Fetched page title "+result);
//
//	 }
//
//	 public void beforeFindElement(WebDriver driver, By locator) {
//			logger.debug("Looking for element using"+locator.getClass().getSimpleName());
//
//	 }
//	 public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//			logger.debug("found element using "+locator.getClass().getSimpleName());
//
//	 }
//
//	 public void beforeFindElements(WebDriver driver, By locator) {
//			logger.debug("Looking for elements using"+locator.getClass().getSimpleName());
//
//	 }
//	 public  void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
//			logger.debug("found elements using "+locator.getClass().getSimpleName());
//			logger.debug("Total elements found "+result.size());
//
//
//	 }
//
//	 public void beforeGetPageSource(WebDriver driver) {
//		 
//	 }
//	 public void afterGetPageSource(WebDriver driver, String result) {}
//
//	   public  void beforeClose(WebDriver driver) {
//			logger.debug("Closing browser ");
//
//	   }
//	   public void afterClose(WebDriver driver) {
//			logger.debug("Closed browser");
//
//	   }
//
//	   public void beforeQuit(WebDriver driver) {
//			logger.debug("Closing all instance of browser");
//
//	   }
//	   public void afterQuit(WebDriver driver) {
//			logger.debug("Closed all instance of browser");
//
//	   }
//
//	   public void beforeGetWindowHandles(WebDriver driver) {
//
//	   }
//	   public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
//			logger.debug("Total windows opened "+result.size());
//
//	   }
//
//	   public void beforeGetWindowHandle(WebDriver driver) {}
//	   public void afterGetWindowHandle(WebDriver driver, String result) {}
//
//	   public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
//			logger.debug("Runing java script "+script);
// 
//	   }
//	   public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {}
//
//	   public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {}
//	   public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {}
//
//	   public  void beforePerform(WebDriver driver, Collection<Sequence> actions) {
//			logger.debug("Performing action sequence "+actions.size());
//
//	   }
//	   public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
//			logger.debug("Performed action sequence "+actions.size());
//
//	   }
//
//	   public void beforeResetInputState(WebDriver driver) {}
//	   public void afterResetInputState(WebDriver driver) {}
//
//	  // WebElement
//
//	   public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args)  {}
//	   public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result)  {}
//
//	   public void beforeClick(WebElement element) {
//			logger.debug("Performing click on element "+element.getText());
//
//	   }
//	   public void afterClick(WebElement element) {
//			logger.debug("Performing click on element "+element.getText());
//	   }
//
//	   public void beforeSubmit(WebElement element) {
//			logger.debug("Submitting element "+element.getText());
//
//	   }
//	   public void afterSubmit(WebElement element) {
//			logger.debug("Submitted element "+element.getText());
//
//	   }
//
//	   public  void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
//			logger.debug("Performing sendkeys on element "+element.getText()+" with action "+keysToSend.toString());
//
//	   }
//	   public void afterSendKeys(WebElement element, CharSequence... keysToSend) {}
//
//	   public void beforeClear(WebElement element) {}
//	   public  void afterClear(WebElement element) {}
//
//	   public void beforeGetTagName(WebElement element) {}
//	   public void afterGetTagName(WebElement element, String result) {}
//
//	   public void beforeGetAttribute(WebElement element, String name) {}
//	   public void afterGetAttribute(WebElement element, String name, String result) {}
//
//	   public void beforeIsSelected(WebElement element) {}
//	   public void afterIsSelected(WebElement element, boolean result) {}
//
//	   public void beforeIsEnabled(WebElement element) {}
//	   public void afterIsEnabled(WebElement element, boolean result) {}
//
//	   public void beforeGetText(WebElement element) {}
//	   public void afterGetText(WebElement element, String result) {}
//
//	   public void beforeFindElement(WebElement element, By locator) {}
//	   public void afterFindElement(WebElement element, By locator, WebElement result) {}
//
//	   public void beforeFindElements(WebElement element, By locator) {}
//	   public void afterFindElements(WebElement element, By locator, List<WebElement> result) {}
//
//	   public void beforeIsDisplayed(WebElement element) {}
//	   public void afterIsDisplayed(WebElement element, boolean result) {}
//
//	   public void beforeGetLocation(WebElement element) {}
//	   public void afterGetLocation(WebElement element, Point result) {}
//
//	   public void beforeGetSize(WebElement element) {}
//	   public void afterGetSize(WebElement element, Dimension result) {}
//
//	   public void beforeGetCssValue(WebElement element, String propertyName) {}
//	   public void afterGetCssValue(WebElement element, String propertyName, String result) {}
//
//	  // Navigation
//
//	   public void beforeAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args)  {}
//	   public void afterAnyNavigationCall(WebDriver.Navigation navigation, Method method, Object[] args, Object result)  {}
//
//	   public void beforeTo(WebDriver.Navigation navigation, String url) {}
//	   public void afterTo(WebDriver.Navigation navigation, String url) {}
//
//	   public void beforeTo(WebDriver.Navigation navigation, URL url) {}
//	   public void afterTo(WebDriver.Navigation navigation, URL url) {}
//
//	   public void beforeBack(WebDriver.Navigation navigation) {}
//	   public void afterBack(WebDriver.Navigation navigation) {}
//
//	   public void beforeForward(WebDriver.Navigation navigation) {}
//	   public void afterForward(WebDriver.Navigation navigation) {}
//
//	   public void beforeRefresh(WebDriver.Navigation navigation) {}
//	   public void afterRefresh(WebDriver.Navigation navigation) {}
//
//	  // Alert
//
//	   public void beforeAnyAlertCall(Alert alert, Method method, Object[] args)  {}
//	   public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result)  {}
//
//	   public void beforeAccept(Alert alert) {}
//	   public void afterAccept(Alert alert) {}
//
//	   public void beforeDismiss(Alert alert) {}
//	   public void afterDismiss(Alert alert) {}
//
//	   public void beforeGetText(Alert alert) {}
//	   public void afterGetText(Alert alert, String result) {}
//
//	   public void beforeSendKeys(Alert alert, String text) {}
//	   public void afterSendKeys(Alert alert, String text) {}
//
//	  // Options
//
//	   public void beforeAnyOptionsCall(WebDriver.Options options, Method method, Object[] args)  {}
//	   public void afterAnyOptionsCall(WebDriver.Options options, Method method, Object[] args, Object result)  {}
//
//	   public void beforeAddCookie(WebDriver.Options options, Cookie cookie) {}
//	   public void afterAddCookie(WebDriver.Options options, Cookie cookie) {}
//
//	   public void beforeDeleteCookieNamed(WebDriver.Options options, String name) {}
//	   public void afterDeleteCookieNamed(WebDriver.Options options, String name) {}
//
//	   public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {}
//	   public void afterDeleteCookie(WebDriver.Options options, Cookie cookie) {}
//
//	   public void beforeDeleteAllCookies(WebDriver.Options options) {}
//	   public void afterDeleteAllCookies(WebDriver.Options options) {}
//
//	   public void beforeGetCookies(WebDriver.Options options) {}
//	   public void afterGetCookies(WebDriver.Options options, Set<Cookie> result) {}
//
//	   public void beforeGetCookieNamed(WebDriver.Options options, String name) {}
//	   public void afterGetCookieNamed(WebDriver.Options options, String name, Cookie result) {}
//
//	  // Timeouts
//
//	   public void beforeAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args)  {}
//	   public void afterAnyTimeoutsCall(WebDriver.Timeouts timeouts, Method method, Object[] args, Object result)  {}
//
//	   public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {}
//	   public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {}
//
//	   public void beforeSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
//	   public void afterSetScriptTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
//
//	   public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
//	   public void afterPageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {}
//
//	  // Window
//
//	   public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args)  {}
//	   public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result)  {}
//
//	   public void beforeGetSize(WebDriver.Window window) {}
//	   public void afterGetSize(WebDriver.Window window, Dimension result) {}
//
//	   public void beforeSetSize(WebDriver.Window window, Dimension size) {}
//	   public void afterSetSize(WebDriver.Window window, Dimension size) {}
//
//	   public void beforeGetPosition(WebDriver.Window window) {}
//	   public void afterGetPosition(WebDriver.Window window, Point result) {}
//
//	   public void beforeSetPosition(WebDriver.Window window, Point position) {}
//	   public void afterSetPosition(WebDriver.Window window, Point position) {}
//
//	   public void beforeMaximize(WebDriver.Window window) {}
//	   public void afterMaximize(WebDriver.Window window) {}
//
//	   public void beforeFullscreen(WebDriver.Window window) {}
//	   public void afterFullscreen(WebDriver.Window window) {}

	
	

}
