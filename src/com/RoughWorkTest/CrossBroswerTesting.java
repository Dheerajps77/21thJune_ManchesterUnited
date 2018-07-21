package com.RoughWorkTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class CrossBroswerTesting {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void InvokedBroswer(String browser) {

		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"E:\\Selnium\\BrowserPath\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
			
		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
			
		} else if (browser.equalsIgnoreCase("ff")) {

			System.setProperty("webdriver.gecko.driver",
					"E:\\Files\\Selenium_Jars_Path\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.manutd.com/");
		}
	}
	
	@Test
	public void Hello()
	{
		
		System.out.println("Hello there .....");
		
	}

	@AfterTest
	public void closeBroswer() {

		driver.quit();

	}
}
