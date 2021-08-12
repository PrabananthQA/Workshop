package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class DiscountCoupon extends PreAndPost {
	public DiscountCoupon(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public DiscountCoupon login() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='Account']"));
		clickWithNoSnap(locateElement("xpath", "//a[@title='Log In']"));
		locateElement("xpath", "//input[@type='email']").sendKeys("joestone@luci.com");
		locateElement("xpath", "//input[@type='password']").sendKeys("qwertyu");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Login']"));
		return this;
	}
	public DiscountCoupon IphoneDetails() {
		clickWithNoSnap(locateElement("xpath", "//a[text()='Mobile']"));
		String ActualPrice = locateElement("xpath", "(//a[@title='IPhone'])//following::span[@class='regular-price']").getText();
		System.out.println("Price before discount is "+ActualPrice);
		clickWithNoSnap(locateElement("xpath", "//a[@title='IPhone']//following::button[@title='Add to Cart']"));
		return this;
	}
	public DiscountCoupon ApplyDiscount() {
		locateElement("id", "coupon_code").sendKeys("GURU50");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Apply']"));
		String DiscountMsg = locateElement("xpath", "//li[@class='success-msg']").getText();
		String DiscountAmt = locateElement("xpath", "//td[contains(text(),'Discount')]//following::span[@class='price']").getText();
		if(DiscountMsg.contains("GURU50")) 
		{
			System.out.println(DiscountMsg+" successfully and"+"\n"+DiscountAmt+" is the discounted amount");
		}
		else 
		{
			System.out.println("Discount is not applied, recheck");
		}
		return this;
	}
}
