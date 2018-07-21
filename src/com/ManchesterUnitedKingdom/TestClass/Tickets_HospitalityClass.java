package com.ManchesterUnitedKingdom.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ManchesterUnitedKingdom.TestBase.TestBase;
import com.ManchesterUnitedKingdom.TestPages.Tickets_HospitalityPage;

public class Tickets_HospitalityClass extends TestBase
{
	Tickets_HospitalityPage ObjTickets_Hospitality;
	
	SoftAssert s1=new SoftAssert();
	
	@Test(priority=0)
	public void Match_ticketsFlow() throws InterruptedException
	{
		ObjTickets_Hospitality=PageFactory.initElements(driver, Tickets_HospitalityPage.class);
		ObjTickets_Hospitality.click_Tickets_Hospitality_link();
		ObjTickets_Hospitality.Tour_Tickets_2018();
	}
	
	@Test(priority=1)
	public void Tour_Tickets() throws InterruptedException{
		
		ObjTickets_Hospitality.Tour_Tickets_2018();
	}

	@Test(priority=2)
	public void ClubAmerica()throws InterruptedException
	{
		
		ObjTickets_Hospitality.Club_America();
		
		String titleOf=driver.findElement(By.xpath("//div[contains(@class,'landing-modal-header__event-name')]")).getText();
		
		System.out.println(titleOf);
		
		s1.assertEquals(titleOf, "Manchester United v Club America");
		System.out.println("Last statment got executed...");
		s1.assertAll();
		System.out.println("Title is OK. NO issue with title");
	}
}
