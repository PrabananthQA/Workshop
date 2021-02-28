package qa.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import qa.utils.DataInputProvider;

public class PreAndPost extends WebDriverServiceImpl{
	
	public String dataSheetName;		
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		//for reports		
		startTestModule(nodes);
		test.assignAuthor(authors);
		test.assignCategory(category);
		
		startApp("chrome");
	
	}

	@AfterMethod
	public void afterMethod() {
		closeActiveBrowser();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name="fetchData", indices = 0)
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}
	
}
