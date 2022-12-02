package org.very.co.uk;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceVeryCoUk extends BaseClass {
	
	static WebDriver driver ;
	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	private void beforeMethod() {
		Date d = new Date();
		System.out.println("start time..." + d);

	}

	@AfterMethod
	private void afterMethod() {
		Date d = new Date();
		System.out.println("start time..." + d);
	}

}
