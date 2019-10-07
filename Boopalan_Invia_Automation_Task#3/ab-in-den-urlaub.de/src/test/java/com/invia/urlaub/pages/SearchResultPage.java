package com.invia.urlaub.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.invia.urlaub.baseclass.BaseClass;


public class SearchResultPage extends BaseClass{

	WebDriverWait wait;

		
	public SearchResultPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(css="label[for='filter-hotel-category5']")WebElement fiveStart;

	@FindBy(css="label[class*='color5']")WebElement happySmiley;

	@FindBy(css="ul li[data-criterion='price']")WebElement price;	

	@FindBy(css="li[class*='active changeDirection desc']")WebElement sortedPrise;

        public void selectFiveStartAndHappyFeedback() throws InterruptedException {     
        	
        	WebDriverWait wait = new WebDriverWait(driver, 10);
        	
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hotelListHotelBox")));
        	
        	fiveStart.click();  
        	
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hotelListHotelBox")));
        
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", happySmiley);
        		
        	happySmiley.click();
        
}        
        
        public void verifyFiltersSelected() {       	
        	        	
			List<WebElement> filters = driver.findElements(By.cssSelector("li[class*='filter-selected']"));
        	
        	int getSize = filters.size();
        	
        	Assert.assertEquals(getSize, 2);	
        }
        
        public void verifyPriceIsSortedInDescendingOrder() throws InterruptedException {
        	        	
        	       price.click();
        	       
        	       WebDriverWait wait = new WebDriverWait(driver, 10);
        	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hotelListHotelBox")));
        	       
        	       price.click();
        	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hotelListHotelBox")));
        	       
        	       sortedPrise.isDisplayed();
        	
        }

}