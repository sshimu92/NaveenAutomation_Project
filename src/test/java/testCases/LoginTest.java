package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ReusableFunctions;
import junit.framework.Assert;
import pageObjectModel.LoginPage;


public class LoginTest {

	private WebDriver driver;
	private LoginPage lp;
	private ReusableFunctions rc;
	
	@BeforeTest
	public void setup() {
		
		driver = ReusableFunctions.invokeBrowser();
		rc = new ReusableFunctions(driver);
		lp = new LoginPage(driver);
		rc.openWebsite("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}
	
	@Test
	public void loginTest() {
		
		lp.clickOnMyAccount();
		lp.clickOnLogin();
		lp.enterEmailAddress("shawon.shimu@yahoo.com");
		lp.enterPasswordField("j25@mNMA2WWFeeU");
		lp.clickOnLoginButton();
	}
	
	@Test
	public void verifyHomePage() {
		
		 Assert.assertEquals(driver.getCurrentUrl(), "https://naveenautomationlabs.com/opencart/index.php?route=account/account");
	     
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		
			rc.closeBrowser();
	}
}
