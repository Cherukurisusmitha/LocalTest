package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Browser;
import tools.ChromeBrowser;

@Listeners(Utils.Listener.class)
public class ChromeBrowser_Test {
	public static AndroidDriver driver;
	public static ChromeBrowser CBrowser;
  @BeforeClass
  public static void launchBrowser() throws IOException, InterruptedException {
  	  driver = StartApplication.preconditions(AppIdentifiers.ChromePackage, AppIdentifiers.ChromeActivity);
  	CBrowser = new ChromeBrowser(driver);
	  Thread.sleep(1000);
//	  CBrowser.agreeTerms();
	  CBrowser.Browserinit();
	  Thread.sleep(1000);
	}
  @Test
  public void browserStandby() throws InterruptedException{
	  CBrowser.browsepage("www.python.org");
	  while(true){
		  for(int i=0;i<=10;i++)
		  {
			  CBrowser.newTab(); 
			  CBrowser.browsepage("www.mi.com");
			  Thread.sleep(5000);
			  
			  System.out.println("Tab number--"+i);
		  }
		  CBrowser.closeTabs();
		
	  }

  }
}
