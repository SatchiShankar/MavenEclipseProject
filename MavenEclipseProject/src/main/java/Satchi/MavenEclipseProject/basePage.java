package Satchi.MavenEclipseProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class basePage {

	public basePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void reportLog(String status, String Description) {
		String s=status.toLowerCase();
		switch (s) {
		case "pass" : Selenium.test.get().log(Status.PASS, Description);
						break;
		case "fail" : Selenium.test.get().log(Status.FAIL, Description);
						break;
		case "info" : Selenium.test.get().log(Status.INFO, Description);
		}
		
		
	}

}
