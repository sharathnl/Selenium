package kn.risk.tests.capabilitydashboard;

import java.io.File;
import java.io.IOException;

import kn.risk.genericmethods.GenericMethods;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class CapabilityFilter extends GenericMethods {

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

		browserLaunch("Test");
		click("xpath", "//div[text()='Login']");
	}

	@Test
	public void test1(){
		logger=extent.startTest("Check Login Functionality");

		loginToKNRisk();

	}
	@Test
	public void test2(){
		logger=extent.startTest("Verify Capability Dashboard filers");


		try {
			click("xpath", "//*[@id='manage-qualification-button']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div");
			logger.log(LogStatus.PASS, "User should click on Capability Dashboard","User is clicked on Capability Dashboard");
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "User should click on Capability Dashboard","User did not click on Capability Dashboard");
		}
		//verify capability dashboard filters Audience Type,Audience Status,Audience Name,Expiring between.

		try {


			edit("xpath", "//div[@class='GPMPRMOBHY']/input","British Airways");
			logger.log(LogStatus.PASS, "User should be able to enter Audience Name into the Audience Name field","User entered audience name successfully");

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "User should be able to enter Audience Name into the Audience Name field" ,"User did not enter audience name");
		}

		try {

			click("xpath", "//div[text()='Filter']");

			logger.log(LogStatus.PASS, "User should be able to click on Filter button","User clicked on filter button");

		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "User should be able to click on Filter button","User did not click on filter button ");
		}

		try {
			String expectedAudienceName="British Airways";
			String actualAudienceName=getText("xpath", "//*[@id='Framed Panel']/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/table/tbody[2]/tr/td[1]/div/span/u");

			System.out.println("Actual adience name is: " +actualAudienceName);
			Assert.assertEquals(expectedAudienceName, actualAudienceName);
			if((expectedAudienceName.equalsIgnoreCase(actualAudienceName))==Boolean.TRUE){
				logger.log(LogStatus.PASS,"Filtered Audience should be match with Expected Audience ", "Filtered Audience name matches successfully");

			}else{
				logger.log(LogStatus.FAIL, "Filtered Audience should be match with Expected Audience","Filtered audience did not match successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){


			/*logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());*/

			String screenShotPath = capture("screenShotName");
			logger.log(LogStatus.FAIL, "abc",result.getThrowable());
			logger.log(LogStatus.FAIL, "abc","Snapshot below: " + logger.addScreenCapture(screenShotPath));
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
