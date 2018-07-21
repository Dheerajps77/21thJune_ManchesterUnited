package com.ManchesterUnitedKingdom.TestClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ManchesterUnitedKingdom.TestBase.TestBase;
import com.ManchesterUnitedKingdom.TestPages.*;

public class SignUpPageClass extends TestBase
{
	@Test
	public void register() 
	{
		SignUpPage Obj_register = PageFactory.initElements(driver, SignUpPage.class);
		Obj_register.SignUpModule("Dheeraj", "Singh", "DheerajPratapSingh@gmail.com", "Password", "Password");
	}

}
