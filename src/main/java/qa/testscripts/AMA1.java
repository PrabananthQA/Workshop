package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.Amazon;
import qa.selenium.PreAndPost;

public class AMA1 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AMA1";
		testDescription = "Verify Cart";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyCart() throws InterruptedException {
		new Amazon(driver)
		.GotoCart();
	}
}
