package com.expedia.Flights;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestBasicfunctions {

	public String baseUrl1 = ("https://www.expedia.com/");
	String driverPath = "C:\\Users\\rassools\\Desktop\\ChromeD\\chromedriver.exe";
	public WebDriver driver;


	@BeforeClass
	public void beforesetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rassools\\Desktop\\ChromeD\\chromedriver.exe");
		;
		driver = new ChromeDriver();
		baseUrl1 = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void basicWeb() throws InterruptedException {
		driver.get(baseUrl1);
		WebElement clickFlightstab = driver.findElement(By.id("tab-flight-tab-hp"));
		clickFlightstab.click();
		
		WebElement FlyingFrom =driver.findElement(By.id("flight-origin-hp-flight"));
		FlyingFrom.sendKeys("New York");
		
		WebElement FlyingTo = driver.findElement (By.id("flight-destination-hp-flight"));
		FlyingTo.sendKeys("Canada");
		
		WebElement departing = driver.findElement(By.id("flight-departing-hp-flight"));
		departing.click();
		
		WebElement datepickerdepart = driver.findElement
		(By.xpath("//div[@id='flight-departing-wrapper-hp-flight']/div[@class='datepicker-dropdown']/div/div[3]/table[@class='datepicker-cal-weeks']/tbody/tr[2]/td[2]/button[@type='button']"));
		datepickerdepart.click();
		
		WebElement ClearReturnBlock = driver.findElement(By.id("flight-returning-hp-flight"));
		ClearReturnBlock.clear();
		
		WebElement returning = driver.findElement(By.id("flight-returning-hp-flight"));
		returning.sendKeys("09/06/2018");
		
		WebElement clickSubmit = driver.findElement(By.xpath("/html//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']"));
		clickSubmit.click();
		
	}

	@AfterClass
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		

	}
}
