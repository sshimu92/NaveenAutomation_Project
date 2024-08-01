package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ReusableFunctions;
import pageObjectModel.LoginPage;
import pageObjectModel.Shopping_cart;

public class ShoppingCart_Test {

	private WebDriver driver;
	private Shopping_cart sc;
	private ReusableFunctions rc;
	private LoginPage lp;
	
	@BeforeTest
	public void setup() {
		
		driver = ReusableFunctions.invokeBrowser();
		rc = new ReusableFunctions(driver);
		rc.openWebsite("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		lp = new LoginPage(driver);
		sc = new Shopping_cart(driver);
	}
	
	@Test
	public void addItemsOnShoppingCart() {
		
		sc.loginPage();
		sc.clickOnDesktop();
		sc.selectMac();
		sc.addToCartItem1();
		sc.clickOnCameras();
		sc.addToCartItem2();
	}
	
	@Test
	public void verifyItemsOnCart() {
		
		int TotalItems = sc.verifytotalNumberOfItemsOnCart();
		System.out.println("Total items on cart: "+ TotalItems);
		sc.clickViewCart();
	
	}
	
	@Test(priority= 4)
	public void completeCheckout() {
		
		sc.clickViewCart();
		sc.clickOnCheckout();
		
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		
		rc.closeBrowser();
	}
}
