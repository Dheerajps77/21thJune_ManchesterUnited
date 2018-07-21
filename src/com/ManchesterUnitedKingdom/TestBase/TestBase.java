package com.ManchesterUnitedKingdom.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase
{
	public static WebDriver driver;
		
	@BeforeTest
	public void InvokeBroswer()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.manutd.com/");
	}
	
	@AfterClass
	public void CloseBroswer() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}

}
