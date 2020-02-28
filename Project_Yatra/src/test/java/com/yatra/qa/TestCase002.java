package com.yatra.qa;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCase002 {

	WebDriver driver;
	String hotel="The Pride Hotel Nagpur";
	String checkInDate = "25/02/2020";
	String checkOutDate = "26/02/2020";
	int numOfTraveller = 1;
	String room="Suite Single";
	int maxAmt=10000;
	
	String beforexpathChooseRoom="//a[@title='";
	String afterxpathChooseRoom="']//ancestor::div[@class='result-details-left']//following-sibling::div[@class='result-details-right show-gt-768 pr']//child::span[@class='new-blue-button medium choose-room-button nowrap ng-binding']";
	
	String beforexpathOfAmt="//p[text()='";
	String afterxpathOfAmt="']//following-sibling::div[@class='flex']//child::span[@class='rs ']//following-sibling::span ";
	
	String beforexpathOfBookNow="//p[text()='";
	String afterxpathOfBookNow="']//following-sibling::div[@class='flex']//child::button[@class='new-blue-button newBtn  choose-room-button ']";
			
	String beforexpathScrol="//p[text()='";
	String afterxpathScrol="']";
	
	// **//p[text()='Suite Single']//following-sibling::div[@class='flex']//child::button[@class='new-blue-button newBtn  choose-room-button ']

	@Test
	public void bookingHotelRoom() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver", "chromedriver78.exe");

		// ChromeOptions opt=new ChromeOptions();
		// opt.addArguments("--disable-notification");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		Thread.sleep(5000);
		WebElement hotelLink = driver.findElement(By.xpath("//a[@id='booking_engine_hotels']"));
		hotelLink.click();
		Thread.sleep(3000);
		String hotelPageTitle = driver.getTitle();
		System.out.println(hotelPageTitle);
		
		driver.findElement(By.xpath("//h2[text()='Hotel Discounts for you']//following-sibling::a")).click();
		//write window handle code below
				Set<String> handler=driver.getWindowHandles();
				// getWindowHandles method will return set object we need o iterate that to get windows Id
				Iterator<String> it=handler.iterator();
				
				String parentWindowId=it.next();
				System.out.println("ParentWindowsId : "+parentWindowId);
				
				String childWindowId=it.next();
				System.out.println("ChildWindowsId : "+childWindowId);
				
				driver.switchTo().window(childWindowId);
				
				System.out.println("Title of ChildWindowsBrowserPopUp : "+driver.getTitle());	
				
				System.out.println(5);
		
		
		System.out.println(driver.getTitle());
		
		List<WebElement> listOfOffers=driver.findElements(By.xpath("//span[@class='offerMainTitle']"));
		
		System.out.println(listOfOffers.size());
		
		for(int i=0;i<listOfOffers.size();i++){
			String offerType=listOfOffers.get(i).getText();
				System.out.println(offerType);
				
				if(offerType.equalsIgnoreCase("Best deals")){
					System.out.println(1);
					driver.findElement(By.xpath("//span[text()='Best deals ']")).click();
					
				}
				
		}
		
	
		
		
		
		
		

	}}

