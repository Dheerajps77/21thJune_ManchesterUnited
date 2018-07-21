package com.ManchesterUnitedKingdom.Utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots 
{
	WebDriver driver;
	static TakesScreenshot take_screenshot;
	
	public static void CaptureScreenshot(WebDriver driver, String Path)
	{
		
		take_screenshot=(TakesScreenshot)driver;
		
		
	}

}
