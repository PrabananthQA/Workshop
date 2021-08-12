package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class ColorCheck extends PreAndPost {
	public ColorCheck(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	public ColorCheck verifyColor() {
		String colr = locateElement("xpath", "//div[@class='info-content']").getCssValue("color");
		System.out.println(colr);
		return this;
	}
}