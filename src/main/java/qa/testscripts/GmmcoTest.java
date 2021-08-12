package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.Gmmco;
import qa.selenium.PreAndPost;

public class GmmcoTest extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "GmmcoTest";
		testDescription = "Gmmco Testing";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyGmmco() {
		new Gmmco(driver)
		.reachus();
	}
}

