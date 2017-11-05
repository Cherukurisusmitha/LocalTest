package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Utils.AppIdentifiers;
import io.appium.java_client.android.AndroidDriver;
import tools.Themes;

public class TestCase_Themes {
	static tools.Themes themes;
  @Test(priority=0)
  public static void launchSetting() throws InterruptedException, IOException 
  {
	  Logger Log = Logger.getLogger(tools.Themes.class.getName());
	  Log.info("************THEMES TEST CASES *************");
	  AndroidDriver dr1= StartApplication.preconditions(Utils.AppIdentifiers.SettingsPackage,Utils.AppIdentifiers.SettingActivity);
	  themes =new tools.Themes(dr1); 
	  }
  @Test(priority=1)
  public static void Themes() throws InterruptedException
  {
  Thread.sleep(4000);
  themes.launchThemes();
  }
  @Test(priority=2)
  public static void choose() throws InterruptedException
  {
	  themes.selectThemes1();
  }
  @Test(priority=3)
  public static void apply()
  {
  }
  
  }

