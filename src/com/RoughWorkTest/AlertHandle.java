package com.RoughWorkTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AlertHandle 
{
	
	public static void main(String[] arg) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		
		driver.get("http://www.myhcl.com/");
		
		driver.findElement(By.xpath("//input[@name='txtUserID']")).sendKeys("dheeraj.p");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("123");
		
		WebElement element=driver.findElement(By.xpath("//select[@name='ddlDomain']"));
		
		Thread.sleep(3000);
		
		//element.click();
		Select select=new Select(element);
		select.selectByVisibleText("HCLTECH");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		driver.findElement(By.xpath("//a[@id='setting']//div[contains(@class,'userName')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//ul[@id='acnt-info']//li[4]//a")).click();
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		Thread.sleep(3000);
		alert.accept();
	}

}
