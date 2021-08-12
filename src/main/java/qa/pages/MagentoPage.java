package qa.pages;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import qa.selenium.PreAndPost;

public class MagentoPage extends PreAndPost {
	public MagentoPage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	public MagentoPage TitleVerification() {
		String PageTitle = getTitle();
		System.out.println(PageTitle);
		try 
		{
			Assert.assertEquals("Home page", PageTitle);
		}
		catch (WebDriverException e) {
			reportStep("The Title: "+PageTitle+" is not matching with current PageTitle", "FAIL");
		}	    
		return this;
	}
	public MagentoPage ClickOnMobile() {
		clickWithNoSnap(locateElement("link", "MOBILE"));
		return this;
	}
	public MagentoPage SortBy() {
		WebElement SortBy = locateElement("xpath", "//select[@title='Sort By']");
		Select select = new Select(SortBy);
		clickWithNoSnap(SortBy);
		select.selectByVisibleText("Name");
		return this;
	}
	public MagentoPage VerifySort() {
		List<WebElement> elementlist = driver.findElements(By.xpath("//h2[@class='product-name']//a"));
		List<String> OriginalList = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("Original List \n"+OriginalList);
		List<String> SortedList = OriginalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List \n"+SortedList);
		Assert.assertTrue(OriginalList.equals(SortedList));
		return this;
	}
	public MagentoPage CompareXperiaPrice() {
		WebElement price = locateElement("xpath", "//a[@title='Sony Xperia']//following::span[@class='price']");
		String DisplayPrice = price.getText();
		System.out.println("Xperia Display Price is : "+DisplayPrice);
		clickWithNoSnap(locateElement("xpath", "//a[@title='Sony Xperia']"));
		WebElement price2 = locateElement("xpath", "//span[@class='price']");
		String ActualPrice = price2.getText();
		System.out.println("Xperia Actual Price is : "+ActualPrice);
		if(DisplayPrice.equals(ActualPrice)) {
			System.out.println("Prices are same where Display Prices is "+DisplayPrice+" and"+" Actual Price is "+ActualPrice);	
		}
		else {
			System.out.println("Prices are different where Display Prices is "+DisplayPrice+" and"+" Actual Price is "+ActualPrice);
		}
		return this;
	}
	public MagentoPage AddtoCart() {
		clickWithNoSnap(locateElement("xpath", "//a[@title='Sony Xperia']//following::span[text()='Add to Cart']"));
		return this;
	}
	public MagentoPage EnterQty() {
		type(locateElement("xpath", "//input[@title='Qty']"),"1000");
		clickWithNoSnap(locateElement("xpath", "//span[text()='Update']"));
		return this;
	}
	public MagentoPage ErrMsg() {
		String errormsg = locateElement("xpath", "//p[@class='item-msg error']").getText();
		System.out.println("Error message is"+"\n" +errormsg);
		return this;
	}
	public MagentoPage EmptyCart() {
		clickWithNoSnap(locateElement("xpath", "//span[text()='Empty Cart']"));
		return this;
	}
	public MagentoPage VerifyEmptyCart() {
		String Emptymsg = locateElement("xpath", "//div[@class='cart-empty']").getText();
		if(Emptymsg.contains("You have no items")) {
			System.out.println(Emptymsg);
		}
		else
		{
			System.out.println("Verify the cart");
		}
		return this;
	}
	public MagentoPage XperiaAddtoCompare() {
		clickWithNoSnap(locateElement("xpath", "//a[@title='Sony Xperia']//following::a[text()='Add to Compare']"));
		return this;
	}
	public MagentoPage IphoneAddtoCompare() {
		clickWithNoSnap(locateElement("xpath", "//a[@title='IPhone']//following::a[text()='Add to Compare']"));
		return this;
	}
	public MagentoPage ClickCompare() {
		clickWithNoSnap(locateElement("xpath", "//div[@class='actions']//following::button[@title='Compare']"));
		return this;
	}
	public MagentoPage VerifyPopup() {
		String mainwindow = driver.getWindowHandle();
		Set<String> mw = driver.getWindowHandles();
		Iterator<String> it = mw.iterator();
		while(it.hasNext()) {
			String cw = it.next();
			if(!mainwindow.equalsIgnoreCase(cw)){
				String popuptitle = driver.switchTo().window(cw).getTitle();
				System.out.println("New popup window title is"+"\n"+popuptitle);
			}
			WebElement xperia = locateElement("xpath", "//a[@title='Sony Xperia']");
			Assert.assertEquals(true, xperia.isDisplayed());
			WebElement iphone = locateElement("xpath", "//a[@title='IPhone']");
			Assert.assertEquals(true, iphone.isDisplayed());
		}
		return this;
	}
}