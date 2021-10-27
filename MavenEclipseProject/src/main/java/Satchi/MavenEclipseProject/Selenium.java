package Satchi.MavenEclipseProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


@SuppressWarnings("deprecation")
public class Selenium {

	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>() {
	      @Override
	      protected WebDriver initialValue()
	      {
	         return new ChromeDriver(); // can be replaced with other browser drivers
	      }
	   };
	   

	public static ExtentHtmlReporter html=new ExtentHtmlReporter("C:\\Users\\saran\\eclipse-workspace\\MavenEclipseProject\\STMExtentReport.html");
	//ExtentHtmlReporter(System.getProperty("C:\\Users\\saran\\eclipse-workspace\\MavenEclipseProject\\STMExtentReport.html"));
	  
	public static ThreadLocal<ExtentReports> report=new ThreadLocal<ExtentReports>() {
		  @Override
		  protected ExtentReports initialValue()
		  {
			  return new ExtentReports();
		  }
	};
	  
	  public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
}
