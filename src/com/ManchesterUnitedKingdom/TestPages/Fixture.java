package com.ManchesterUnitedKingdom.TestPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Fixture 
{
	
	WebDriver driver;
	Actions action;
	
	public Fixture(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Fixtures' and @class='web']")
	WebElement Fixture_link;
	
	@FindBy(how=How.XPATH, using="//a[@data-track-text='Fixtures Calendar']")
	WebElement Fixture_Calender_link;
	
	@FindBy(how=How.XPATH, using="//input[@id='firstname-control']")
	WebElement Fname;
	
	@FindBy(how=How.XPATH, using="//input[@id='lastname-control']")
	WebElement Lname;
	
	@FindBy(how=How.XPATH, using="//input[@id='email-control']")
	WebElement email;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control']")
	WebElement TimeZone;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-day']")
	WebElement DDay;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-month']")
	WebElement Mmonth;
	
	@FindBy(how=How.XPATH, using="//select[@id='select-control-year']")
	WebElement Yyear;
	
	@FindBy(how=How.XPATH, using="//label[@for='no-preference']")
	WebElement RadioButton;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(how=How.XPATH, using="//div[@id='add-googlecalendar']")
	WebElement Google_Calender;
	
	public void Fixt_link() throws InterruptedException
	{
		action=new Actions(driver);
		action.moveToElement(Fixture_link).build().perform();
		Thread.sleep(3000);
		
		Fixture_Calender_link.click();
	}
	
	public void Calender_Form(String FirstName, String LastName, String EmailID) throws InterruptedException
	{
		
		Fname.sendKeys(FirstName);
		Lname.sendKeys(LastName);
		email.sendKeys(EmailID);
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		TimeZone.click();
		Select timezone=new Select(TimeZone);
		timezone.selectByVisibleText("India");
		
		DDay.click();
		Select BDate=new Select(DDay);
		BDate.selectByVisibleText("26");
		
		Mmonth.click();
		Select BMonth=new Select(Mmonth);
		BMonth.selectByVisibleText("Dec");
		
		Yyear.click();
		Select BYear=new Select(Yyear);
		BYear.selectByVisibleText("1992");
		
		System.out.println("Is Radio Button is Enabled ? Answer is ----> "+RadioButton.isEnabled());
		System.out.println("Is Radio Button is Enabled ? Answer is ----> "+RadioButton.isDisplayed());
		RadioButton.click();
		
		System.out.println("Is Submit Button is Enabled? Answer is ----> "+submitButton.isEnabled());
		System.out.println("Is Submit Button is Enabled? Answer is ----> "+submitButton.isDisplayed());
		submitButton.click();
		
	}
	
	public void Google_CalenderVerify() throws InterruptedException
	{
		Google_Calender.click();
		Thread.sleep(2000);
		System.out.println("The current title of google Calender is : "+driver.getTitle());
		System.out.println("The Current URL of the google calender page is "+ driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.navigate().back();
		
	}

}
