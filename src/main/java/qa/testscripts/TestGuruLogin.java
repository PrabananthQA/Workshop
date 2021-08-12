package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.GuruLoginPage;
import qa.selenium.PreAndPost;

public class TestGuruLogin extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "TC001";
		testDescription = "Automation For LoginPage";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void GuruLogin() {
		new GuruLoginPage(driver)
		.EnterUserId("mngr311710")
		.EnterPassword("Yqurara")
		.clickLogin()
		.VerifyLogin();
	}
}
