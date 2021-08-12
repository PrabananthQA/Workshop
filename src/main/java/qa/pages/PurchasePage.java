package qa.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import qa.selenium.PreAndPost;

public class PurchasePage extends PreAndPost {
	public PurchasePage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public PurchasePage ClickAccounts() {
		clickWithNoSnap(locateElement("xpath", "//div[@class='account-cart-wrapper']//following-sibling::span[text()='Account']"));
		clickWithNoSnap(locateElement("xpath", "//li[@class='first']//following::a[text()='My Account']"));
		return this;
	}
	public PurchasePage EnterCredentials() {
		type(locateElement("xpath", "//input[@type='email']"),"roman@abc.com");
		type(locateElement("xpath", "//input[@title='Password']"),"demoguru");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Login']"));
		return this;
	}
	public PurchasePage Wishlist() {
		clickWithNoSnap(locateElement("xpath", "//a[text()='My Wishlist']"));
		clickWithNoSnap(locateElement("xpath", "//button[@title='Add to Cart']"));
		String wishmsg = locateElement("xpath", "//li[@class='success-msg']").getText();
		if(wishmsg.contains("LG LCD was added to your shopping cart.")) {
			System.out.println(wishmsg);
			clickWithNoSnap(locateElement("xpath", "//ul[@class='checkout-types top']//button[@title='Proceed to Checkout']"));
		}
		else
		{
			System.out.println("Check Wishlist");
		}
		return this;
	}
	public PurchasePage EnterShippingInfo() {
		type(locateElement("xpath", "//input[@title='Street Address']"),"Line 1");
		type(locateElement("xpath", "//input[@title='City']"),"New York");
		selectDropDownUsingVisibleText(locateElement("xpath", "//select[@title='State/Province']"),"New York");
		type(locateElement("xpath", "//input[@title='Zip']"),"542896");
		selectDropDownUsingVisibleText(locateElement("xpath", "//select[@title='Country']"),"United States");
		type(locateElement("xpath", "//input[@title='Telephone']"),"12345678");
		clickWithNoSnap(locateElement("xpath", "//button[@title='Continue']"));
		return this;
	}
	public PurchasePage VerifyShipping() {
		String Scost = locateElement("xpath", "//label[contains(text(),'Fixed')]//following::span[@class='price']").getText();
		int Shipcost = Integer.parseInt(Scost);
		System.out.println(Shipcost);
		if(Shipcost==5) {
			System.out.println("Flat Rate Shipping of $5 is generated");
		}
		else
		{
			System.out.println("Flat Rate Shipping in incorrect and is it"+Scost);
		}
		return this;
	}
	public PurchasePage CompleteOrder() {
		clickWithNoSnap(locateElement("xpath", "//button[@title='Continue']"));
		clickWithNoSnap(locateElement("xpath", "//label[contains(text(),'Check')]"));
		clickWithNoSnap(locateElement("xpath", "//button[@title='Continue']"));
		String aprice = locateElement("xpath", "//span[@class='cart-price']//span").getText();
		int ActualPrice = Integer.parseInt(aprice);
		String SPrice = locateElement("xpath", "//td[contains(text(),'Shipping')]//following::span[@class='price']").getText();
		int ShippingPrice = Integer.parseInt(SPrice);
		String GT = locateElement("xpath", "//*[text()='Grand Total']//following::span[@class='price']").getText();
		int GrandTotal = Integer.parseInt(GT);
		if(GrandTotal==ActualPrice+ShippingPrice) {
			System.out.println("Grand Total is verified");
		}
		else
		{
			System.out.println("Grand Total is incorrect");	
		}
		return this;

	}
}