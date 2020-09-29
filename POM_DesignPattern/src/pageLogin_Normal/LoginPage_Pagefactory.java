package pageLogin_Normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_Pagefactory {
	
	WebDriver driver;
	
	
	public LoginPage_Pagefactory(WebDriver driver1) {
		this.driver=driver1;
	}
	
	@FindBy(name="userName")// this annotation will be used in pagefactory
	@CacheLookup// it will store the web element in cache so that next time it will search in web page, it will take from this cache
	WebElement username;
	
	@FindBy(how=How.NAME,using="password")//using how we can inspect the webelement
	WebElement password;
	
	@FindBy(how=How.NAME,using="login")
	WebElement submit;
	
	@FindBy(how=How.LINK_TEXT,using="SIGN-OFF")
	WebElement logout;
	
	public void login(String uid,String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		submit.click();
		//logout.click();
		
		
	}

}
