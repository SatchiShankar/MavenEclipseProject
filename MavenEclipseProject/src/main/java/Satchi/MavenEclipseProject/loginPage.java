package Satchi.MavenEclipseProject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage{
	
	//WebDriver driver;

	@FindBy(name="uid")
	private WebElement txtUserId;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	private WebElement btnLogin;
	
	


	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}




	public void login(Map<String, String> testData) throws InterruptedException {
		txtUserId.sendKeys(testData.get("Userid"));
		reportLog("info","User ID entered");
		txtPassword.sendKeys(testData.get("Password"));
		reportLog("info","Password is entered");

		btnLogin.click();
		//Selenium.test.get().log(Status.PASS, "Test");
		reportLog("pass", "Login is success");
	}

}
