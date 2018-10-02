package ToolsQA_Mvn.DemoToolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTestSecond {
	
	WebDriver driver;
	
	@Test(priority = 0)
	public void launchURL() {
		String appUrl = "http://demo.guru99.com/test/newtours/";
		driver.get(appUrl);
		System.out.println("End Test 1");
		  }
	
	@BeforeClass
	  public void beforeClass() {	   		
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);  
	  }
	
	  @AfterClass
	  public void afterClass() {
	   driver.quit();
	  }
	
	  @Test(priority = 1)
	  public void continueTest() {
		System.out.println("Start 2nd Test");
		String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        // get the actual value of the title
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
 
	}
}
