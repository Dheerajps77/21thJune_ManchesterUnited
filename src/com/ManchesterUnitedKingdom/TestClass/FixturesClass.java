package com.ManchesterUnitedKingdom.TestClass;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ManchesterUnitedKingdom.TestBase.TestBase;
import com.ManchesterUnitedKingdom.TestPages.*;

public class FixturesClass extends TestBase
{
	Fixture Obj_FixturesPage;
	
	@Test(priority=0)
	public void FixturePageLink() throws InterruptedException
	{
		Obj_FixturesPage=PageFactory.initElements(driver, Fixture.class);
		Obj_FixturesPage.Fixt_link();		
		Thread.sleep(5000);	
		System.out.println("parent Window is "+driver.getTitle());
		Thread.sleep(5000);
		
		Set<String> child_window=driver.getWindowHandles();
		ArrayList<String> Ary=new ArrayList<>(child_window);
		
		driver.switchTo().window(Ary.get(0));
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(Ary.get(0)).close();
		
		Thread.sleep(2000);
		driver.switchTo().window(Ary.get(1));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
	}
	
	@Test(priority=1)
	public void CalenderForm() throws InterruptedException
	{
		Thread.sleep(4000);
		//driver.navigate().to("http://calendar.manutd.com/?t=y&int_source=muwebsite&int_medium=menu&int_campaign=fixturescalendar&int_content=fixturescalendar");
		Thread.sleep(4000);
		Obj_FixturesPage.Calender_Form("Dheeraj", "Singh", "DheerajPratapSingh@hcl.com");
	}
	
	@Test(priority=2)
	public void Verification_Google_Calender_title() throws InterruptedException
	{
		Obj_FixturesPage.Google_CalenderVerify();
		
	}
}
