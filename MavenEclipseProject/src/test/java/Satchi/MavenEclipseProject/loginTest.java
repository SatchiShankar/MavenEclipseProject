package Satchi.MavenEclipseProject;

import java.util.Date;
import java.util.Map;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class loginTest extends baseTest {
	Date dateobj = new Date();
	
	@Test (dataProvider = "testData")
	private void addNewCustomer(Map<String, String> testData) throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		loginPage lp=new loginPage(getDriver());
		NewCustomerPage hp=new NewCustomerPage(getDriver());
		System.out.println(testData.get("Userid")+"   "+testData.get("Password"));
		lp.login(testData);
		hp.addNewCustomer(testData);
		
	}
	
	@Test (dataProvider = "testData")
	private void addNewAccount(Map<String, String> testData) throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		loginPage lp=new loginPage(getDriver());
		newAccountPage ap=new newAccountPage(getDriver());
		System.out.println(testData.get("Userid")+"   "+testData.get("Password"));
		lp.login(testData);
		ap.addAccount(testData); 
		Selenium.test.get().log(Status.PASS, "Navigated");

	}	
	
	/*
	 * //@Test private void launchurl1() { driver.get("https://www.google.com");
	 * TakesScreenshot scrShot =((TakesScreenshot)driver); File
	 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new
	 * File("C:\\Users\\saran\\eclipse-workspace\\Sample\\test-output\\Screenshots\\"+new Exception().getStackTrace()[0].getMethodName()+"
	 * _"+dateobj.toString().replace(" ", "").replace(":","")+".jpg"); try {
	 * Files.copy(SrcFile, DestFile); } catch (IOException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } try { Thread.sleep(5000);
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * //@Test private void launchurl2() throws NoSuchMethodException,
	 * SecurityException { driver.get("https://www.amazon.com"); TakesScreenshot
	 * scrShot =((TakesScreenshot)driver); File
	 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new
	 * File("C:\\Users\\saran\\eclipse-workspace\\Sample\\test-output\\Screenshots\\"+new Exception().getStackTrace()[0].getMethodName()+"
	 * _"+dateobj.toString().replace(" ", "").replace(":","")+".jpg"); try {
	 * Files.copy(SrcFile, DestFile); } catch (IOException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } }
	 */
	
	
	
}
