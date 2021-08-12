package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class Gmmco extends PreAndPost {
	public Gmmco(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public Gmmco reachus() {
		clickWithNoSnap(locateElement("xpath", "//button[@class='close']"));
		clickWithNoSnap(locateElement("xpath", "//p[text()='Reach Us']"));
		clickWithNoSnap(locateElement("xpath", "//p[text()='Branch office]"));	
		return this;
	}
}