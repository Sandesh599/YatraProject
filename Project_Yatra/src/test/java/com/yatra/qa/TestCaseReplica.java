package com.yatra.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCaseReplica {

	WebDriver driver;
	//String hotel="The Pride Hotel Nagpur";
	//String checkInDate = "25/02/2020";
	//String checkOutDate = "26/02/2020";
	//int numOfTraveller = 1;
	//String room="Suite Single";
	//int maxAmt=10000;
	
		
	
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
			public void bookingHotelRoom() throws InterruptedException, IOException {
				
				FileInputStream fis=new FileInputStream("config.propertie");
				Properties prop= new Properties();
				prop.load(fis);

		
				// System.setProperty("webdriver.chrome.driver", "chromedriver78.exe");
		
				// ChromeOptions opt=new ChromeOptions();
				// opt.addArguments("--disable-notification");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));
				driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
				String homePageTitle = driver.getTitle();
				System.out.println(homePageTitle);
				
				WebElement hotelLink = driver.findElement(By.xpath("//a[@id='booking_engine_hotels']"));
				hotelLink.click();
				String hotelPageTitle = driver.getTitle();
				System.out.println(hotelPageTitle);
				// WebElement enterCity=
				Thread.sleep(5000);
				driver.findElement(By.id("BE_hotel_destination_city")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("BE_hotel_destination_city")).sendKeys("Nagpur");
				Thread.sleep(3000);
				driver.findElement(By.id("BE_hotel_destination_city")).sendKeys(Keys.ENTER);
				driver.findElement(By.id("BE_hotel_checkin_date")).click();
				driver.findElement(By.id(prop.getProperty("checkInDate"))).click();
				driver.findElement(By.id("BE_hotel_checkout_date")).click();
				driver.findElement(By.id(prop.getProperty("checkOutDate"))).click();
				
				
				
				String totalPassengerCount = driver.findElement(By.xpath("//span[@class='totalCount']")).getText();
				System.out.println(totalPassengerCount);
				int w = Integer.parseInt(totalPassengerCount);
				if (!"1".equals(totalPassengerCount)) {
					System.out.println(1);
					driver.findElement(By.xpath("//i[@class='icon icon-angle-right arrowpassengerBox']")).click();
					for (int i = 0; i < w - 1; i++) {
						driver.findElement(By.xpath("//span[@class='pax-num-adult adultcount']//parent :: span[@class='pax-title']//following-sibling::div//child::span[@class='ddSpinnerMinus']")).click();
						int noOfTraveller=Integer.parseInt(prop.getProperty("totalNoOfPassenger"));
						for (int j = 1; j <=noOfTraveller-1; j++) {
							driver.findElement(By.xpath("//span[@class='pax-num-adult adultcount']//parent :: span[@class='pax-title']//following-sibling::div//child::span[@class='ddSpinnerPlus']")).click();
						}
					}
		
				}
				
				Thread.sleep(3000);
				
				driver.findElement(By.id("BE_hotel_htsearch_btn")).click();
				Thread.sleep(5000);
				// get the title of next page
				System.out.println(driver.getTitle());
				driver.findElement(By.id("hotelFilterInput")).sendKeys(prop.getProperty("hotel"));
				driver.findElement(By.id("hotelFilterInput")).sendKeys(Keys.ENTER);
				//click choose room
				System.out.println(3);
				Thread.sleep(5000);
				driver.findElement(By.xpath(beforexpathChooseRoom+prop.getProperty("hotel")+afterxpathChooseRoom)).click();
				System.out.println(4);
				Thread.sleep(7000);
				//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
				
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
				
				//System.out.println(driver.getTitle());
				System.out.println(driver.findElement(By.xpath("//*[@id='page-nav-wrapper']/div/div[1]/div[1]/p[1]/span[1]")).getText());
				
				driver.findElement(By.xpath("//span[@id='choose-room-disable']")).click();
				List<WebElement> typesOFRoom=driver.findElements(By.xpath("//p[@class='cr-name ng-binding']"));
				System.out.println(typesOFRoom.size());
				for(int i=0;i<typesOFRoom.size();i++){
				String room=typesOFRoom.get(i).getText();
					System.out.println(room);
					
					if(room.equals(prop.getProperty("roomType"))){
						
		//				WebElement element = driver.findElement(By.xpath(beforexpathScrol+room+afterxpathScrol));
		//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//				Thread.sleep(500); 
					String amount=driver.findElement(By.xpath(beforexpathOfAmt+room+afterxpathOfAmt)).getText();
					System.out.println(amount);
					System.out.println(7);
					
					int amt=Integer.parseInt(amount.replaceAll(",", ""));
					System.out.println(8);
				int	maxAmt=Integer.parseInt(prop.getProperty("maximumAmount"));
					if(amt<=maxAmt){
						System.out.println(9);
						driver.findElement(By.xpath(beforexpathOfBookNow+room+afterxpathOfBookNow)).click();
						System.out.println("===========TestCase001 Pass=============");
						
					}else{
						System.out.println("==========TestCase001 Fail==============");
					}
						
						
					}
					
				}
			}
		}

