package kn.risk.tests.capabilitydashboard;


import java.io.File;
import java.io.IOException;

import kn.risk.genericmethods.GenericMethods;
import kn.risk.pages.CapabilityDashboardPage;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utility.ExcelUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class Filter1 extends GenericMethods  {

	@BeforeSuite
	public void beforeSuite(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/KNRiskAutomationReport.html", true);
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
		String audienceType="Airline";
		String audienceStatus="APPROVED";
		String questionnaireStatus="In Progress";
		//KN Station
		click("xpath", "//*[@id='manage-qualification-button']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div");
		logger.log(LogStatus.PASS, "User should click on Capability Dashboard","User is clicked on Capability Dashboard");
		CapabilityDashboardPage caps=new CapabilityDashboardPage();
		
		reportingFlag=	caps.selectAudienceType(audienceType);

		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be selected to "+ audienceType +" Audience Type ", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be selected to "+ audienceType +" Audience Type ", " User has selected Audience Type as "+ audienceType +"");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be selected to "+ audienceType +" Audience Type ", " User did not select Audience Type as "+ audienceType +"");

		}
		reportingFlag=caps.selectAudienceStatus(audienceStatus);


		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be selected to "+ audienceStatus +" Audience Status ", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be selected to "+ audienceStatus +" Audience Status ", " User has selected Audience Status as "+ audienceStatus +"");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be selected to "+ audienceStatus +" Audience Status ", " User did not select Audience Status as "+ audienceStatus +"");

		}
		reportingFlag=caps.checkquestionnaireStatus(questionnaireStatus);
		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be selected to "+ questionnaireStatus +" Questionnaire Status ", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be selected to "+ questionnaireStatus +" Questionnaire Status ", " User has selected Questionnaire Status as "+ questionnaireStatus +"");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be selected to "+ questionnaireStatus +" Questionnaire Status ", " User did not select Questionnaire Status as "+ questionnaireStatus +"");

		}

		click("xpath", "//div[text()='Filter']");

		logger.log(LogStatus.PASS, "User should be able to click on Filter button","User clicked on filter button");
		reportingFlag=caps.verifyKNRiskCapabiltyDashboardRecords(audienceType,audienceStatus,questionnaireStatus);

		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be able to verify Audience Type as "+audienceType+", Audience Status as "+audienceStatus+" and Questionnaire Status as "+ questionnaireStatus +" in table records ", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be able to verify Audience Type as "+audienceType+" ,Audience Status as "+audienceStatus+" and Questionnaire Status as "+ questionnaireStatus +" in table records", "Audience Type as "+audienceType+" ,Audience Status as "+audienceStatus+" and Questionnaire Status as "+ questionnaireStatus +" in table records are visible");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be able to verify Audience Type as "+audienceType+" ,Audience Status as "+audienceStatus+" and Questionnaire Status as "+ questionnaireStatus +" in table records ", "Audience Type as "+audienceType+" ,Audience Status as "+audienceStatus+" and Questionnaire Status as "+ questionnaireStatus +" in table records are not visible");

		}
	}

	@Test
	public void test3(){
		logger=extent.startTest("Verify Capability Dashboard Send Questionnaire fields");
		CapabilityDashboardPage caps=new CapabilityDashboardPage();

		String audienceName="South African Airways";
		String audienceType="Airline";

		reportingFlag=caps.enterAudienceName("South African Airways");
		click("xpath", "//div[text()='Filter']");

		logger.log(LogStatus.PASS, "User should be able to click on Filter button","User clicked on filter button");
		click("xpath", "//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]/tr/td[10]/div/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/img");
		logger.log(LogStatus.PASS, "User should be able to click on Send Questionnaire Action button","User clicked on Send Questionnaire Action button");
		click("xapth", "//span[text()='Send Questionnaire']");
		logger.log(LogStatus.PASS, "User should be able to click on Send Questionnaire button","User clicked on Send Questionnaire button");
		reportingFlag=caps.verifySendQuestionnaireElementsValues("South African Airways","Airline");
		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be able to verify Audience Type as "+audienceType+" and Audience Name as "+ audienceName +" in Send Questionnaire Page", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be able to verify Audience Type as "+audienceType+" and Audience Name as "+ audienceName +" in Send Questionnaire Page", "Audience Name as "+audienceName+" and Audience Type as "+audienceType+" are as same as expected and actuals in Send Questionnaire page");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be able to verify Audience Type as "+audienceType+" and Audience Name as "+ audienceName +" in Send Questionnaire Page", "Audience Name as "+audienceName+" and Audience Type as "+audienceType+" are not as same as expected and actuals in Send Questionnaire page");

		}
	}

	@Test
	public void test4() throws Exception{
		
		
		logger=extent.startTest("Verify Capability Dashboard Send Questionnaire's Email Preview Page");

		ExcelUtils util=new ExcelUtils();
		click(util.getIdentifyBy("SEND_QUESTIONNAIRE", "EmailReview"), util.getPageProperty("SEND_QUESTIONNAIRE", "EmailReview"));
		logger.log(LogStatus.PASS, "User should be clicked on  Email Preview Button", "User clicked on  Email Preview");

		reportingFlag=verifyElements("SEND_QUESTIONNAIRE_CHILD","TO,CC,BCC,replyTo,emailSubject,sendEmail");
		if(reportingFlag==null){

			logger.log(LogStatus.UNKNOWN, "User should be able to verify all the elements in the Send Questionnaire Email Preview page", "Unknown error, Please check in the code!");

		}
		else if(reportingFlag.equals(Boolean.TRUE)){

			logger.log(LogStatus.PASS, "User should be able to verify all the elements in the Send Questionnaire Email Preview page", "User successfully verified all the elements in the Send Questionnaire Email Preview page");

		}
		else if(reportingFlag.equals(Boolean.FALSE)){

			logger.log(LogStatus.FAIL, "User should be able to verify all the elements in the Send Questionnaire Email Preview page", "User successfully could not verified all the elements in the Send Questionnaire Email Preview page");

		}


		click(util.getIdentifyBy("SEND_QUESTIONNAIRE_CHILD", "cancel"), util.getPageProperty("SEND_QUESTIONNAIRE_CHILD", "cancel"));
		logger.log(LogStatus.PASS, "User should be clicked on  Cancel button on Send Questionnaire Email Preview page", "User clicked on Cancel button on Send Questionnaire Email Preview page");
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
