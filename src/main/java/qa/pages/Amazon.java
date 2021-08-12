package qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import qa.selenium.PreAndPost;

public class Amazon extends PreAndPost {
	public Amazon(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public Amazon GotoCart() throws InterruptedException {
		//clickWithNoSnap(locateElement("id", "nav-cart"));
		clickWithNoSnap(locateElement("xpath", "//img[contains(@alt,'Electronics clearance store')]"));
		clickWithNoSnap(locateElement("xpath", "//div[contains(@class,'bxc-grid__column')]//child::img[@alt='backpack']"));
		clickWithNoSnap(locateElement("id", "add-to-cart-button"));
		String AddedMsg = locateElement("xpath", "//h1[contains(text(),'Added to Cart')]").getText();
		if(AddedMsg.contains("Added to Cart")) {
			System.out.println("Item added successfully");
		}
		else
		{
			System.out.println("Item not added");
		}
		driver.navigate().back();
		Actions actions = new Actions(driver);
		actions. keyDown(Keys.LEFT_CONTROL)
		.contextClick(locateElement("xpath", "//a[contains(@class,'nav-hasArrow')]//child::span[contains(text(),'Audio')]"))
		.keyUp(Keys.LEFT_CONTROL)
				/* .build() */
		.perform();
		Thread.sleep(5000);
		return this;
	}
}