package com.yatra.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.yatra.qa.base.TestBase;

public class VariableDefine extends TestBase {
	
	
	public static String beforexpathChooseRoom="//a[@title='";
	public static String afterxpathChooseRoom="']//ancestor::div[@class='result-details-left']//following-sibling::div[@class='result-details-right show-gt-768 pr']//child::span[@class='new-blue-button medium choose-room-button nowrap ng-binding']";
	
	public static String beforexpathOfAmt="//p[text()='";
	public static String afterxpathOfAmt="']//following-sibling::div[@class='flex']//child::span[@class='rs ']//following-sibling::span ";
	
	public static String beforexpathOfBookNow="//p[text()='";
	public static String afterxpathOfBookNow="']//following-sibling::div[@class='flex']//child::button[@class='new-blue-button newBtn  choose-room-button ']";
			
	public static String beforexpathScrol="//p[text()='";
	public static String afterxpathScrol="']";
	
	
	public static By hotelLink=By.xpath("//a[@id='booking_engine_hotels']");
	public static By searchCity=By.id("BE_hotel_destination_city");
	public static By checkInId=By.id("BE_hotel_checkin_date");
	public static By checkInDateId=By.id(prop.getProperty("checkInDate"));
	public static By checkOutId=By.id("BE_hotel_checkout_date");
	public static By checkOutDateId=By.id(prop.getProperty("checkOutDate"));
	public static String city=prop.getProperty("city");
	public static String travellerCount="//span[@class='totalCount']";
	public static String dropdownArrow="//i[@class='icon icon-angle-right arrowpassengerBox']";
	public static String minusTraveler="//span[@class='pax-num-adult adultcount']//parent :: span[@class='pax-title']//following-sibling::div//child::span[@class='ddSpinnerMinus']";
	public static String plusTraveler="//span[@class='pax-num-adult adultcount']//parent :: span[@class='pax-title']//following-sibling::div//child::span[@class='ddSpinnerPlus']";
	public static String searchHotelButton="BE_hotel_htsearch_btn";
	public static String searchHotelTextBox="hotelFilterInput";
	public static String hotelName=prop.getProperty("hotel");
	public static Keys enter=Keys.ENTER;
	public static String chooseRoom=beforexpathChooseRoom+prop.getProperty("hotel")+afterxpathChooseRoom;
	//choose room option on next page 
	public static String chooseRoom1="//span[@id='choose-room-disable']";
	public static String typesOfRooms="//p[@class='cr-name ng-binding']";
	public static String amountOfTheRoom=null;
	public static String room;
	public static String bookNow=null;
	public static String expectedResult="Review Your Booking ";
	public static String reviewBooking="//*[@id='review-dom']/div/h3";
	public static String actualResult;


}
