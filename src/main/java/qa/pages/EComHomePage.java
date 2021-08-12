package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class EComHomePage extends PreAndPost {
	public EComHomePage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public EComHomePage myAccount() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='My Account']"));
		clickWithNoSnap(locateElement("xpath", "//a[text()='My Account']"));
		return this;
	}
	
}
