package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;

public class Shopping_cart {

	private WebDriver driver;
	private ReusableFunctions rc;
	private LoginPage lp;
	
	public Shopping_cart(WebDriver driver) {
		
		this.driver = driver;
		this.rc = new ReusableFunctions(driver);
		this.lp = new LoginPage(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div.container:nth-child(3) nav.navbar div.collapse.navbar-collapse.navbar-ex1-collapse ul.nav.navbar-nav li.dropdown:nth-child(1) > a.dropdown-toggle")
	private WebElement desktops;
	
	@FindBy(xpath = "//li//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20_27'][contains(text(),'Mac (1)')]")
	private WebElement mac;
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	private WebElement item1;
	
	@FindBy(xpath = "//li//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=33']")
	private WebElement cameras;
	
	@FindBy(css = "div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(3) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(2) div.product-thumb div:nth-child(2) div.button-group button:nth-child(1) > span.hidden-xs.hidden-sm.hidden-md")
	private WebElement item2;
	
	@FindBy(id = "cart-total")
	private WebElement clickcart;
	
	@FindBy(css = "td.text-left")
	private List<WebElement> items;
	
	@FindBy(xpath = "//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart']")
	private WebElement viewcart;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkout;
	
	public void loginPage() {
		
		lp.clickOnMyAccount();
		lp.clickOnLogin();
		lp.enterEmailAddress("shawon.shimu@yahoo.com");
		lp.enterPasswordField("j25@mNMA2WWFeeU");
		lp.clickOnLoginButton();
		
	}
	
	public void clickOnDesktop() {
		
		desktops.click();
	}

	public void selectMac() {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(mac).click().build().perform();
		
	}

	public String addToCartItem1() {
		
	    item1.click();
	    return item1.getText();
		
	}

	public void clickOnCameras() {
		
		cameras.click();
	}

	public String addToCartItem2() {
		
		item2.click();
		return item2.getText();
	}

	public void clickOnShoppingCart() {
		
		clickcart.click();
	}

	public int verifytotalNumberOfItemsOnCart() {
		
		return items.size();	
		
	}
	
	public void clickViewCart() {
		
		viewcart.click();
	}

	public void clickOnCheckout() {
		
		checkout.click();
	}
}
