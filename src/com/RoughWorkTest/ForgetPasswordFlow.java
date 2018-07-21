package com.RoughWorkTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ForgetPasswordFlow {
	
	public static void main(String[] ar) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.manutd.com/");
		
		driver.findElement(By.xpath("//li[@id='gigyalogin']//a[@data-track-text='Log In']")).click();
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email address *']")).sendKeys("testloginmanchester@yopmail.com");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
		Thread.sleep(6000);
		driver.navigate().to("http://www.yopmail.com/en/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testloginmanchester@yopmail.com");
		driver.findElement(By.xpath("//input[@title='Check inbox @yopmail.com']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame("ifmail");
		driver.findElement(By.xpath("//a[@rel='nofollow']//font")).click();
		
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
		
		driver.findElement(By.xpath("//label[@for='gigya-password-newPassword']//span[text()='Please enter a new password:']//following::input[1]")).sendKeys("India@3232");
		driver.findElement(By.xpath("//label[@for='gigya-password-passwordRetype']//span[text()='Confirm your new password:']//following::input[1]")).sendKeys("India@3232");
		driver.findElement(By.xpath("//input[@type='button' and @value='Reset']")).click();
		Thread.sleep(3000);
		
		String get_status=driver.findElement(By.xpath("//h2[text()='Your password has been reset successfully.']")).getText();
		System.out.println("===================================");
		System.out.println(get_status);
		System.out.println("===================================");
		
		String Expected_Result="Your password has been reset successfully.";
		Assert.assertEquals(get_status, Expected_Result, "The messages is showing correct.... Test case passed for this secenario");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
}
