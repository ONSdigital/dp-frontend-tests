package testrunner;

import com.ons.dp.frontend.test.selenium.Browser;
import org.junit.AfterClass;


public class BaseTestRunner {
	@AfterClass
	public static void closeBrowser() {
		Browser.closeBrowser();
	}
}
