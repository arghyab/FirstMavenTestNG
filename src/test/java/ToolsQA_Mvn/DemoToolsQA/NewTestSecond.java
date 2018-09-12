package ToolsQA_Mvn.DemoToolsQA;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.sun.corba.se.impl.util.Utility;
import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class NewTestSecond {
	
	private static final TakesScreenshot webdriver = null;
	//Create global variable which will be used in all method
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {	   		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);  
	  }
	
	  @AfterClass
	  public void afterClass() {
		  extent.flush();
		  driver.quit();
	  }
	  
	  @BeforeMethod
		public void setup()
		{
		    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation2.html");
		    extent = new ExtentReports();		    
		    extent.attachReporter(reporter);		    
		    logger=extent.createTest("Start Test");
		}
	
	
	@Test(priority = 0)
	public void launchURL() {
		String appUrl = "http://demo.guru99.com/test/newtours/";
		driver.get(appUrl);
		System.out.println("End Test 1");
		logger.log(Status.INFO, "Launched Mercury Website");
	}
	  

	  @Test(priority = 1)
	  public void continueTest() throws IOException {
		System.out.println("Start 2nd Test");
		String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        // get the actual value of the title
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
        	logger.log(Status.PASS, "Page Title verified");
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
            logger.log(Status.FAIL, "Page Title verification is failed");
            logger.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
            
        }
 
	}
}
