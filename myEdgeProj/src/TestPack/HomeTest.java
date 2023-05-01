package TestPack;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AbstractTests.BaseTests;
import PageObjPack.HomeObj;

public class HomeTest extends BaseTests{
	
	@Test
	public void testTextBox() throws InterruptedException {
		String Browser = "edge";
		String searchStr = "Hello Edge";
		WebDriver myD = initDriver(Browser);
		
		HomeObj ho = new HomeObj(myD);
		
		ho.searchMe(searchStr);
		
		Thread.sleep(5000);
		myD.quit();
	}
}
