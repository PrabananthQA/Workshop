package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.TheInternet;
import qa.selenium.PreAndPost;

public class TheInternetTest extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "The Internet Test";
		testDescription = "Verify Checkbox";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyCheckbox() {
		new TheInternet(driver)
		.Checkbox();
	}
}