package com.yatra.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.css.sac.Locator;

public class CommonOperation {
	
	
	
	public static WebElement findElementById(WebDriver driver,String id){
		
		return driver.findElement(By.id(id));
	}
	
public static void clear(WebDriver driver,By locator){
		
		 driver.findElement(locator).clear();
	}
	
	
	public static void enterText(WebDriver driver,By locator, String text){
		 
		driver.findElement(locator).sendKeys(text);
		
	}
public static void enterTextID(WebDriver driver, String id, String text){
		
		 driver.findElement(By.id(id)).sendKeys(text);
	}

public static void enterTextXpath(WebDriver driver, String xpath, String text){
	
	driver.findElement(By.xpath(xpath)).sendKeys(text);
}
	
	public static WebElement findElementBy(WebDriver driver, By locator){
	
		return driver.findElement(locator);
				
	}
	
	public static WebElement findElementByXpath(WebDriver driver, String xpath){
		
		return driver.findElement(By.xpath(xpath));
				
	}
	public static List<WebElement> findElementsByXpath(WebDriver driver, String xpath){
		
		return driver.findElements(By.xpath(xpath));
		
	}
	
	public static void click(WebDriver driver, By locator){
		driver.findElement(locator).click();
	}
	
	public static void clickXpath(WebDriver driver, String xpath) throws Exception {
		
	driver.findElement(By.xpath(xpath)).click();
		
		
	}
	
	public static void clickID(WebDriver driver, String ID) throws Exception {
		
		driver.findElement(By.id(ID)).click();
			
			
		}
	
	public static String getTextByXpath(WebDriver driver, String xpath) throws Exception {
		
		return driver.findElement(By.xpath(xpath)).getText();
		
		
	}
	
	public static String getTextBy(WebDriver driver, String xpath) throws Exception {
		
		return driver.findElement(By.xpath(xpath)).getText();
		
		
	}

public static void getTitle(WebDriver driver){
	
	
	System.out.println(driver.getTitle());
}


}
