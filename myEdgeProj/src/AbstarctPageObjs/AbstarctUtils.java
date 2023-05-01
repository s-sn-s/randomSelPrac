package AbstarctPageObjs;

import org.openqa.selenium.WebDriver;

public class AbstarctUtils {
	
	WebDriver d = null;
	
	public AbstarctUtils(WebDriver d) {
		this.d =d;
	}

	public void goHome() {
		d.get("https://google.com");
		d.manage().window().fullscreen();
	}
}
