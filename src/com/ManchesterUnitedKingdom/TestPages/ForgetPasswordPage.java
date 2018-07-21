package com.ManchesterUnitedKingdom.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgetPasswordPage {
		WebDriver driver;
		
		public ForgetPasswordPage(WebDriver driver) 
		{
			this.driver=driver;
		}
		@FindBy(how=How.XPATH, using="//a[text()='Forgot password?']")
		WebElement forgetpassword;
		
		@FindBy(how=How.XPATH, using="//input[@data-gigya-name='loginID' and @placeholder='Email address *']")
		WebElement emailID;
		
		@FindBy(how=How.XPATH, using="//input[@class='gigya-input-submit' and @value='Submit']")
		WebElement submit;
		
		public void ForgetPasswordFlow(String frogetEmailID)
		{

			forgetpassword.click();
			emailID.sendKeys(frogetEmailID);
			submit.click();
		}
	}
