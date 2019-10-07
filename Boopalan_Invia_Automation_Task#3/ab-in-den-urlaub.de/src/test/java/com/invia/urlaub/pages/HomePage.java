package com.invia.urlaub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.invia.urlaub.baseclass.BaseClass;


public class HomePage extends BaseClass{

	WebDriverWait wait;

		
	public HomePage(WebDriver ldriver)
	{
		BaseClass.driver=ldriver;
		
	}
		
	@FindBy(css="label[class*='item-hotel']")WebElement hotelCity;	
	
	@FindBy(xpath="//*[@id=\"base[searchTerm]\"]")WebElement enterHotel;
	
	@FindBy(xpath="(//div[@class='aiduac-content external']//ul//li//li)[1]")WebElement citySuggestion;
	
	@FindBy(xpath="//form[@id='hotel']//div[contains(@class,'wrapper-start')]")WebElement startDatePicker;

	@FindBy(xpath="//form[@id='hotel']//div[contains(@class,'wrapper-end')]")WebElement endDatePicker; 

	@FindBy(css="div[class*='start-input'] div>span[class*='next']")WebElement nextInStartDatePicker;

	@FindBy(css="div[class='datepicker-layer start-input'] td[data-date='2019-11-25']")WebElement startDate;

	@FindBy(css="div[class='datepicker-layer end-input'] td[data-date='2019-11-29']")WebElement endDate;

	@FindBy(css="div[class*='input-box-size-1'] label[class*='person']")WebElement selectAdultsOption;

	@FindBy(css="div[class*='input-box-size-1'] div[class='adult'] div")WebElement noOfAdultsCount;

	@FindBy(css="select[id*='numberOfRooms']")WebElement selectRoomDropDown;

	@FindBy(css="select[id*='numberOfRooms'] option[label='1 Zimmer']")WebElement oneRoom;
	
	@FindBy(xpath="(//input[@id='submit'])[2]")WebElement submitButton;
	
	
	
	public void clickHotelCity(String cname) throws InterruptedException
	{
					
		hotelCity.click();		

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement enterHotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("base[searchTerm]"))); 
				
		enterHotel.sendKeys(cname);
		
		citySuggestion.click();
		
	}

        public void selectStartAndEndDate() throws InterruptedException {   
        	
        	WebDriverWait wait = new WebDriverWait(driver, 10);
    		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='hotel']//div[contains(@class,'wrapper-start')]"))); 
        	
        	startDatePicker.click();
        	
        	nextInStartDatePicker.click();
        	
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	executor.executeScript("arguments[0].click();", startDate);         	              	
        	executor.executeScript("arguments[0].click();", endDate); 
        	
        }
        
        public void selectRoomCountAndSubmit() throws InterruptedException {        	        
        	
        	selectRoomDropDown.click();        	
        	
        	Select drpCountry = new Select(selectRoomDropDown);
    		drpCountry.selectByIndex(0);
    		
    		submitButton.click();
        
}        

}