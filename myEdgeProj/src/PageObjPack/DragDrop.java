package PageObjPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

public class DragDrop {
	static WebDriver d = new SafariDriver();
	static SoftAssert sa = new SoftAssert();
	
	public static void main(String[] args) throws InterruptedException {

		d.manage().window().maximize();
		
		d.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		moveElement("Oslo", "Norway");
		moveElement("Stockholm", "Sweden");
		moveElement("Washington", "States");
		moveElement("Copenhagen", "Denmark");
		moveElement("Seoul", "korea");
		moveElement("Rome", "Italy");
		moveElement("Madrid", "Spain");
		Thread.sleep(2000);
		moveElement("all", "all");
		Thread.sleep(2000);
		moveElement("Oslo", "Sweden");
		moveElement("Stockholm", "Norway");
		moveElement("Washington", "Denmark");
		moveElement("Copenhagen", "States");
		moveElement("Seoul", "Spain");
		moveElement("Rome", "korea");
		moveElement("Madrid", "Italy");
		Thread.sleep(2000);
		moveElement("all", "all");
		Thread.sleep(2000);
		moveElement("Oslo", "States");
		moveElement("Stockholm", "Sweden");
		moveElement("Washington", "Norway");
		moveElement("Copenhagen", "korea");
		moveElement("Seoul", "Denmark");
		moveElement("Rome", "Italy");
		moveElement("Madrid", "Spain");
		Thread.sleep(2000);
		moveElement("all", "all");
		Thread.sleep(2000);
		sa.assertAll();
		d.quit();
	}

	public static void moveElement(String cap, String nat) {
		// Capitals
		WebElement Oslo = d.findElement(By.xpath("//div[@id='box1']"));
		WebElement Stockholm = d.findElement(By.xpath("//div[@id='box2']"));
		WebElement Washington = d.findElement(By.xpath("//div[@id='box3']"));
		WebElement Copenhagen = d.findElement(By.xpath("//div[@id='box4']"));
		WebElement Seoul = d.findElement(By.xpath("//div[@id='box5']"));
		WebElement Rome = d.findElement(By.xpath("//div[@id='box6']"));
		WebElement Madrid = d.findElement(By.xpath("//div[@id='box7']"));

		// Countries
		WebElement Norway = d.findElement(By.xpath("//div[@id='box101']"));
		WebElement Sweden = d.findElement(By.xpath("//div[@id='box102']"));
		WebElement States = d.findElement(By.xpath("//div[@id='box103']"));
		WebElement Denmark = d.findElement(By.xpath("//div[@id='box104']"));
		WebElement korea = d.findElement(By.xpath("//div[@id='box105']"));
		WebElement Italy = d.findElement(By.xpath("//div[@id='box106']"));
		WebElement Spain = d.findElement(By.xpath("//div[@id='box107']"));
		
		// capital box
		WebElement dropbox = d.findElement(By.xpath("//div[@id='capitals']"));

		Actions a = new Actions(d);
		a.sendKeys(Keys.END);
		
		// reset capitals
		if (cap.equalsIgnoreCase("all") && nat.equalsIgnoreCase("all")) {
			
			List<WebElement> wel = new ArrayList<>();

			wel.add(Oslo);
			wel.add(Stockholm);
			wel.add(Washington);
			wel.add(Copenhagen);
			wel.add(Seoul);
			wel.add(Rome);
			wel.add(Madrid);

			for (WebElement we : wel) {
				a.clickAndHold(we).moveToElement(dropbox).release().perform();
			}

		} 
		else {
			Map<String, WebElement> capsMap = new HashMap<>();
			Map<String, WebElement> natsMap = new HashMap<>();

			capsMap.put("Oslo", Oslo);
			capsMap.put("Stockholm", Stockholm);
			capsMap.put("Washington", Washington);
			capsMap.put("Copenhagen", Copenhagen);
			capsMap.put("Seoul", Seoul);
			capsMap.put("Rome", Rome);
			capsMap.put("Madrid", Madrid);
			
			natsMap.put("Norway", Norway);
			natsMap.put("Sweden", Sweden);
			natsMap.put("States", States);
			natsMap.put("Denmark", Denmark);
			natsMap.put("korea", korea);
			natsMap.put("Italy", Italy);
			natsMap.put("Spain", Spain);
			
			a.clickAndHold(capsMap.get(cap)).moveToElement(natsMap.get(nat)).release().perform();
			sa.assertTrue(
					capsMap.get(cap).getCssValue("background-color")
					.equalsIgnoreCase("rgb(0, 255, 0)"));
		}
	}
}