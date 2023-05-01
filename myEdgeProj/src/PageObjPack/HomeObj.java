package PageObjPack;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctPageObjs.AbstarctUtils;

public class HomeObj extends AbstarctUtils{
	
	WebDriver myD = null;
	
	public HomeObj(WebDriver d) {
		super(d);
		this.myD = d;
		PageFactory.initElements(myD, this);
	}
	
	@FindBy(name = "q")
	WebElement searchBox;
	
	public void searchMe(String searchObj) {
		goHome();
		searchBox.sendKeys(searchObj + Keys.ENTER);
	}
}
