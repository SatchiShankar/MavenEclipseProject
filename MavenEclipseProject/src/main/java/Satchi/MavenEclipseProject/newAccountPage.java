package Satchi.MavenEclipseProject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class newAccountPage extends basePage{

	
	@FindBy(xpath="Add new account form")
	private  WebElement lblNewAccountHeader;
	
	@FindBy(xpath="//*[text()='New Account']")
	private  WebElement lblNewAccount;
	
	@FindBy(xpath="//*[@name='cusid']")
	private WebElement txtCustomerId;
	
	@FindBy(xpath="//*[@name='selaccount']")
	private WebElement listAccountType;
	
	@FindBy(xpath="//*[@name='inideposit']")
	private WebElement txtInitialDeposit;
	
	@FindBy(xpath="//*[@name='button2']")
	private WebElement btnSubmit;
	
	
	public newAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addAccount(Map<String, String> testData) {
		//WebDriverWait wait=new WebDriverWait((, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(lblNewAccount));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewAccount.click();
		
		if(lblNewAccountHeader.isDisplayed()) {
			txtCustomerId.sendKeys(testData.get("CustomerId"));
			Select s=new Select(listAccountType);
			s.selectByValue(testData.get("AccountType"));
			txtInitialDeposit.sendKeys(testData.get("InitialDeposit"));
			btnSubmit.click();
		}else
		{
			System.out.println("New Account Form is not Displayed");
		}
	}
	
}
