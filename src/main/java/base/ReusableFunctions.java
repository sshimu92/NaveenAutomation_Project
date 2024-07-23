package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {

	private static WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = LogManager.getLogger(ReusableFunctions.class);
	
	public ReusableFunctions(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public static WebDriver invokeBrowser() {
		
		return driver = DriverSetup.getDriver();
		
	}

	public void openWebsite(String url) {
		
		driver.get(url);
		
	}

	public void setText(WebElement ele, String txt) {
		
		ele.clear();
		ele.click();
		ele.sendKeys(txt);
	}

	public void waitForElementToBeVisible(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectDropDown(WebElement ele, String text) {
		
		waitForElementToBeVisible(ele);
		Select sc = new Select(ele);
		sc.selectByVisibleText(text);
		
	}

	public String getText(WebElement ele) {
		
		waitForElementToBeVisible(ele);
		return ele.getText();
	}

	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(20);
		driver.quit();
	}

	public void takeScreenShots(String filePath) {
		
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		
		try {
		
			FileUtils.copyFile(src, new File("./ScreenShot/"+filePath+".png"));
		
		}catch(IOException e) {
			
			logger.info(e.getMessage());
		}
		
	}
}
