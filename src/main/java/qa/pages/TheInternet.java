package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class TheInternet  extends PreAndPost {
	public TheInternet(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public TheInternet Checkbox() {
		clickWithNoSnap(locateElement("xpath", "//a[text()='Checkboxes']"));
		boolean selected = locateElement("xpath", "//*[@id=\"checkboxes\"]/text()[2]").isSelected();
		if(selected == true) {
			System.out.println("Checkbox 2 is selected");
		}
		return this;
	}
}
