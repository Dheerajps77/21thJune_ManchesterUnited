package com.ManchesterUnitedKingdom.TestClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ManchesterUnitedKingdom.TestBase.TestBase;
import com.ManchesterUnitedKingdom.TestPages.HelpPage;


public class HelpPageClass extends TestBase
{
	HelpPage Obj_HelpPage;	
	WebDriverWait wait;
	
	@Test(priority=0,description="Action will be perform for HelpPage")
	public void Help() throws InterruptedException
	{
		Obj_HelpPage=PageFactory.initElements(driver, HelpPage.class);
		Obj_HelpPage.Help_link();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		Obj_HelpPage.Contact_link();
	}
	
	@Test(priority=1)
	public void TitleOfPage_Verification()
	{	
		String currentTitle=Obj_HelpPage.VerifyTitleOfPage();
		Assert.assertEquals(currentTitle, "Contact Us | Man Utd Phone Numbers & Email Addresses | Official Manchester United Website");
		//Assert.assertTrue(true, "Contact Us | Man Utd Phone Numbers & Email Addresses | Official Manchester United Website");
		System.out.println("Current title of Page : "+currentTitle);
	}
	
	@Test(priority=2)
	public void TitleOfTicketSales() throws InterruptedException
	{
		
		String CurrentTitleofTicketSales=Obj_HelpPage.VerifyTicketSale_title();
		Assert.assertEquals(CurrentTitleofTicketSales, "Match ticket and Season Ticket sales and enquiries");
		//Assert.assertTrue(true, "Match ticket and Season Ticket sales and enquiries");
		System.out.println("Title of ticketSales : "+CurrentTitleofTicketSales);
		System.out.println("Clicked on the phone number of TicketSales");		
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void Total_numberOfPhoneNumber()
	{
		List<WebElement> textOfAllPhoneNumber=driver.findElements(By.xpath("//div[contains(@class,'contact-us__no')]//a"));
		
		int total_size=textOfAllPhoneNumber.size();
		
		System.out.println("Total number of phone present in the Contact Us are as follow : "+total_size);
		System.out.println("===========================================================================");
		System.out.println("Below are the Phone Number which is present in Contact Us page");
		
		for(int i=0;i<total_size;i++)
		{
			String PrintAllNumber=textOfAllPhoneNumber.get(i).getText();
			System.out.println(PrintAllNumber);
		}	
		
	}
	
	@Test(priority=4)
	public void Total_numberOf_Title_OfPhoneNumber()
	{
		List<WebElement> TitleOf=driver.findElements(By.xpath("//div[contains(@class,'contact-us__phone--list')]//p"));
		int total_size_ofTitle=TitleOf.size();
		
		System.out.println("Total number of Title for each phonumber in the Contact Us are as follow : "+total_size_ofTitle);
		System.out.println("===========================================================================");
		System.out.println("Below are all titles of Phone Number which is present in Contact Us page");
		
		for(int i=0;i<total_size_ofTitle;i++)
		{
			String PrintTitle=TitleOf.get(i).getText();
			System.out.println(PrintTitle);
			
		}
	}
}

