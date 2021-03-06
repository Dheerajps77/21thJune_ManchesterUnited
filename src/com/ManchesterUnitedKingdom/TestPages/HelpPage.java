package com.ManchesterUnitedKingdom.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HelpPage 
{
	
	WebDriver driver;
	
	public HelpPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(how=How.XPATH, using="//a[text()='Help']")
	WebElement Help_Link;
	
	@FindBy(how=How.XPATH, using="//h2[text()='Contact Us']//following::div[1]")
	WebElement Contact_Us_link;
	
	@FindBy(how=How.XPATH, using="//p[text()='Match ticket and Season Ticket sales and enquiries']")
	WebElement text_TicketSales_enquiries;
	
	@FindBy(how=How.XPATH, using="//p[text()='Match ticket and Season Ticket sales and enquiries']//following::div[1]//a[@data-track-type='link']")
	WebElement Phone_number_of_TicketSales;
	
//	@FindBy(how=How.XPATH, using="//div[contains(@class,'contact-us__no')]//a")
//	public static List<WebElement> Print_Values_OfPhoneNumber;
//	
//	@FindBy(how=How.XPATH, using="//div[contains(@class,'contact-us__phone--list')]//p")
//	public static List<WebElement> TitleOfEach_PhoneNumber;
	
	public void Help_link()
	{
		
		Help_Link.click();
		
	}
	public void Contact_link()
	{
		
		Contact_Us_link.click();
		
	}
	
	public String VerifyTitleOfPage()
	{
		String Title=driver.getTitle();
		return Title;
		
	}
	
	public String VerifyTicketSale_title()
	{
		String Text_ofTicketSale=text_TicketSales_enquiries.getText();
		return Text_ofTicketSale;
	}	
}