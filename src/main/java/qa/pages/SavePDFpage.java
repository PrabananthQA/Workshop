package qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import qa.selenium.PreAndPost;

public class SavePDFpage extends PreAndPost {
	public SavePDFpage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public SavePDFpage login() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='Account']"));
		clickWithNoSnap(locateElement("xpath", "//a[@title='Log In']"));
		locateElement("xpath", "//input[@type='email']").sendKeys("joestone@luci.com");
		locateElement("xpath", "//input[@type='password']").sendKeys("qwertyu");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Login']"));
		return this;
	}
	public SavePDFpage ViewOrder() {
		/*
		 * clickWithNoSnap(locateElement("xpath", "//a[@title='My Account']"));
		 * clickWithNoSnap(locateElement("xpath", "//a[text()='My Orders']"));
		 */
		clickWithNoSnap(locateElement("xpath", "//a[text()='View Order']"));
		clickWithNoSnap(locateElement("xpath", "//a[text()='Print Order']"));
		return this;
	}
	public SavePDFpage PDFcheck() {
		String mainwindow = driver.getWindowHandle();
		Set<String> mw = driver.getWindowHandles();
		Iterator<String> it = mw.iterator();
		while(it.hasNext()) {
			String cw = it.next();
			if(!mainwindow.equalsIgnoreCase(cw)){
				String popuptitle = driver.switchTo().window(cw).getTitle();
				System.out.println("New popup window title is"+"\n"+popuptitle);
				if(popuptitle.contains("Print Order")) {
					System.out.println("Pdf verified");
				}
				else {
					System.out.println("Recheck print process");
				}
			}
		}
		return this;
	}
}
