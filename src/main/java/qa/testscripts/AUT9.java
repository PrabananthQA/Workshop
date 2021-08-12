package qa.testscripts;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.pages.DiscountCoupon;
import qa.selenium.PreAndPost;

public class AUT9 extends PreAndPost{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "AUT9";
		testDescription = "Discount check";
		nodes = "Test";
		authors = "Prabananth";
		category = "Testing";		
	}
	@Test
	public void VerifyDiscount() {
		new DiscountCoupon(driver)
		.login()
		.IphoneDetails()
		.ApplyDiscount();
	}
}