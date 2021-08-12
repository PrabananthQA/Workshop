package qa.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.pages.MagentoPage;
import qa.selenium.PreAndPost;

public class AUT3 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT3";
		testDescription = "Verify Cart";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyCart() {
		new MagentoPage(driver)
		.ClickOnMobile()
		.AddtoCart()
		.EnterQty()
		.ErrMsg()
		.EmptyCart()
		.VerifyEmptyCart();
	}
}
