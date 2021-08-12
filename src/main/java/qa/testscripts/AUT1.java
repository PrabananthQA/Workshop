package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.MagentoPage;
import qa.selenium.PreAndPost;

public class AUT1 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT1";
		testDescription = "Verify Sorting";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifySorting() {
		new MagentoPage(driver).
		TitleVerification().
		ClickOnMobile().
		SortBy().
		VerifySort();
	}
}
