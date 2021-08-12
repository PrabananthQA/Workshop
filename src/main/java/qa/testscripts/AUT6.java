package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.PurchasePage;
import qa.selenium.PreAndPost;

public class AUT6 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT6";
		testDescription = "Verify Shipping process";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyShippingProcess() {
		new PurchasePage(driver)
		.ClickAccounts()
		.EnterCredentials()
		.Wishlist()
		.EnterShippingInfo()
		.VerifyShipping()
		.CompleteOrder();
	}
}