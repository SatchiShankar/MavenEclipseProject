package Satchi.MavenEclipseProject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends basePage{

//WebDriver driver;

@FindBy(xpath="//a[text()='New Customer']")
private WebElement lblNewCustomer;

@FindBy(xpath="//*[text()='Add New Customer']")
private WebElement lblAddNewCustomer;

@FindBy(xpath="//input[@name='name']")
private WebElement txtCustName;

@FindBy(xpath="//input[1][@name='rad1']")
private WebElement radMale;

@FindBy(xpath="//input[2][@name='rad1']")
private WebElement radFemale;

@FindBy(xpath="//input[@id='dob']")
private WebElement txtdob;

@FindBy(name="addr")
private WebElement txtAddress;

@FindBy(name="city")
private WebElement txtCity;

@FindBy(name="state")
private WebElement txtState;

@FindBy(name="pinno")
private WebElement txtPincode;

@FindBy(name="telephoneno")
private WebElement txtPhone;

@FindBy(name="emailid")
private WebElement txtEmail;

@FindBy(xpath="//*[@value='Submit']")
private WebElement btnSubmit;

	

	public NewCustomerPage(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
}



	public void addNewCustomer(Map<String, String> testData) {
		lblNewCustomer.click();
		
		if(lblAddNewCustomer.isDisplayed()) {
			reportLog("PASS", "Home Page is Displayed "+testData.get("name"));
			txtCustName.sendKeys(testData.get("name"));
			
			if(testData.get("gender").equalsIgnoreCase("Male")) 
				radMale.click();
			else if(testData.get("gender").equalsIgnoreCase("Female")) {
				radFemale.click();
			}
			
			txtdob.sendKeys(testData.get("dob"));
			txtAddress.sendKeys(testData.get("address"));
			txtCity.sendKeys(testData.get("city"));
			txtState.sendKeys(testData.get("state"));
			txtPincode.sendKeys(testData.get("pin"));
			txtPhone.sendKeys(testData.get("phone"));
			txtEmail.sendKeys(testData.get("email"));
			btnSubmit.click();
		}
		else 
		{
			reportLog("fail", "Add new Customer link is not displayed");
		}
		
	}

}
