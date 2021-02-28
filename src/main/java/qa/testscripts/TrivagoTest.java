package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.HomePage;
import qa.selenium.PreAndPost;

public class TrivagoTest extends PreAndPost {
	@BeforeTest
	public void beforeTest() {
		testCaseName = "S20-84";
		testDescription = "Automation For New Payment";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void Test01Trivago() {
		new HomePage(driver)
		.AcceptCookies()
		.EnterDestination("Agra")
		.CheckIn()
		.chooseTonight()
		.EnterNdaysasCheckout(5)
		.MemberDetails()
		.NoofChildren(2)
		.SelectChild1age("4")
		.Apply()
		.clickSearch()
		.RouteVerify();
	}
}
