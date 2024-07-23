package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;

public class LoginPage {

	private WebDriver driver;
	private ReusableFunctions reusablefunc;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		this.reusablefunc = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myaccount;
	
	@FindBy(xpath = "//li[@class='dropdown open']//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/login'][contains(text(),'Login')]")
	private WebElement login;
	
	@FindBy(id = "input-email")
	private WebElement email;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginbutton;
	
	
	public void clickOnMyAccount() {

		myaccount.click();
	}
	
	public void clickOnLogin() {
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(login).click().build().perform();
	}
	
	public void enterEmailAddress(String eml) {
		
		email.clear();
		email.sendKeys(eml);
	}

    public void enterPasswordField(String pwd) {
		
		password.clear();
		password.sendKeys(pwd);
	}

    public void clickOnLoginButton() {
		
    	loginbutton.click();
	}
}
