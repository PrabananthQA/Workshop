package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.selenium.PreAndPost;

public class HomePage extends PreAndPost {
	public HomePage(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	public HomePage AcceptCookies() {
		WebElement ok = locateElement("xpath", "//button[text()='OK']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ok));
		clickWithNoSnap(ok);
		return this;
	}

	public HomePage EnterDestination(String Destinaiton) {
		type(locateElement("xpath", "//input[@placeholder='Enter a hotel name or destination']"),Destinaiton);
		return this;
	}
	public HomePage ChooseDestination() {
		clickWithNoSnap(locateElement("xpath", "//div[@class='ssg-suggestion__info']"));
		return this;
	}
	public HomePage CheckIn() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='Check in']"));
		return this;
	}
	public HomePage chooseTonight() {
		clickWithNoSnap(locateElement("xpath", "//label[text()='Tonight']"));
		return this;
	}

	public HomePage EnterNdaysasCheckout(int days)  {
		for(int i=0;i<=days;i++) {
			clickWithNoSnap(locateElement("xpath", "//div[contains(@class,'calendar-button-wrapper--checkout')]//button[contains(@class,'calendar-button-chevron--next')]"));
		}
		return this;
	}

	public HomePage MemberDetails() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='1 Room']"));
		return this;
	}
	public HomePage NoofChildren(int nchild) {
		for(int i=0;i<=nchild;i++) {
			clickWithNoSnap(locateElement("xpath", "//button[@data-role='addChild']"));
		}
		return this;
	}
	public HomePage SelectChild1age(String age) {
		WebElement chage = locateElement("xpath", "//select[@data-id='0']//option[text()='"+age+"']");
		clickWithNoSnap(chage);
		System.out.println(chage);
		return this;
	}
	public HomePage Apply() {
		clickWithNoSnap(locateElement("xpath", "//button[text()='Apply']"));
		return this;
	}
	public HomePage clickSearch() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='Search']"));
		return this;
	}
	public HomePage RouteVerify() {
		String title = driver.getTitle();
		if(title.contains("PriceRange") ) {
			System.out.println("Success");
		}
		else {
			System.out.println("Check it");
		}
		return this;

	}
}