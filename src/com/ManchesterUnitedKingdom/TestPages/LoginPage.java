package com.ManchesterUnitedKingdom.TestPages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

		WebDriver driver;

		@FindBy(how = How.XPATH, using = "//li[@id='gigyalogin']//a[@data-track-text='Log In']")
		WebElement Login_Link;

		@FindBy(how = How.XPATH, using = "//input[@name='username' and @placeholder='Email address *']")
		WebElement EmailAddress;

		@FindBy(how = How.XPATH, using = "//input[@type='password' and @placeholder='Password *']")
		WebElement Pass;

		@FindBy(how = How.XPATH, using = "//input[@value='LOG IN']")
		WebElement Login_button;

		@FindBy(how=How.XPATH, using="//span[text()='My United' and @class='web']")
		WebElement hover_MyUnited;
		
		@FindBy(how=How.XPATH, using="//a[@data-track-text='Settings']")
		WebElement _Setting;
		
		@FindBy(how=How.XPATH, using="//span[text()='My Profile']")
		WebElement _MyProfile;
		
		@FindBy(how=How.XPATH, using="//a[@class='profile-text accord-title']//span[text()='logout']")
		WebElement _logout;
		
		
		@FindBy(how=How.XPATH, using="//span[text()='Change Password']")
		WebElement _ChangePassword;
		
		@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='Current Password']")
		WebElement _CurrentPassword;
		
		@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='New Password']")
		WebElement _NewPassword;
		
		@FindBy(how=How.XPATH, using="//input[@data-gigya-placeholder='Retype new password']")
		WebElement _RetypePassword;
		
		@FindBy(how=How.XPATH, using="//input[@value='Submit' and @class='gigya-input-submit']")
		WebElement _SubmittPassword;
		
		@FindBy(how=How.XPATH, using="//h2[text()='Your password has been changed successfully.']")
		WebElement _Message;
		
		@FindBy(how=How.XPATH, using="//input[@type='button' and @value='Continue']")
		WebElement _ContinueButton;
		
		@FindBy(how=How.XPATH, using="//div[contains(@class,'gigya-screen-dialog-caption')]")
		WebElement _TitleOfChangePassword;
		
		
		@FindBy(how=How.XPATH, using="//a[text()='Forgot password?']")
		WebElement _ForgotPassword;
		
		@FindBy(how=How.XPATH, using="//input[@placeholder='Email address *']")
		WebElement _Enter_emailID;
		
		@FindBy(how=How.XPATH, using="//input[@type='submit' and @value='Submit']")
		WebElement _Submit;
		
		@FindBy(how=How.XPATH, using="//input[@type='text']")
		WebElement YopM_EnterYOurEMailID;
		
		@FindBy(how=How.XPATH, using="//div[contains(@class,'um')]//a[@href='m.php?b=testloginmanchester&id=me_ZGtjAmVjZGR0BQD5ZQNjZmxjZmH3Zj==']")
		WebElement YopM_PasswordReset_Link;
		
		@FindBy(how=How.XPATH, using="//font[text()='RESET PASSWORD']")
		WebElement Yop_submit;
		
		@FindBy(how=How.XPATH, using="//input[@title='Check inbox @yopmail.com']")
		WebElement Check_inboxButton;
		
		@FindBy(how=How.XPATH, using="//a[@rel='nofollow']//font")
		WebElement Reset_Button;
		
		@FindBy(how=How.XPATH, using="//label[@for='gigya-password-newPassword']//span[text()='Please enter a new password:']//following::input[1]")
		WebElement _newPassword;
		
		@FindBy(how=How.XPATH, using="//label[@for='gigya-password-passwordRetype']//span[text()='Confirm your new password:']//following::input[1]")
		WebElement _passwordRetype;
		
		@FindBy(how=How.XPATH, using="//input[@type='button' and @value='Reset']")
		WebElement _ResetButton;
		
		@FindBy(how=How.XPATH, using="//h2[text()='Your password has been reset successfully.']")
		WebElement getResetPasswordText;
		
		
		@FindBy(how=How.XPATH, using="//input[@value='Continue']")
		WebElement _ContinueButtonAfterResetPassword;
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		public void LoginPag(String UserID, String Password) throws InterruptedException {
			Login_Link.click();
			EmailAddress.sendKeys(UserID);
			Pass.sendKeys(Password);
			Login_button.click();
			Thread.sleep(3000);
		}
		
		public void ChangePassword() throws InterruptedException
		{
			
			_ChangePassword.click();
			_CurrentPassword.sendKeys("India@3232");
			_NewPassword.sendKeys("India@32321");
			_RetypePassword.sendKeys("India@32321");
			Thread.sleep(2000);
			_SubmittPassword.click();
			_ContinueButton.click();
			
		}
		public void LoginOut()throws InterruptedException
		{
			Actions action=new Actions(driver);
			action.moveToElement(hover_MyUnited).build().perform();
			Thread.sleep(2000);
			_Setting.click();
			_MyProfile.click();
			Thread.sleep(2000);
			ChangePassword();
			
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
			_logout.click();
			System.out.println("Test case passed...");
			Thread.sleep(2000);
		}
		
	
		
		public void ForgetPassword(String emailID, String emailID2, String firstPassword, String secondPassword)throws InterruptedException
		{
			Login_Link.click();
			_ForgotPassword.click();
			_Enter_emailID.sendKeys(emailID);
			
			_Submit.click();
			Thread.sleep(6000);
			
			driver.navigate().to("http://www.yopmail.com/en/");
			Thread.sleep(2000);
			
			YopM_EnterYOurEMailID.clear();
			YopM_EnterYOurEMailID.sendKeys(emailID2);
			
			Thread.sleep(2000);
			Check_inboxButton.click();
			
			Thread.sleep(3000);
			driver.switchTo().frame("ifmail");
			Reset_Button.click();
			
			Thread.sleep(3000);
			
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			
			String parent=it.next();
			System.out.println("The parent window ID is : "+parent);
			driver.switchTo().window(parent);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println("=======================================");
			
			Thread.sleep(3000);
			driver.switchTo().window(parent).close();
			
			String child=it.next();
			System.out.println("The child window ID is : "+child);
			driver.switchTo().window(child);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			//driver.switchTo().window(child).close();
			Thread.sleep(3000);
			
			_newPassword.sendKeys(firstPassword);
			_passwordRetype.sendKeys(secondPassword);
			_ResetButton.click();
			Thread.sleep(3000);
			
			String get_ResetPasswordMessage=getResetPasswordText.getText();
			System.out.println("===================================");
			System.out.println(get_ResetPasswordMessage);
			System.out.println("===================================");
			
			String Expected_Result="Your password has been reset successfully.";
			Assert.assertEquals(get_ResetPasswordMessage, Expected_Result, "The messages is showing correct.... Test case passed for this secenario");
			
			_ContinueButtonAfterResetPassword.click();
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			
		}

	}
