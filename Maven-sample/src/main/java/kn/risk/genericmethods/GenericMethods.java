package kn.risk.genericmethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExcelUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class GenericMethods {

	public static WebDriver driver;
	private static WebElement element = null;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Boolean reportingFlag; 


	public static void browserLaunch(String env){
		System.setProperty("webdriver.ie.driver", "C:\\Software\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		if(env.equalsIgnoreCase("Test")){
			driver.get("http://www.google.com");
		}
		else if(env.equalsIgnoreCase("Dev")){
			driver.get("http://lxvenazbn300s.us.int.kn:8080/knriskapp/#Login");
		}
	}
	
	public static void firefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver","C:\\Software\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("http://www.google.com");
	
	}
	public static void click(String locator, String prop){
		WebDriverWait wait=new WebDriverWait(driver, 60);


		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			element.click();
		}

	}



	public void unCheck (String locator, String prop){
		
		WebDriverWait wait=new WebDriverWait(driver, 60);

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(prop))));
		}

		if(element.isSelected()){
			element.click();;
		}

	}
	
	public static void check(String locator,String prop){
		WebDriverWait wait=new WebDriverWait(driver, 60);


		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(prop))));
		}

		if(!element.isSelected()){
			element.click();;
		}
	}
	public static void edit(String locator,String prop,String value){

		WebDriverWait wait=new WebDriverWait(driver, 60);

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){


			element.click();
			element.clear();
			//element.sendKeys(new String(value));
			//String text = "My super long text string to be typed into textarea element";
			//WebElement element = driver.findElement(By.tagName("textarea"));
			//JavascriptExecutor js=JavascriptExecutor();

			((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1];", element,
					value);


		}
	}

	public static void selectByText(String locator,String prop,String text){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Select select;

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			select=new Select(element);
			select.selectByVisibleText(text);
		}

	}

	public static void selectByValue(String locator,String prop,String value){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Select select;

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			select=new Select(element);
			select.selectByValue(value);
		}

	}
	public static void selectByIndex(String locator,String prop,int index){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		Select select;

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			select=new Select(element);
			select.selectByIndex(index);
		}

	}

	public static String getText(String locator, String prop){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		String text = null;
		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			text=element.getText();
		}
		return text;

	}

	public static String getValue(String locator, String prop){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		String value = null;
		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			value=element.getAttribute("Value");
		}
		return value;

	}

	public static Boolean isDisplayed(String locator,String prop){

		WebDriverWait wait=new WebDriverWait(driver, 60);
		boolean status=false;

		if(locator.equalsIgnoreCase("ID")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(prop))));
		}
		else if(locator.equalsIgnoreCase("XPATH")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(prop))));
		}
		else if(locator.equalsIgnoreCase("LinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(prop))));
		}
		else if(locator.equalsIgnoreCase("PartialLinkText")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(prop))));

		}
		else if(locator.equalsIgnoreCase("name")){
			element=(WebElement) wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(prop))));
		}

		if(element.isDisplayed()){
			status=true;
		}else{
			status=true;
		}

		return status;

	}


	public static void loginToKNRisk(){
		boolean status=isDisplayed("xpath", "//div[text()='Home']");
		if(status){
			logger.log(LogStatus.PASS, "KN Risk page should be launched", "KN Risk  page is launched");
		}else{
			logger.log(LogStatus.FAIL, "KN Risk page should be launched","KN Risk home page did not launched");
		}

		//click("xpath", "//div[text()='Login']");

		edit("id", "username-input", "External.bheerappa.kalasad@usa.win.int.kn");
		edit("id", "password-input", "Abcd1234");

		click("xpath", "//*[@id='login-button']/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div");



		boolean isLogoutElment=isDisplayed("xpath", "//div[text()='Logout']");

		if(isLogoutElment){
			logger.log(LogStatus.PASS,"User should be able to login to the KN Risk", "Login successfull");
		}else{
			logger.log(LogStatus.FAIL, "User should be able to login to the KN Risk","Login is not succssfull");
		}
	}


	public static String capture(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);        

		return dest;
	}
	
	public static void verifyElementsText(String elements){
		
		String [] elementss=elements.split(",");
		
		
		for(String element:elementss){
			
			
			
		}
	}
	public static Boolean verifyElements(String pageid,String elements) throws Exception{

		ExcelUtils util=new ExcelUtils();
		String [] elementss=elements.split(",");

		for(String element:elementss){

			boolean isElementVisible=isDisplayed(util.getIdentifyBy(pageid, element), util.getPageProperty(pageid, element));

			if(isElementVisible){
				reportingFlag=true;
			}
			else{
				reportingFlag=false;
				break;
			}
			
		}

		return reportingFlag;
		
	}



	public void extentReport(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		extent
		.addSystemInfo("Host Name", "KN Risk")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Bheer K");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

}

