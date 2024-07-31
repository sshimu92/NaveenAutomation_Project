package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;

public class RegistrationPage {

	private WebDriver driver;
	private ReusableFunctions reusablefunctions;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		this.reusablefunctions = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myaccount;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement register;

	@FindBy(id = "input-firstname")
	private WebElement firstname;

	@FindBy(id = "input-lastname")
	private WebElement lastname;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement cpassword;

	@FindBy(xpath = "//input[@name=\"newsletter\"][@value=\"0\"]")
	private WebElement newsletter;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	
	public void clickMyAccount() {

		Actions ac = new Actions(driver);
		ac.moveToElement(myaccount).click().build().perform();
//		myaccount.click();

	}

	public void clickRegister() {

		Actions ac = new Actions(driver);
		ac.moveToElement(register).click().build().perform();
	}

	public void enterFirstName(String fname) {

		firstname.sendKeys(fname);
	}

	public void enterLastName(String lname) {

		lastname.sendKeys(lname);
	}

	public void enterEmail(String eml) {

		email.sendKeys(eml);
	}

	public void enterTelephone(String tphone) {

		telephone.sendKeys(tphone);
	}

	public void enterPassword(String pwd) {

		password.sendKeys(pwd);
	}

	public void enterConfirmPassword(String Cpwd) {

		cpassword.sendKeys(Cpwd);
		
	}

	public void selectNewsletterOption() {
		
		newsletter.click();
	}

	public void clickCondtionCheckbx() {
		
		checkbox.click();
	}

	public void clickSubmit() {
		
		submit.click();
	}
}
