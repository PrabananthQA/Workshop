package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.MagentoPage;
import qa.selenium.PreAndPost;

public class AUT4 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT4";
		testDescription = "Verify Cart";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyCompare() {
		new MagentoPage(driver)
		.ClickOnMobile()
		.XperiaAddtoCompare()
		.IphoneAddtoCompare()
		.ClickCompare()
		.VerifyPopup()
		.closeAllBrowsers();
	}
}