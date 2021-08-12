package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.AccountsPage;
import qa.selenium.PreAndPost;

public class AUT5 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT5";
		testDescription = "Verify Registration";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyRegistration() {
		new AccountsPage(driver)
		.ClickAccounts()
		.CreateAccount()
		.VerifyRegistration()
		.ClickTVandAdd()
		.VerifyWishlist();
	}
}