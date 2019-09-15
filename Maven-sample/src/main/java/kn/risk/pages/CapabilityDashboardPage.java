package kn.risk.pages;

import org.openqa.selenium.By;

import kn.risk.genericmethods.GenericMethods;

public class CapabilityDashboardPage extends GenericMethods {


	public boolean enterAudienceName(String audienceName){


		boolean isAudienceNameElementVisible=isDisplayed("xpath", "//label[text()='Audience Name:']/../div/div/div/input");
		if(isAudienceNameElementVisible){
			edit("xpath", "//label[text()='Audience Name:']/../div/div/div/input", audienceName);
			reportingFlag=true;
		}else{
			reportingFlag=false;
		}

		return reportingFlag;



	}

	public boolean selectAudienceType(String audienceType){
		boolean isAudienceTypeElement=isDisplayed("xpath", "//div[@class='GPMPRMOBD-']");
		if(isAudienceTypeElement){
			//KN Station
			click("xpath", "//div[@class='GPMPRMOBD-']");
			click("xpath", "//div[@class='GPMPRMOBMM']/div//div[text()='"+audienceType+"']");
			reportingFlag=true;		
		}else{
			reportingFlag=false;
		}


		return reportingFlag;




	}

	public boolean selectAudienceStatus(String audienceStatus){


		boolean isAudienceStatusVisible=isDisplayed("xpath", "//label[text()='Audience Status:']/../div/div/div/table/tbody/tr/td[2]/div");
		if(isAudienceStatusVisible){
			click("xpath", "//label[text()='Audience Status:']/../div/div/div/table/tbody/tr/td[2]/div");
			click("xpath", "//div[@class='GPMPRMOBMM']/div//div[text()='"+audienceStatus+"']");
			reportingFlag=true;
		}else{
			reportingFlag=false;
		}

		return reportingFlag;
	}


	public boolean checkquestionnaireStatus(String qnStatus){

		if(qnStatus.equals("In Progress")){
			qnStatus="PROG";
		}
		else if(qnStatus.equals("Not Started")){
			qnStatus="NOST";
		}
		else if(qnStatus.equals("Pending Clarification")){
			qnStatus="PECL";
		}
		else if(qnStatus.equals("Waiting for KN Review")){
			qnStatus="WFRV";
		}
		else if(qnStatus.equals("In Review")){
			qnStatus="INRV";
		}
		else if(qnStatus.equals("Approved")){
			qnStatus="APPR";
		}

		//uncheck other questionnaire Status except In Progress
		String qnStatuses="NOST,PECL,WFRV,INRV,APPR";
		uncheckQNStatus(qnStatuses);
		check("xpath","//div[@id='"+qnStatus+"']//input");



		return reportingFlag;
	}



	public void uncheckQNStatus(String qnStatuses){

		String [] statuses=qnStatuses.split(",");

		for(String status:statuses){

			unCheck("xpath","//div[@id='"+status+"']//input");

		}

	}

	public boolean verifyKNRiskCapabiltyDashboardRecords(String audienceType,String audienceStatus,String qnStatus){

		//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]
		int rowCount=driver.findElements(By.xpath("//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]/tr")).size();
		System.out.println(rowCount);


		for(int i=1;i<=rowCount;i++){

			String actualAudienceStatus=getText("xpath", "//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]/tr["+i+"]/td[2]//span");
			String actualAudienceType=getText("xpath", "//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]/tr["+i+"]/td[6]//span");
			String actualQnStatus=getText("xpath", "//span[text()='Audience Name']/../../../../../../../following-sibling::div/div/table/tbody[2]/tr["+i+"]/td[7]//span");

			if(actualAudienceStatus.equals(audienceStatus)&&actualAudienceType.equals(audienceType)&&actualQnStatus.equals(qnStatus)){
				reportingFlag=true;
				if(i==rowCount){
					break;
				}
			}
			else if(i>rowCount){
				break;
			}else{
				reportingFlag=false;
				break;
			}


		}


		return reportingFlag;

	}




	public boolean verifySendQuestionnaireElementsValues(String expectedAudienceName,String expectedAudienceType){


		
		driver.findElement(By.xpath("//span[text()='Send Questionnaire']")).click();
		String actualAudienceName=getValue("id", "supplierName-input");
		String actualAudienceType=getValue("xpath", "//*[@id='supplierName-input']/../../../../../following-sibling::td/div/div/div/div/input");


		if(expectedAudienceName.equals(actualAudienceName)&&expectedAudienceType.equals(actualAudienceType)){
			reportingFlag=true;
		}
		else{
			reportingFlag=false;
		}
		return reportingFlag;
	}


	public boolean verifySendQuestionnaireChildElements(){
		
		
		
		
		return reportingFlag;
	}
}
