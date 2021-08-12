package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.SavePDFpage;
import qa.selenium.PreAndPost;

public class AUT7 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT7";
		testDescription = "PDF check";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void Verify() {
		new SavePDFpage(driver)
		.login()
		.ViewOrder()
		.PDFcheck();
	}
}

