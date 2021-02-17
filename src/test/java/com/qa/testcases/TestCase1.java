package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void config() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (18)\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.wikipedia.org/");
		
		Thread.sleep(3000);
	}
	
	
	@Test(priority='1')
	public void WikisearchboxTest() throws InterruptedException   // Test Method
	{

		String title= driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//input[@id='searchInput']")).clear();
		
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium Automation");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
			
	}
	@Test(priority='2')
	public void WikiMainPageTest()
	{
		String title1= driver.getTitle();
		System.out.println(title1);
	driver.findElement(By.linkText("Main page")).click();	
		
		driver.findElement(By.linkText("Create account")).click();
		
		driver.findElement(By.xpath("//input[@id='wpName2']")).sendKeys("userX");
		String title2= driver.getTitle();
		System.out.println(title2);
				
	}
	
	@Test(priority='3')
	public void ISTest() throws InterruptedException
	{
		driver.navigate().to("https://ironspider.ca/forms/dropdowns.htm");
		Select li = new Select(driver.findElement(By.xpath("//select[@name='coffee']")));
		li.selectByVisibleText("With cream & sugar");
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closebrowser()
	{
		System.out.println(" close the browser");
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
