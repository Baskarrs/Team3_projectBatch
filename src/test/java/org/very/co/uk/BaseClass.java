package org.very.co.uk;


import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String bname) {
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;

	}

	public static void browserLaunch2(String bname) {
		switch (bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

	}

	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicityWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void quit() {
		driver.quit();
	}

	public static void sendKeys(WebElement a, String value) {
		a.sendKeys(value);
	}

	public static void click(WebElement a) {
		a.click();
	}

	public static String getText(WebElement a) {
		String text = a.getText();
		return text;
	}

	public static String getAttribute(WebElement a) {
		String attribute = a.getAttribute("value");
		return attribute;
	}

	public static String getAttributeInnerText(WebElement a) {
		String attribute = a.getAttribute("innerText");
		return attribute;
	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
		;
	}

	public static void dragAndDrop(WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
		;
	}

	public static void contextClick(WebElement c) {
		Actions a = new Actions(driver);
		a.contextClick(c).perform();
		;
	}

	public static void doubleClick(WebElement d) {
		Actions a = new Actions(driver);
		a.doubleClick(d).perform();
		;
	}

	public static void clickAction(WebElement b) {
		Actions a = new Actions(driver);
		a.click(b).perform();
	}

	public static void keyPress(int a) throws AWTException {
		Robot r = new Robot();
		r.keyPress(a);
	}

	public static void keyRelease(int a) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(a);
	}

	public static Alert alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
		return a;
	}

	public static Alert alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		return a;
	}

	public static void sendkeysAlert(WebElement a, String value) {
		Alert pa = driver.switchTo().alert();
		pa.sendKeys(value);
	}

	public static String getTextAlert() {
		Alert pa = driver.switchTo().alert();
		String text = pa.getText();
		return text;
	}

	public static void selectByValue(WebElement a, String value) {
		Select s = new Select(a);
		s.selectByValue(value);
	}

	public static void selectByIndex(WebElement a, int b) {
		Select s = new Select(a);
		s.selectByIndex(b);
	}

	public static void selectByVisibleText(WebElement a, String b) {
		Select s = new Select(a);
		s.selectByVisibleText(b);
	}

	public static void deselectByValue(WebElement a, String b) {
		Select s = new Select(a);
		s.deselectByValue(b);
	}

	public static void deselectByIndex(WebElement a, int b) {
		Select s = new Select(a);
		s.deselectByIndex(b);
	}

	public static void deselectByVisibleText(WebElement a, String b) {
		Select s = new Select(a);
		s.deselectByVisibleText(b);
	}

	public static void deselectAll(WebElement a) {
		Select s = new Select(a);
		s.deselectAll();
	}

	public static boolean isMultiple(WebElement a) {
		Select s = new Select(a);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public static List<org.openqa.selenium.WebElement> getOptions(WebElement a) {
		Select s = new Select(a);
		List<org.openqa.selenium.WebElement> options = s.getOptions();
		return options;
	}

	public static org.openqa.selenium.WebElement getFirstSelectedOption(WebElement a) {
		Select s = new Select(a);
		org.openqa.selenium.WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public static List<org.openqa.selenium.WebElement> getAllSelectedOption(WebElement a) {
		Select s = new Select(a);
		List<org.openqa.selenium.WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public static File getScreenShotAs() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public static File getScreenShotAsWeb(WebElement a) {
		File screenshotAs = a.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	public static Object executeScript(String a, WebElement b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript(a, b);
		return executeScript;
	}

	public static String getWindowHandle(String a) {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public static void windowHandles(Integer a) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li = new LinkedList<>();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(a));

	}

	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static String readExcel(String filename,String sheet,int row,int cel) throws IOException {
		File f = new File("C:\\Users\\rbask\\eclipse-workspace\\Maven_Test\\src\\main\\resources\\Excel\\"+filename+".xlsx");
		FileInputStream is = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(is);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		org.apache.poi.ss.usermodel.Cell cell = r.getCell(cel);
		int type = cell.getCellType();
		String value=null;
		if(type == 1) {
			value = cell.getStringCellValue();
		}
		else
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
			     value = sf.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num = (long)numericCellValue ;
				value = String.valueOf(num);
			}
		return value;
	}


}

