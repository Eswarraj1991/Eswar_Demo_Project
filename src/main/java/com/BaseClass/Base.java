package com.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}

	public static void geturl(String text) {
		driver.get(text);
	}

	public static void implicitlyWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// input feeding methods
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	@DataProvider(name = "AllDatagetter")
	public Object[][] AllDatagetter() throws IOException {

		File f = new File("C:\\Users\\ABINANDH\\Desktop\\DataFile.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheet = wb.getSheetAt(0);

		int Rowcount = sheet.getLastRowNum();

		System.out.println("Row Count :" + Rowcount);

		Object[][] data = new Object[Rowcount][6];

		for (int i = 1; i <= Rowcount; i++) {

			Row row = sheet.getRow(i);
			Cell userEmail = row.getCell(0);
			Cell username = row.getCell(1);
			Cell Fname = row.getCell(2);
			Cell lname = row.getCell(3);
			Cell userpass = row.getCell(4);
			Cell confirm = row.getCell(5);

			data[i - 1][0] = userEmail.getStringCellValue();
			data[i - 1][1] = username.getStringCellValue();
			data[i - 1][2] = Fname.getStringCellValue();
			data[i - 1][3] = lname.getStringCellValue();
			data[i - 1][4] = userpass.getStringCellValue();
			data[i - 1][5] = confirm.getStringCellValue();

		}

		wb.close();
		fis.close();

		return data;

	}

	public static void loggerInfo() {
		Logger logging = Logger.getLogger(Base.class.getName());
		logging.setLevel(Level.INFO);
		logging.info("Code Run: Successfully");
	}

}
