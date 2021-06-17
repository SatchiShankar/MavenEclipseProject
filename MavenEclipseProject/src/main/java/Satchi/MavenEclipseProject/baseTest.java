package Satchi.MavenEclipseProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;



@SuppressWarnings("deprecation")
public class baseTest {
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		//WebDriver driver;
		public WebDriver getDriver() {
				if (!Selenium.driver.get().toString().contains("null"))
					return Selenium.driver.get();
				else {
					
					 Selenium.driver.set(new ChromeDriver());
					 return Selenium.driver.get();
				}
		}
		
		
		@BeforeTest
		public void beforetest() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\saran\\Drivers\\chromedriver.exe");
			//ExtentReports extent=new ExtentReports();
			
					//extent.createTest(M.getName()).pass("Details");
			
		 //new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults"+myDateObj.format(myFormatObj).replace("-","").replace(" ", "").replace(":","")+".html");
			
		}
		
		@BeforeMethod
		public void beforeMethod(Method M) {
			
			Selenium.html.set(new ExtentHtmlReporter("C:\\Users\\saran\\eclipse-workspace\\MavenEclipseProject\\STMExtentReport.html"));
			Selenium.report.get().attachReporter(Selenium.html.get());
			Selenium.html.get().config().setCSS("css-string");
			Selenium.html.get().config().setDocumentTitle("Satchi Framework Results");
			Selenium.html.get().config().setEncoding("utf-8");
			Selenium.html.get().config().setJS("js-string");
			Selenium.html.get().config().setProtocol(Protocol.HTTPS);
			Selenium.html.get().config().setReportName("Satchi Framework Learning");
			Selenium.html.get().config().setTheme(Theme.DARK);
			Selenium.html.get().config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			
			Selenium.test.set(Selenium.report.get().createTest(M.getName()));
			
			
			
			getDriver().get("http://demo.guru99.com/V1/index.php#");
			getDriver().manage().window().maximize();
			/*
			 * Selenium.test.get().log(LogStatus.PASS, s);
			 * Selenium.test.get().log(LogStatus.PASS, "Navigated to the specified URL");
			 */

		}
		
		@AfterMethod
		public void afterMethod() {
			//WebDriver driver=this.getDriver();
			getDriver().quit();
		//	Selenium.report.get().endTest(Selenium.test.get());
			Selenium.report.get().flush();
		}
		
		@DataProvider(name="testData")//, parallel=true
		public Object[][] getdata(Method M) throws IOException{
			System.out.println(M.getName());
			System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
			
			String s1=this.getClass().getName();
			String[] s=s1.split("\\.");
			System.out.println(s.length);
			System.out.println(s[0]+"  "+s[1]);
			
				File file=new File("src/test/TestData/"+s[s.length-1]+".xlsx");
				FileInputStream fs= new FileInputStream(file) ;
				
				XSSFWorkbook ws = new XSSFWorkbook(fs);
				XSSFSheet sh= ws.getSheet("Sheet1");
				ws.close();
				int lastRowNum=sh.getLastRowNum();
				int lastCellNum=sh.getRow(0).getLastCellNum();
				System.out.println(sh.getTopRow());
								 
				 int testcasecol = 0;
				 for (int i = 0; i < lastCellNum; i++) {
					 if (sh.getRow(0).getCell(i).toString().equalsIgnoreCase("TestCaseName")){
						 testcasecol=i;
						 break;
					 }
				    }
				 int counter=0;
				 for (int i = 0; i <= lastRowNum; i++) {
					 if (sh.getRow(i).getCell(testcasecol).toString().equalsIgnoreCase(M.getName())){
						 counter++;
					 }
				    }
		
				 Object[][] obj = new Object[counter][1];
				 int counter1=0;
				 for (int i = 0; i <= lastRowNum; i++) {
					 
					 if(sh.getRow(i).getCell(testcasecol).toString().equals(M.getName())) {
						 Map<Object, Object> datamap = new HashMap<>();
				      for (int j = 0; j < lastCellNum; j++) {
					        datamap.put(sh.getRow(0).getCell(j).toString(), sh.getRow(i).getCell(j).toString());
					      }
				      obj[counter1][0] = datamap;
				      counter1++;
					 }
				 }
				 return  obj;
		}
		
		
}
