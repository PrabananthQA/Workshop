package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qa.selenium.PreAndPost;

public class GuruLoginPage extends PreAndPost{
	public GuruLoginPage(EventFiringWebDriver driver) {
		this.driver = driver;	
	}
	public GuruLoginPage EnterUserId(String UserId) {
		type(locateElement("xpath", "//td[text()='UserID']/following::input[@name='uid']"),UserId);
		return this;
	}
	public GuruLoginPage EnterPassword(String Password) {
		type(locateElement("xpath", "//td[text()='Password']/following::input[@name='password']"),Password);
		return this;		
	}
	public GuruLoginPage clickLogin() {
		clickWithNoSnap(locateElement("xpath", "//input[@value='LOGIN']"));
		return this;
	}
	public GuruLoginPage VerifyLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(locateElement("xpath", "//td[contains(text(),'mngr311710')]")));
		String PageTitle = getTitle();
		System.out.println(PageTitle);
		{
			if (PageTitle.contains("Guru99 Bank Manager HomePage")) {
				System.out.println("Login successfull");
			}
			else 
			{
				System.out.println("Check Credentials");
			}
		}
		return this;
	}
}