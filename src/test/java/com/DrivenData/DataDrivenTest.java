package com.DrivenData;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseClass.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pageObjectModel.FormPage;


public class DataDrivenTest extends Base {

	public static WebDriver driver;
	public FormPage lp;
//	public static ExtentTest test;
//	public static ExtentReports report;
	ExtentHtmlReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		htmlReport.config().setChartVisibleOnOpen(true);
		htmlReport.config().setDocumentTitle("Data Driven");
		htmlReport.config().setReportName("Report Data");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm:a '('zzz')'");
				driver = browserLaunch("chrome");
	}

	@Test(dataProvider = "AllDatagetter")
	public void LoginMethod(String userEmail, String username, String Fname, String lname, String userpass,
			String confirm) {
		lp = new FormPage(driver);
		geturl("https://demo.wpeverest.com/user-registration/column-2/");
		test = extent.createTest("User Email enter successfully");
		sendKeys(lp.getUseremail(), userEmail);
		test = extent.createTest("User Name enter successfully");
		sendKeys(lp.getUsername(), username);
		test = extent.createTest("User FirstName enter successfully");
		sendKeys(lp.getFirstname(), Fname);
		test = extent.createTest("User LastName enter successfully");
		sendKeys(lp.getLastname(), lname);
		test = extent.createTest("User Password enter successfully");
		sendKeys(lp.getUserpass(), userpass);
		test = extent.createTest("UserConfirm Password enter successfully");
		sendKeys(lp.getUserconfirmpassword(), confirm); 
		loggerInfo();
		
		
		
	}

	@AfterClass
	private void tearDown() {
		driver.close();
		extent.flush();
	}

}
