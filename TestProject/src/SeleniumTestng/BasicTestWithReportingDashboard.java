package SeleniumTestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasicTestWithReportingDashboard {

	public String baseUrl = ("https://www.expedia.com");
	String driverPath = "C:\\Users\\rassools\\Desktop\\ChromeD\\chromedriver.exe";
	public WebDriver driver;
	
////adding a reporting dashboard///
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforesetup() {
		baseUrl = "https://www.expedia.com";
		report = new ExtentReports("C:\\Global_K\\TestProject\\basicbrowsertest.html");
		//add the report logs
		test =report.startTest("Verify homepage test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rassools\\Desktop\\ChromeD\\chromedriver.exe");
		;
		driver = new ChromeDriver();
		//add the report logs
		test.log(LogStatus.INFO, "browser started...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "browser maximized");

	}

	@Test
	public void basicWeb() throws InterruptedException {
		driver.get(baseUrl);
		WebElement clickFlightstab = driver.findElement(By.id("tab-flight-tab-hp"));
		clickFlightstab.click();
		test.log(LogStatus.INFO, "Enter flights tab");
		
		WebElement FlyingFrom =driver.findElement(By.id("flight-origin-hp-flight"));
		FlyingFrom.sendKeys("New York");
		test.log(LogStatus.INFO, "Enter Destination flying from");
		
		WebElement FlyingTo = driver.findElement (By.id("flight-destination-hp-flight"));
		FlyingTo.sendKeys("Canada");
		test.log(LogStatus.INFO, "Enter Destination flying to");
		
		WebElement departing = driver.findElement(By.id("flight-departing-hp-flight"));
		departing.click();
		test.log(LogStatus.INFO, "Enter date departing date");
		
		WebElement datepickerdepart = driver.findElement
		(By.xpath("//div[@id='flight-departing-wrapper-hp-flight']/div[@class='datepicker-dropdown']/div/div[3]/table[@class='datepicker-cal-weeks']/tbody/tr[2]/td[2]/button[@type='button']"));
		datepickerdepart.click();
		
		WebElement ClearReturnBlock = driver.findElement(By.id("flight-returning-hp-flight"));
		ClearReturnBlock.clear();
		
		WebElement returning = driver.findElement(By.id("flight-returning-hp-flight"));
		returning.sendKeys("09/06/2018");
		test.log(LogStatus.INFO, "Enter date returning date");
		
		WebElement clickSubmit = driver.findElement(By.xpath("/html//form[@id='gcw-flights-form-hp-flight']//button[@type='submit']"));
		clickSubmit.click();
		test.log(LogStatus.INFO, "submit your search");
		test.log(LogStatus.PASS, "Verified basic browser test success");
	}

	@AfterClass
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		report.endTest(test);
		report.flush();

	}
}
