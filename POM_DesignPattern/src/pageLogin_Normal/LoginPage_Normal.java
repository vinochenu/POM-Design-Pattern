package pageLogin_Normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_Normal {
	
	WebDriver driver;
	
	public LoginPage_Normal(WebDriver driver1) {
		this.driver=driver1;
	}
		
		public void login_normal(String uid,String pass)
		{
			driver.findElement(By.name("userName")).sendKeys(uid);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.name("login")).click();
			
			
		}
		
		
		
	}


