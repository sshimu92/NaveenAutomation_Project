package reportSample;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenersSample implements ITestListener {

	
    public WebDriver driver;

	public void onStart(ITestResult result) {

		System.out.println("Test Started(Start of Execution)->" + result.getName());
	}

	public void onTestStart(ITestResult result) {

		System.out.println("Test Started->" + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Passed->" + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failed->" + result.getMethod().getMethodName());
		
		Object testclass=result.getInstance();
        
		WebDriver driver=((SampleTest) testclass).getDriver();
        
        if(driver!=null) {
           
        	String fileName=captureScreen(driver, result.getMethod().getMethodName());
            System.out.println(fileName);
        }

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Skipped->" + result.getMethod().getMethodName());
	}

	public void onFinish(ITestResult result) {

		System.out.println("Test Finished->" + result.getName());
	}

	private String captureScreen(WebDriver driver, String methodName) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
		String fileName = methodName + "_" + timeStamp + ".png";
        
		try {
           
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            String destination = System.getProperty("user.dir") + "/screenshots/" + fileName;
            
            Files.copy(screenshot.toPath(), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            
            return fileName;
       
        }catch(Exception e) {
           
        	e.printStackTrace();
        }
        
		return null;
		
		
	}
}
