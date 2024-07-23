package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ReusableFunctions;
import junit.framework.Assert;
import pageObjectModel.RegistrationPage;

public class RegistrationTest {

	private WebDriver driver;
	private ReusableFunctions rc;
	private RegistrationPage register;
	
	@BeforeTest
	public void setup() {
		
		driver = ReusableFunctions.invokeBrowser();
		rc = new ReusableFunctions(driver);
		register = new RegistrationPage(driver);
		rc.openWebsite("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}

	@Test
	public void completeRegistration() {
		
		register.clickMyAccount();
		register.clickRegister();
		register.enterFirstName("Shawon");
		register.enterLastName("Shimu");
		register.enterEmail("shawon.shimu@yahoo.com");
		register.enterTelephone("3212158020");
		register.enterPassword("j25@mNMA2WWFeeU");
		register.enterConfirmPassword("j25@mNMA2WWFeeU");
		register.selectNewsletterOption();
		register.clickCondtionCheckbx();
		register.clickSubmit();
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		
		rc.closeBrowser();
	}
}
