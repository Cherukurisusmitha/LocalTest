package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Browser;

@Listeners(Utils.Listener.class)
public class BrowserDefaultShortcuts_Test {
	public static  AndroidDriver driver;
	static Browser browser;

	@BeforeClass
  public static void launchBrowser() throws IOException, InterruptedException {
		Logger log = Logger.getLogger(Browser.class.getName());
		log.info("***************** Browser Shortcut Test Start *****************");
  	  driver = StartApplication.preconditions(AppIdentifiers.BrowserPackage, AppIdentifiers.BrowserActivity);
	  browser = new Browser(driver);
	  Thread.sleep(3000);
//	  browser.agreeTerms();
	}
  @Test
  
  public void browserShortcuts() throws InterruptedException {
	  Thread.sleep(10000);
	  System.out.println("@@@@@@Test will start@@@@@@@@");
	  browser.defaultShortcuts(driver);
  }
}
