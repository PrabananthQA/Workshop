package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class AccountsPage extends PreAndPost {
	public AccountsPage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public AccountsPage ClickAccounts() {
		clickWithNoSnap(locateElement("xpath", "//div[@class='account-cart-wrapper']//following-sibling::span[text()='Account']"));
		clickWithNoSnap(locateElement("xpath", "//li[@class='first']//following::a[text()='My Account']"));
		return this;
	}
	public AccountsPage CreateAccount() {
		clickWithNoSnap(locateElement("xpath", "//a[@title='Create an Account']"));
		type(locateElement("xpath", "//input[@title='First Name']"),"Adam");
		type(locateElement("xpath", "//input[@title='Last Name']"),"Zampa");
		type(locateElement("xpath", "//input[@title='Email Address']"),"adam@abc.com");
		type(locateElement("xpath", "//input[@title='Password']"),"zampaaa");
		type(locateElement("xpath", "//input[@title='Confirm Password']"),"zampaaa");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Register']"));
		return this;
	}
	public AccountsPage VerifyRegistration() {
		String Regmsg = locateElement("xpath", "//li[@class='success-msg']").getText();
		if(Regmsg.contains("Thank you for registering with Main Website Store.")) {
			System.out.println("Registration is done"+"\n"+"Registration message is:"+"\n"+Regmsg);	
		}
		else
		{
			System.out.println("Re-check the registration");
		}
		return this;
	}
	public AccountsPage ClickTVandAdd() {
		clickWithNoSnap(locateElement("xpath", "//a[text()='TV']"));
		clickWithNoSnap(locateElement("xpath", "//a[@title='LG LCD']//following::a[text()='Add to Wishlist']"));
		String tvsucsmsg = locateElement("xpath", "//li[@class='success-msg']").getText();
		if(tvsucsmsg.contains("LG LCD has been added to your wishlist")) {
			System.out.println("TV is added to wishlist"+"\n"+tvsucsmsg);
		}
		else
		{
			System.out.println("Re-check the wishlist");
		}

		return this;
	}
	public AccountsPage VerifyWishlist() {
		clickWithNoSnap(locateElement("xpath", "//button[@title='Share Wishlist']"));
		type(locateElement("xpath", "//textarea[@name='emails']"),"jonsnow@abc.com");
		clickWithNoSnap(locateElement("xpath", "//button[@type='submit']//span[text()='Share Wishlist']"));
		String wlmsg = locateElement("xpath", "//li[@class='success-msg']").getText();
		if(wlmsg.contains("Your Wishlist has been shared.")) {
			System.out.println(wlmsg);
		}
		else
		{
			System.out.println("Check wishlist sharing");
		}
		return this;
	}
}
