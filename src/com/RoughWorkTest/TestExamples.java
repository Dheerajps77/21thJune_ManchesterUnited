package com.RoughWorkTest;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestExamples 
{
	
	public static void main(String[] agr) throws InterruptedException{
		
	
		System.setProperty("webdriver.chrome.driver", "E:\\Selnium\\BrowserPath\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.manutd.com/");
		
		WebElement Fixture_link=driver.findElement(By.xpath("//span[text()='Fixtures' and @class='web']"));
		WebElement Fixture_Calender_link=driver.findElement(By.xpath("//a[@data-track-text='Fixtures Calendar']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(Fixture_link).build().perform();
		Thread.sleep(3000);
		
		Fixture_Calender_link.click();
		
		Set<String> child_window=driver.getWindowHandles();
		ArrayList<String> Ary=new ArrayList<>(child_window);
		
		driver.switchTo().window(Ary.get(0));
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Thread.sleep(4000);
		driver.switchTo().window(Ary.get(1));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//input[@id='firstname-control']")).sendKeys("Dheeeraj");
		driver.findElement(By.xpath("//input[@id='lastname-control']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='email-control']")).sendKeys("DheerajPratapSing@gmail.com");
	}

}
