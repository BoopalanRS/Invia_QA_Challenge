package com.invia.urlaub.testcases;


import org.testng.annotations.Test;

import com.invia.urlaub.baseclass.BaseClass;

public class HomePageTest extends BaseClass {
		
	
		
	@Test(priority =1)
	public void searchCityAndSelectDate() throws InterruptedException
	{					
		
		
		homePage.clickHotelCity("Madrid");		
		
		homePage.selectStartAndEndDate();
		
				
	} 
	
	@Test(priority =2)
	public void selectRoomAndSubmit() throws InterruptedException
	{								
		
		homePage.selectRoomCountAndSubmit();
		
				
	} 
	
	@Test(priority =3)
	public void selectFiveStartAndSortByDescendingOrder() throws InterruptedException
	{										
		
		searchresultPage.selectFiveStartAndHappyFeedback();
		
		searchresultPage.verifyFiltersSelected();
				
		searchresultPage.verifyPriceIsSortedInDescendingOrder();
				
	}
	
	

}
