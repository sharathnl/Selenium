package kn.risk.tests.capabilitydashboard;

import java.io.File;

import kn.risk.genericmethods.GenericMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends GenericMethods {
	
	@BeforeSuite
	public void beforeSuite(){

		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		extent
		.addSystemInfo("Host Name", "KN Risk")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Bheer K");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@BeforeClass
	public void beforeClass() {
		
		firefoxBrowser();
		//browserLaunch("Test");
		//click("xpath", "//div[text()='Login']");
	}

	/*@Test
	public void test1(){
		
		logger=extent.startTest("passTest1");
		boolean status=isDisplayed("xpath", "//div[text()='Home']");
		if(status){
			logger.log(LogStatus.PASS,"abc" ,"KN Risk home page is launched");
		}else{
			logger.log(LogStatus.FAIL,"abc" ,"KN Risk home page did not launched");
		}

	}
	
	@Test
	public void test2() throws InterruptedException{
		
		logger=extent.startTest("passTest2");
		
		edit("id", "username-input", "abc");
		edit("id", "password-input", "abc");

		click("xpath", "//*[@id='login-button']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div");

		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);	
		Thread.sleep(5000);
		
		alert.accept();
		logger.log(LogStatus.PASS,"dfsfs", "Test Case (passTest1) Status is passed");
	}*/
	
	
	@Test
	public void test7()  throws InterruptedException{
		
		logger=extent.startTest("passTest3");
		
		edit("name", "q", "toolsqa");
		
//boolean isLogoutElment=isDisplayed("xpath", "//div[text()='Logout']");
		
		//if(isLogoutElment){
			logger.log(LogStatus.PASS, "abc","Test Case (passTest1) Status is passed");
		/*
		 * }else{ logger.log(LogStatus.FAIL,"abc",
		 * "Test Case (passTest1) Status is failed"); }
		 */
		
	}

	/*
	 * @Test public void test3(String gUsername ,String gPassword) throws
	 * InterruptedException{
	 * 
	 * logger=extent.startTest("passTest3");
	 * 
	 * //click("xpath", "//div[text()='Login']"); edit("id", "username-input",
	 * "External.bheerappa.kalasad@usa.win.int.kn"); edit("id", "username-input",
	 * gUsername); edit("id", "password-input", "Abcd1234");
	 * 
	 * edit("id", "password-input", gPassword);
	 * 
	 * click("xpath",
	 * "//*[@id='login-button']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div"
	 * );
	 * 
	 * 
	 * 
	 * boolean isLogoutElment=isDisplayed("xpath", "//div[text()='Logout']");
	 * 
	 * if(isLogoutElment){ logger.log(LogStatus.PASS,
	 * "abc","Test Case (passTest1) Status is passed"); }else{
	 * logger.log(LogStatus.FAIL,"abc", "Test Case (passTest1) Status is failed"); }
	 * 
	 * 
	 * }
	 */	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL,"abc", "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "abc","Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "abc","Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
	
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
                extent.flush();
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                extent.close();
                
    }
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
