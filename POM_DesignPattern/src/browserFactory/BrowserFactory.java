package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	WebDriver driver;
	
	public WebDriver browserFactory(String browsername,String url) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\e3027405\\Downloads\\chromedriver.exe");
			//Open Chrome Browser
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\e3027405\\Downloads\\chromedriver.exe");
	//Open Gecko driver
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("no driver found");
			
		}
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		return driver;
	}

}
