package com.yatra.qa;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.el.VariableResolverImpl;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.yatra.qa.base.TestBase;
import com.yatra.qa.util.CommonOperation;
import com.yatra.qa.util.VariableDefine;

public class TestCase001 extends TestBase {

	@Test
	public void bookingHotelRoom() throws Exception {

		TestBase.intitalization();

		CommonOperation.getTitle(driver);
		// String homePageTitle = driver.getTitle();
		// printing the title of home page
		// System.out.println(homePageTitle);

		CommonOperation.click(driver,VariableDefine.hotelLink);
		// printing the title of hotel page
		CommonOperation.getTitle(driver);

		// entering city
		System.out.println(2);
		Thread.sleep(4000);
		CommonOperation.clear(driver, VariableDefine.searchCity);
		//CommonOperation.findElementById(driver, VariableDefine.searchCity).clear();
		System.out.println(1);
		Thread.sleep(4000);
		
		//CommonOperation.enterTextID(driver, VariableDefine.searchCity, VariableDefine.city);
		CommonOperation.enterText(driver, VariableDefine.searchCity, VariableDefine.city);
		//CommonOperation.enterTextID(driver, VariableDefine.searchCity, VariableDefine.city);
		Thread.sleep(5000);
		CommonOperation.findElementBy(driver, VariableDefine.searchCity).sendKeys(VariableDefine.enter);
		//CommonOperation.findElementById(driver, VariableDefine.searchCity).sendKeys(VariableDefine.enter);

		// entering check-in date and check-out date.
		
		CommonOperation.click(driver, VariableDefine.checkInId);
		//CommonOperation.clickID(driver, VariableDefine.checkInId);
		CommonOperation.click(driver, VariableDefine.checkInDateId);
		//CommonOperation.clickID(driver, VariableDefine.checkInDateId);
		CommonOperation.click(driver, VariableDefine.checkOutId);
		//CommonOperation.clickID(driver, VariableDefine.checkOutId);
		CommonOperation.click(driver, VariableDefine.checkOutDateId);
		//CommonOperation.clickID(driver, VariableDefine.checkOutDateId);

		// Selecting no of traveler
		String totalTravellerCount = CommonOperation.getTextByXpath(driver, VariableDefine.travellerCount);
		int totalCount = Integer.parseInt(totalTravellerCount);
		if (!"1".equals(totalCount)) {
			try {
				CommonOperation.clickXpath(driver, VariableDefine.dropdownArrow);
				for (int i = 0; i < totalCount - 1; i++) {
					CommonOperation.clickXpath(driver, VariableDefine.minusTraveler);

					int noOfTraveller = Integer.parseInt(prop.getProperty("totalNoOfPassenger"));
					for (int j = 1; j <= noOfTraveller - 1; j++) {
						CommonOperation.clickXpath(driver, VariableDefine.plusTraveler);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// click on search button
		Thread.sleep(3000);
		// driver.findElement(By.id("BE_hotel_htsearch_btn")).click();
		CommonOperation.clickID(driver, VariableDefine.searchHotelButton);
		Thread.sleep(3000);
		// new page opensUp
		// get the title of next page
		CommonOperation.getTitle(driver);

		CommonOperation.enterTextID(driver, VariableDefine.searchHotelTextBox, VariableDefine.hotelName);

		CommonOperation.findElementById(driver, VariableDefine.searchHotelTextBox).sendKeys(VariableDefine.enter);

		// click choose room
		Thread.sleep(5000);
		CommonOperation.clickXpath(driver, VariableDefine.chooseRoom);
		Thread.sleep(7000);

		// new window will open
		// write window handle code below
		Set<String> handler = driver.getWindowHandles();
		// getWindowHandles method will return set object we need o iterate that
		// to get windows Id
		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		System.out.println("ParentWindowsId : " + parentWindowId);

		String childWindowId = it.next();
		System.out.println("ChildWindowsId : " + childWindowId);

		driver.switchTo().window(childWindowId);

		System.out.println("Title of ChildWindowsBrowserPopUp : " + driver.getTitle());

		// get the title of the new window
		CommonOperation.getTitle(driver);

		CommonOperation.clickXpath(driver, VariableDefine.chooseRoom1);
		List<WebElement> listOFRoom = CommonOperation.findElementsByXpath(driver, VariableDefine.typesOfRooms);

		System.out.println(listOFRoom.size());
		for (int i = 0; i < listOFRoom.size(); i++) {
			VariableDefine.room = listOFRoom.get(i).getText();
			System.out.println(VariableDefine.room);
			if (prop.getProperty("roomType").equals(VariableDefine.room)) {
				VariableDefine.amountOfTheRoom = VariableDefine.beforexpathOfAmt + VariableDefine.room + VariableDefine.afterxpathOfAmt;
				String amount = CommonOperation.getTextByXpath(driver, VariableDefine.amountOfTheRoom);
				System.out.println(amount);

				int amt = Integer.parseInt(amount.replaceAll(",", ""));
				int maximumAmount = Integer.parseInt(prop.getProperty("maximumAmount"));
				if (amt <= maximumAmount) {
					VariableDefine.bookNow = VariableDefine.beforexpathOfBookNow + VariableDefine.room + VariableDefine.afterxpathOfBookNow;
					CommonOperation.clickXpath(driver, VariableDefine.bookNow);
					VariableDefine.actualResult = CommonOperation.getTextByXpath(driver, VariableDefine.reviewBooking);

				}

			}

		}

		Assert.assertEquals(VariableDefine.actualResult, VariableDefine.expectedResult);
	}
}
