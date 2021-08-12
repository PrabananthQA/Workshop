package qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import qa.selenium.PreAndPost;

public class Tablehandle extends PreAndPost{	
	public Tablehandle(EventFiringWebDriver driver){
	this.driver = driver;
}
public Tablehandle gettabledata() {
	
	ArrayList<String> Tblele = new ArrayList<String>();

	int n=0;
	for(int i=0;i<=n;i++) {
		String Tablexp = (locateElement("xpath", "//*[contains(@id,'task']/tbody/tr["+i+"]/td[2]")).getText();
		Tblele.add(Tablexp);
	}
	int Tsize = Tblele.size();
	if(Tsize==n) {
		System.out.println(Tblele);
	}
return this;
}
}

