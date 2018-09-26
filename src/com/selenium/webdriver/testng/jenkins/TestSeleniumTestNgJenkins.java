package com.selenium.webdriver.testng.jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSeleniumTestNgJenkins {
	WebDriver driver;
	
  @BeforeTest
  public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Namita-Pc\\Desktop\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get("https://www.facebook.com");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
			doRegistration();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
  @Test
  public void doRegistration(){
		try {
			driver.findElement(By.name("firstname")).sendKeys("Namita"); //text area
			
			driver.findElement(By.id("u_0_9")).click(); //radio button
			
			Select sel1 = new Select(driver.findElement(By.id("day"))); //Traditional =drop down //findElement-ByID
			sel1.selectByValue("1"); //selectByValue
			
			Select sel2 = new Select(driver.findElement(By.name("birthday_month"))); //findElement-ByName
			sel2.selectByVisibleText("Feb"); //SelectByVisibleText
			
			Select sel3 = new Select(driver.findElement(By.id("year")));
			sel3.selectByIndex(3); //SelectByIndex
			
			Thread.sleep(2000);
			
			driver.findElement(By.name("websubmit")).click(); //link //findElement-ByName
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
  
  @AfterTest
  public void closeBrowser(){
		driver.close();
	}
  
	
}
