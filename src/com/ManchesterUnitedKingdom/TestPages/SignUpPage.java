package com.ManchesterUnitedKingdom.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage 
{
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	@FindBy(how = How.XPATH, using = "//ul//li[5]//a[@data-track-text='Sign Up']")
	WebElement SignUpLink;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='First name']")
	WebElement FirstName;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Surname']")
	WebElement SurName;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Email address']")
	WebElement EMail_address;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Password']")
	WebElement Pass_word;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Confirm password']")
	WebElement Con_Pass_word;
	
	public void SignUpModule(String FN, String SN, String Email, String PW, String CP)
	{
		SignUpLink.click();
		FirstName.sendKeys(FN);
		SurName.sendKeys(SN);
		EMail_address.sendKeys(Email);
		Pass_word.sendKeys(PW);
		Con_Pass_word.sendKeys(CP);
	}
}