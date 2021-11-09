package tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dashboard;
import utils.LoggerClass;

public class checkvideolength extends Basetest {
		
		private Dashboard dashboard=null;
		
		private static Logger logger=LoggerClass.getLogger();

		
		@BeforeMethod
		public void initializePage() {
			dashboard=new Dashboard(super.getWebEvents2(), super.getBase().getPageObjects());
		}
		
		
		@Test
		public void validSearchTest() {
			String[] names= {"Rohit Sharma", "Anjali Vats","Chetan Vats"};
			
			for(int i=0;i<names.length;i++) {
			String searchValue=names[i];
			boolean match=false;
			String []allSearchValues=searchValue.split(" ");
			dashboard.typeInSearch(searchValue);
			dashboard.clickSearchButton();	
			List<WebElement>allElementsText=dashboard.getSearchResults();
			Iterator<WebElement>elementIterator=allElementsText.iterator();
			while(elementIterator.hasNext()) {
				String elementText=elementIterator.next().getText();
				for(String s:allSearchValues) {
					if(elementText.contains(s));
					match=true;
					break;
				}
				logger.debug("Element text "+elementText+" search value "+searchValue+" matched "+match);
				Assert.assertTrue(match);
			}
			
			Iterator<WebElement>elementIterator2=allElementsText.iterator();
			while(elementIterator2.hasNext()) {

			WebElement element=elementIterator2.next();
		
			super.getWebEvents2().clickElement(element,true);
			
			
		
		WebElement elementMatch=super.getWebEvents2().returnElement
				(super.getBase().getPageObjects().getProperty("videoPlayBackTitle").replace("dummy", element.getText()));
	
		if(elementMatch.getText().contains(element.getText())) {
			System.out.println("Matched video title, now checking video length");
			String videoLength=super.getWebEvents2().returnElement
					(super.getBase().getPageObjects().getProperty("videoLength")).getAttribute("aria-valuemax");
			System.out.println("Video title "+element.getText()+" having length is "+videoLength);
			
			super.getWebEvents2().goBack();
		}
		
			}
			super.getWebEvents2().clearTextElement(super.getWebEvents2().returnElement(super.getBase().getPageObjects().getProperty("searchfield")));
			}
		
			
			}
			

		//@Test
		public void validSearchTest1() {
			String searchValue="Anushka Sharma";
			boolean match=false;
			String []allSearchValues=searchValue.split(" ");
			dashboard.typeInSearch(searchValue);
			dashboard.clickSearchButton();	
			List<WebElement>allElementsText=dashboard.getSearchResults();
			Iterator<WebElement>elementIterator=allElementsText.iterator();
			while(elementIterator.hasNext()) {
				String elementText=elementIterator.next().getText();
				for(String s:allSearchValues) {
					if(elementText.contains(s));
					match=true;
					break;
				}
				logger.debug("Element text "+elementText+" search value "+searchValue+" matched "+match);
				Assert.assertTrue(match);
			}
			
			}
			
		

		
		

}
