package pageLogin_Normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage_Testcase {
	
	WebDriver driver;
	
	@Test
	public void loginpage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\e3027405\\Downloads\\chromedriver.exe");
		//Open Chrome Browser
		driver=new ChromeDriver();
		//Get URL
		driver.get("http://newtours.demoaut.com/");
		
		LoginPage_Normal login=new LoginPage_Normal(driver);
		login.login_normal("vinoalphaq@gmail.com", "Puspam@3118");
		
		driver.close();
		
	}

}
