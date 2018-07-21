package com.RoughWorkTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataDriven 
{
	
	WebDriver driver;
	@BeforeClass
	public void OpenBroswer()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com/");
		
	}
	
	@Test(dataProvider="LoginInfo")
	public void Login(String ID, String Pass)
	{
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(ID);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(Pass);		
	}
	
	
	@DataProvider(name="LoginInfo")
	public Object[][] DataDrivenExample(){
		
		Object[][] data=new Object[2][2];
		data[0][0]="DheerajpratapSing@gmail.com";
		data[0][1]="Password1";
		data[1][0]="DheerajpratapSingh12333@gmail.com";
		data[1][1]="Password2";
		return data;
	}
	
	@AfterClass
	public void CloseBroswer()
	{
		driver.close();
		
	}

}
