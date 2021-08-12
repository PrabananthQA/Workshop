package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.ColorCheck;
import qa.selenium.PreAndPost;

public class ColorsTest extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "ColorsTest";
		testDescription = "Verify Colors Test";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void GetColor() {
		new ColorCheck(driver)
		.verifyColor();
	}	
}