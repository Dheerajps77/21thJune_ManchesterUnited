package com.ManchesterUnitedKingdom.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ManchesterUnitedKingdom.TestBase.TestBase;
import com.ManchesterUnitedKingdom.TestPages.*;

public class LoginAndForgetPasswordClass extends TestBase
{
	LoginPage Obj_Login;

		@Test(priority=0)
		public void LoginPageModuletest() throws Throwable
		{
			
			Obj_Login=PageFactory.initElements(driver, LoginPage.class);
			Obj_Login.LoginPag("testloginmanchester@yopmail.com", "India@3232");
			Thread.sleep(3000);	
		}
		
		@Test(dependsOnMethods={"LoginPageModuletest"})
		public void LogOUt() throws InterruptedException
		{
			
			Obj_Login.LoginOut();
			
		}
		
		@Test(dependsOnMethods={"LogOUt"})
		public void ForgetPassword()throws InterruptedException
		{
			
			Obj_Login.ForgetPassword("testloginmanchester@yopmail.com", "testloginmanchester@yopmail.com","India@32322","India@32322");
			
		}
		
		@Test(enabled=false)//(dependsOnMethods={"LoginPageModuletest"})
		public void frogetPassword() throws InterruptedException
		{
			ForgetPasswordPage Obj_PasswordReset=PageFactory.initElements(driver, ForgetPasswordPage.class);
			Obj_PasswordReset.ForgetPasswordFlow("DheerajPratapSingh@muk.com");
			Thread.sleep(3000);
			driver.navigate().to("https://www.manutd.com/");
		}
	}