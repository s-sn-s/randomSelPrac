package AbstractTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTests {
	
	
	public WebDriver initDriver(String browser) {
		
		WebDriver driver = null;
		
		if (browser.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		return driver;
	}
}
