package pageLogin_Normal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage_PageFatory_Testcase {
	
	WebDriver driver;
	
	Object[][] data;
	
	@BeforeMethod
	public void driverDetails(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\e3027405\\Downloads\\chromedriver.exe");
		//Open Chrome Browser
		driver=new ChromeDriver();
		//Get URL
		driver.get("http://newtours.demoaut.com/");
		}
	
	@Test(dataProvider="testdata")
	public void loginPageFactory(String uname,String passcode) {
		
		
		//using pagefactory, page or java class can be called for Test
		LoginPage_Pagefactory Test=PageFactory.initElements(driver, LoginPage_Pagefactory.class);
		//calling the method to peform the Test
		Test.login(uname, passcode);
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains("Find a Flight"));
		System.out.println("Test passed");
		
	}
		
		/*@Test(priority=1)
		public void loginnormal() {
		
		LoginPage_Normal Test1=PageFactory.initElements(driver, LoginPage_Normal.class);
		Test1.login_normal("vinoalphaq@gmail.com","Puspam@3118");
		}*/
		
		@AfterMethod
		public void broserclose() {
		driver.close();
		
	}
		@DataProvider(name="testdata")
		public Object[][] Testdata() throws IOException {
			
			data=readexcelData();
			
			return data;
		}
		
		public Object[][] readexcelData() throws IOException {
			
			File file=new File("C:\\vinoth\\Selenium\\Test Data_Excel\\Data_credential.xlsx");
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Sheet3");
			int rows=sheet.getLastRowNum();
			
			
			Object[][] credential=new Object[rows+1][2];
			
			for(int i=0;i<=rows;i++)
			{
				credential[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				credential[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			}
			
			return credential;
			
			
			
			
			}
		
		

}
