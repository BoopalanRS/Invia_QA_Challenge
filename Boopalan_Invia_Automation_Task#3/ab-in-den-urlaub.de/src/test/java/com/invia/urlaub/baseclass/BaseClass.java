package com.invia.urlaub.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.invia.urlaub.pages.HomePage;
import com.invia.urlaub.pages.SearchResultPage;
import com.invia.urlaub.utility.BrowserHub;

public class BaseClass {
	
    public static WebDriver driver;
	
    protected HomePage homePage;
    
    protected SearchResultPage searchresultPage;
	
	@BeforeClass
	public void setup() {
		
	BrowserHub.initiateBrowser("Firefox", "https://www.ab-in-den-urlaub.de/");
	
	searchresultPage =PageFactory.initElements(driver, SearchResultPage.class);
	
	homePage =PageFactory.initElements(driver, HomePage.class);
	}
	
	@AfterClass
	public void close() {
	BrowserHub.quitBrowser();	
	}
	
	
	

}
